package com.andrew.springcassandrademo.domain.entity

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table

@Table
data class UserMovieView(
    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED)
    val userId: String,
    @PrimaryKeyColumn(name = "movie_id", type = PrimaryKeyType.CLUSTERED)
    val movieId: String,
    @Column("moviename")
    val movieName: String,
    @Column("moviegenre")
    val movieGenre: String,
    @Column("username")
    val userName: String,
)
