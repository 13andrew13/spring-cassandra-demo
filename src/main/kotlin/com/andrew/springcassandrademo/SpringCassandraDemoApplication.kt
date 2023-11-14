package com.andrew.springcassandrademo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@SpringBootApplication
@EnableCassandraRepositories
class SpringCassandraDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringCassandraDemoApplication>(*args)
}
