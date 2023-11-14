# spring-cassandra-demo
Sample application with Cassandra


How to create simple keyspace:
```sql
CREATE  KEYSPACE  sample
WITH REPLICATION = { 'class' : 'SimpleStrategy'}
AND DURABLE_WRITES =  true ;
```