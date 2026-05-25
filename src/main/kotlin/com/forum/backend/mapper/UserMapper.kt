package com.forum.backend.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.forum.backend.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User> {
    // BaseMapper 已经提供了基本的 CRUD 方法
}