# dc-sb-prom
Spring Boot DevContainer w PostgreSQL DB, Adminer and Prometheus.

* Java part based on [this description](https://spring.io/guides/gs/spring-boot/).   
* Generate [with this call](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.5&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web)   
* [JPA Stuff like described here](https://spring.io/guides/gs/accessing-data-jpa/).   
https://www.baeldung.com/spring-boot-h2-database
* [Spring Boot, JPA/Hibernate, PostgreSQL example: CRUD](https://www.bezkoder.com/spring-boot-postgresql-example/)
* [Generate Database Schema with Spring Data JPA](https://www.baeldung.com/spring-data-jpa-generate-db-schema)
* [Generating the database schema in a Spring Boot application](https://bootify.io/spring-data/database-generation-with-hibernate-liquibase-flyway.html)

## Links
* [App](http://localhost:8080)
* [App](http://localhost:8823)
* [Prometheus](http://localhost:8821/)
  * [All 404 Requests/1h](http://localhost:8821/graph?g0.expr=http_server_requests_seconds_count%7Bstatus%3D%22404%22%7D&g0.tab=1&g0.stacked=0&g0.show_exemplars=0&g0.range_input=1h)
* [Adminer](http://localhost:8820/?pgsql=db&username=postgres&password=postgres&db=genericSBDB)

* https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate