package com.andrew.springcassandrademo

import com.fasterxml.jackson.annotation.JsonProperty
import mu.KLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

interface ExternalUserClient {
    fun findUserById(userId: String): UserResponse?
}

@Service
class MockExternalUserClient() : ExternalUserClient {
    @Cacheable(value = ["user"])
    override fun findUserById(userId: String): UserResponse? {
        logger.info { "Get user by userid: $userId" }

        return when (userId) {
            "1" -> UserResponse("1", "John Doe")
            "2" -> UserResponse("2", "Jack Doe")
            else -> null
        }
    }
    
    companion object: KLogging()
}

data class UserResponse(
    val userId: String,
    val userName: String,
)