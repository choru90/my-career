package com.career.my

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyCareerApplication

fun main(args: Array<String>) {
	runApplication<MyCareerApplication>(*args)
}
