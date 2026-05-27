package com.forum.backend.controller

import com.forum.backend.service.FictionService
import com.forum.backend.util.JwtUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fiction")
class FictionController(
    private val fictionService: FictionService,
    private val jwtUtil: JwtUtils
) {

    @PostMapping
    fun publish(
        @RequestHeader("Authorization") authorization: String,
        @RequestParam title: String,
        @RequestParam content: String,
        @RequestParam(required = false, defaultValue = "综合") fandom: String
    ): Map<String, Any> {
        // 1. 验证 Token
        val token = authorization.removePrefix("Bearer ").trim()
        if (!jwtUtil.validateToken(token)) {
            return mapOf(
                "code" to 401,
                "message" to "Token 无效或已过期"
            )
        }

        // 2. 从 Token 获取用户ID
        val userId = jwtUtil.getUserIdFromToken(token)

        // 3. 发布文章
        val fictionId = fictionService.publish(userId, title, content, fandom)

        return mapOf(
            "code" to 200,
            "message" to "发布成功",
            "data" to mapOf(
                "fictionId" to fictionId
            )
        )
    }
}