package com.andrew.springcassandrademo.domain.repository

import com.andrew.springcassandrademo.domain.entity.UserMovieView
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserMovieViewRepository : CassandraRepository<UserMovieView, String> {
    fun deleteAllByUserId(userId: String)

    fun findAllByUserId(movieId: String): List<UserMovieView>

    @Query(
        value = "select user_id, movie_id, moviegenre, moviename, username  from usermovieview where user_id = ?0 and moviename = ?1 allow filtering",
        allowFiltering = true
    )
    fun findUserMovieViewsByUserIdAndMovieNameContains(userId: String, movieNamePhrase: String): List<UserMovieView>
}
