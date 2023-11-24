package com.andrew.springcassandrademo

import mu.KLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

interface ExternalMovieClient {
    fun findMovieById(movieId: String): MovieResponse?
}

@Service
class MockExternalMovieClient() : ExternalMovieClient {
    @Cacheable(value = ["movie"])
    override fun findMovieById(movieId: String): MovieResponse? {

        logger.info { "Get movie by movieId: $movieId" }

        return when (movieId) {
            "1" -> MovieResponse("1", "Silicon Valley", "sitcom", "Description")
            "2" -> MovieResponse("2", "Interstellar", "fantastic", "Description")
            "3" -> MovieResponse("3", "Cursed Island", "thriller", "Description")
            else -> null
        }
    }
    
    companion object: KLogging()

}

data class MovieResponse(
    val movieId: String,
    val movieName: String,
    val genreName: String,
    val description: String,
)
