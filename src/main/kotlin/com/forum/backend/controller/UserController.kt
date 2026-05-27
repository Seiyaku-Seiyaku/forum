package com.forum.backend.controller

import com.forum.backend.service.UserService
import com.forum.backend.util.JwtUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val jwtUtils: JwtUtils,
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(
        @RequestParam username: String,
        @RequestParam password: String
    ): Map<String, Any> {
        val success = userService.register(username, password)
        return if (success) {
            mapOf(
                "code" to 200,
                "message" to "注册成功"
            )
        } else {
            mapOf(
                "code" to 400,
                "message" to "用户名已存在"
            )
        }
    }

    @PostMapping("/login")
    fun login(
        @RequestParam username: String,
        @RequestParam password: String
    ): Map<String, Any> {
        val userId = userService.login(username, password)

        return if (userId != null) {
            // 生成 Token
            val token = jwtUtils.generateToken(userId, username)
            mapOf(
                "code" to 200,
                "message" to "登录成功",
                "data" to mapOf(
                    "token" to token,
                    "userId" to userId,
                    "username" to username
                )
            )
        } else {
            mapOf(
                "code" to 401,
                "message" to "用户名或密码错误"
            )
        }
    }
}