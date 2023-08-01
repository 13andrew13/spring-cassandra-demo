package com.andrew.springcassandrademo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCassandraDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringCassandraDemoApplication>(*args)
}
