package com.andrew.springcassandrademo.rest

import com.andrew.springcassandrademo.domain.entity.UserMovieView
import com.andrew.springcassandrademo.service.ViewHistoryService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/view")
class ViewHistoryController(
    private val viewHistoryService: ViewHistoryService
) {
    @PostMapping("/user")
    fun addMovieToViewedForUser(@RequestBody request: AddMovieToViewedRequest): AddMovieToViewedResponse {
        return viewHistoryService.addMovieToViewed(request);
    }

    @GetMapping("/user")
    fun getViewedMoviesByUser(userId: String): List<UserMovieView> {
        return viewHistoryService.getUserViews(userId)
    }

    @DeleteMapping("/user")
    fun clearViewHistory(userId: String) {
        viewHistoryService.clearUserViewHistory(userId)
    }
}