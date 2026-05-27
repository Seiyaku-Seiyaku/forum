package com.forum.backend.service

import com.forum.backend.entity.Fiction
import com.forum.backend.mapper.FictionMapper
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FictionService(
    private val fictionMapper: FictionMapper
) {

    /**
     * 发布文章
     */
    fun publish(authorId: Long, title: String, content: String, fandom: String = "综合"): Long {
        val fiction = Fiction(
            title = title,
            content = content,
            authorId = authorId,
            fandom = fandom,
            likeCount = 0,
            createTime = LocalDateTime.now(),
            updateTime = LocalDateTime.now()
        )
        fictionMapper.insert(fiction)
        return fiction.id ?: 0
    }
}