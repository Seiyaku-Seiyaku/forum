package com.forum.backend

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.forum.backend"])
@MapperScan("com.forum.backend.mapper")
class BackendApplication

fun main(args: Array<String>) {
	runApplication<BackendApplication>(*args)
}
