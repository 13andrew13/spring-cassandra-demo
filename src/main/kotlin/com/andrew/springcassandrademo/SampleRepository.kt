package com.andrew.springcassandrademo

import org.springframework.data.cassandra.repository.CassandraRepository

interface SampleRepository : CassandraRepository<Sample, String> 
