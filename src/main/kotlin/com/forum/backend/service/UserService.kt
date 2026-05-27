package com.forum.backend.service

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.forum.backend.entity.User
import com.forum.backend.mapper.UserMapper
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userMapper: UserMapper) {
    private val passwordEncoder = BCryptPasswordEncoder()

    /**
     * 用户注册
     * @return true=注册成功，false=用户名已存在
     */
    fun register(username: String, rawPassword: String): Boolean {
        // 1. 检查用户名是否已存在
        val existingUser = userMapper.selectOne(
            QueryWrapper<User>().eq("username", username)
        )
        if (existingUser != null) {
            return false
        }

        // 2. 密码加密
        val encodedPassword = passwordEncoder.encode(rawPassword)

        // 3. 创建新用户
        val user = User(
            username = username,
            password = encodedPassword
        )

        // 4. 保存到数据库
        userMapper.insert(user)
        return true
    }


    /**
     * 用户登录
     * @return 登录成功返回 userId，失败返回 null
     */
    fun login(username: String, rawPassword: String): Long? {
        // 1. 根据用户名查询用户
        val user = userMapper.selectOne(
            QueryWrapper<User>().eq("username", username)
        )

        // 2. 用户不存在
        if (user == null) {
            return null
        }

        // 3. 验证密码
        val matches = passwordEncoder.matches(rawPassword, user.password)

        // 4. 密码错误
        if (!matches) {
            return null
        }

        // 5. 登录成功，返回用户ID
        return user.id
    }
}