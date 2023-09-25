package com.andrew.springcassandrademo

import org.springframework.stereotype.Service

@Service
class SampleService(
    private val repository: SampleRepository
) {

    fun createSample(key: String, value: String): Sample {
        val sample = Sample(
            key = key,
            value = value,
        )
        return repository.save(sample)
    }

    fun getAllSample(): List<Sample> {
        return repository.findAll().toList()
    }
}