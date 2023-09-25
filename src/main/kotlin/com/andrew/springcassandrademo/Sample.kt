package com.andrew.springcassandrademo

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table

@Table
data class Sample(
    @PrimaryKeyColumn(
        value = "key",
        type = PrimaryKeyType.PARTITIONED
    )
    val key: String,
    @Column(value = "value")
    val value: String,
)
