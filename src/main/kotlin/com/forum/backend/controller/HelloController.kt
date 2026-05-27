package com.forum.backend.controller

import com.forum.backend.mapper.FictionMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(private val fictionMapper: FictionMapper) {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, Forum!"
    }

    @GetMapping("/fictions")
    fun getFictions(): List<com.forum.backend.entity.Fiction> {
        return fictionMapper.selectList(null)
    }
}