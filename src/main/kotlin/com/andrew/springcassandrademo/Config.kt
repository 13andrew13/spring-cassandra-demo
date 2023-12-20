package com.andrew.springcassandrademo

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair
import java.time.Duration


@Configuration
class Config {

    @Bean
    fun objectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.findAndRegisterModules()
        return mapper
    }


    @Bean
    fun redisCacheManagerBuilderCustomizer(redisConnectionFactory: RedisConnectionFactory): RedisCacheManagerBuilderCustomizer {
        return RedisCacheManagerBuilderCustomizer { builder: RedisCacheManagerBuilder ->
            builder
                .cacheWriter(RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory))
                .withCacheConfiguration(
                    "user",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(10))
                        .serializeValuesWith(
                            SerializationPair.fromSerializer(
                                Jackson2JsonRedisSerializer(
                                    objectMapper(),
                                    UserResponse::class.java
                                )
                            )
                        )
                )
                .withCacheConfiguration(
                    "movie",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(5))
                        .serializeValuesWith(
                            SerializationPair.fromSerializer(
                                Jackson2JsonRedisSerializer(
                                    objectMapper(),
                                    MovieResponse::class.java
                                )
                            )
                        )
                )
        }
    }
}