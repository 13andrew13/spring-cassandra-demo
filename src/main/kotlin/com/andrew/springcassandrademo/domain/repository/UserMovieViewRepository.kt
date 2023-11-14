package com.andrew.springcassandrademo.domain.repository

import com.andrew.springcassandrademo.domain.entity.UserMovieView
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMovieViewRepository : CassandraRepository<UserMovieView, String> {
    fun deleteAllByUserId(userId: String)

    fun findAllByUserId(movieId: String): List<UserMovieView>
}
