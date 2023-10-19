package com.andrew.springcassandrademo.rest

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ViewHistoryController {
    @PostMapping()
    fun addMovieToViewedForUser(){}
    
    @GetMapping()
    fun getViewedMoviesByUser(){}
    
    @DeleteMapping
    fun clearViewHistory(){}
}