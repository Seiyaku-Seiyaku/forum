package com.forum.backend.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtils {
    // 密钥（实际项目中应该放在配置文件中）
    private val secret = "mySecretKeyForForumProject2024!@#$%^&*()_+"
    private val key = Keys.hmacShaKeyFor(secret.toByteArray())

    // Token 有效期：24小时
    private val expiration = 24 * 60 * 60 * 1000L

    /**
     * 生成 Token
     * @param userId 用户ID
     * @param username 用户名
     */
    fun generateToken(userId: Long, username: String): String {
        val now = Date()
        val expiryDate = Date(now.time + expiration)

        return Jwts.builder()
            .setSubject(userId.toString())
            .claim("username", username)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    /**
     * 从 Token 中获取用户ID
     */
    fun getUserIdFromToken(token: String): Long {
        val claims = parseToken(token)
        return claims.subject.toLong()
    }

    /**
     * 从 Token 中获取用户名
     */
    fun getUsernameFromToken(token: String): String {
        val claims = parseToken(token)
        return claims["username"] as String
    }

    /**
     * 验证 Token 是否有效
     */
    fun validateToken(token: String): Boolean {
        return try {
            parseToken(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun parseToken(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
    }


}