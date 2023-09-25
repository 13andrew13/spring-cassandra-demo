package com.andrew.springcassandrademo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val sampleService: SampleService
) {
    
    @PostMapping("/sample")
    fun createSample(key: String, value: String): Sample{
        return sampleService.createSample(key, value)
    }
    
    @GetMapping("/sample")
    fun getSamplesByKey(): ResponseEntity<List<Sample>>{
        return ResponseEntity.ok(sampleService.getAllSample())
    }
} 