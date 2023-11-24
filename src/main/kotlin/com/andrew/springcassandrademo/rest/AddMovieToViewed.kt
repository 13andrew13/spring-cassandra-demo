package com.andrew.springcassandrademo.rest

data class AddMovieToViewedRequest(
    val userId: String,
    val movieId: String,
)

data class AddMovieToViewedResponse(
    val movieId: String,
)