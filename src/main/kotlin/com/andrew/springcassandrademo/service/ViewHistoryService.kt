package com.andrew.springcassandrademo.service

import com.andrew.springcassandrademo.ExternalMovieClient
import com.andrew.springcassandrademo.ExternalUserClient
import com.andrew.springcassandrademo.domain.entity.UserMovieView
import com.andrew.springcassandrademo.domain.repository.UserMovieViewRepository
import com.andrew.springcassandrademo.rest.AddMovieToViewedRequest
import com.andrew.springcassandrademo.rest.AddMovieToViewedResponse
import org.springframework.stereotype.Component

@Component
class ViewHistoryService(
    private val userMovieViewRepository: UserMovieViewRepository,
    private val userClient: ExternalUserClient,
    private val movieClient: ExternalMovieClient
) {
    fun getUserViews(userId: String): List<UserMovieView> {
        return userMovieViewRepository.findAllByUserId(userId)
    }

    fun addMovieToViewed(request: AddMovieToViewedRequest): AddMovieToViewedResponse {
        val user = userClient.findUserById(request.userId)
            ?: throw IllegalArgumentException("Failed to find user by ${request.userId}")
        val movie = movieClient.findMovieById(request.movieId)
            ?: throw IllegalArgumentException("Failed to find film by ${request.movieId}")
        
        val movieView = UserMovieView(
            movieId = request.movieId,
            movieName = movie.movieName,
            movieGenre = movie.genreName,
            userId = user.userId,
            userName = user.userName,
        )
        val saved = userMovieViewRepository.save(movieView)
        
        return AddMovieToViewedResponse(saved.movieId)
    }

    fun clearUserViewHistory(userId: String) {
        userMovieViewRepository.deleteAllByUserId(userId)
    }


}
