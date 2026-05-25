package com.forum.backend.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime

@TableName("user")
data class User(
    @TableId(type = IdType.AUTO)
    var id: Long? = null,
    var username: String = "",
    var password: String = "",
    var avatar: String? = null,
    var createTime: LocalDateTime = LocalDateTime.now()
)