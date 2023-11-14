package com.andrew.springcassandrademo.service

import com.andrew.springcassandrademo.domain.entity.UserMovieView
import com.andrew.springcassandrademo.domain.repository.UserMovieViewRepository
import com.andrew.springcassandrademo.rest.AddMovieToViewedRequest
import com.andrew.springcassandrademo.rest.AddMovieToViewedResponse
import org.springframework.stereotype.Component

@Component
class ViewHistoryService(
    private val userMovieViewRepository: UserMovieViewRepository,
) {
    fun getUserViews(userId: String): List<UserMovieView> {
        return userMovieViewRepository.findAllByUserId(userId)
    }

    fun addMovieToViewed(request: AddMovieToViewedRequest): AddMovieToViewedResponse {
        val movieView = UserMovieView(
            movieId = request.movieId,
            movieName = request.movieName,
            userId = request.userId,
        )
        val saved = userMovieViewRepository.save(movieView)
        return AddMovieToViewedResponse(saved.movieId)
    }

    fun clearUserViewHistory(userId: String) {
        userMovieViewRepository.deleteAllByUserId(userId)
    }
    
    

}
