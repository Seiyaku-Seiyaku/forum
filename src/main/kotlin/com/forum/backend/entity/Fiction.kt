package com.forum.backend.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime

@TableName("fiction")
data class Fiction(
    @TableId(type = IdType.AUTO)
    var id: Long? = null,
    var title: String = "",
    var content: String = "",
    var authorId: Long = 0,
    var fandom: String = "综合",
    var likeCount: Int = 0,
    var createTime: LocalDateTime = LocalDateTime.now(),
    var updateTime: LocalDateTime = LocalDateTime.now()
)