# Match Management API
Match management REST API using Spring Boot

## Instructions

1. Clone the repository to your local machine. </br>Ensure you have **Java 21**, **Maven**, and **PostgreSQL** installed.
2. Update the database credentials in `application.yml`.
3. Run the app using maven with `mvn spring-boot:run` or using your preferred IDE.
4. While the app is running, you can:
   1. Access the app's endpoints [via browser](http://localhost:8080), `cURL`, or any API client of your choice. </br>A list of available endpoints (as JSON) can be found [here](https://github.com/ZapDos7/match-management-demo/tree/main/src/main/resources/endpoints).
   2. Explore the interactive API documentation via [Swagger](http://localhost:8080/swagger-ui.html) for more info.
   3. Check the application's health status using the [Actuator health check endpoint](http://localhost:8080/actuator/health)

## Overview

### Entities
The app defines two entities, `Match` and their `MatchOdds` (1-to-N relationship). 

A `Match` object contains info regarding a match, namely two participating teams' names, the date & time of the match, the sport & a brief description.

A `MatchOdds` object represents a specific betting odd for a given match, based on a betting condition (called a specifier). It defines the probability and potential payout for a particular outcome of the match.

The tables:

![image](https://github.com/user-attachments/assets/6ae92049-f298-4108-894c-3f4600c76413)

### API
The application supports the following operations:
1. Get
   1. Get all matches (pageable, sorted by date asc/desc optionally)
   2. Get a match's details
2. Create
   1. Create a new match
   2. Add odds to a match
3. Update
   1. Update a match's info
4. Delete
   1. Delete a match
   2. Delete a match's specific odd
   3. Delete all odds of a match
   4. Delete all matches
  
### Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Boot Web
- Spring Boot Validation tools
- PostgreSQL & flyway
- Actuator (health monitoring)
- Maven
- Swagger
- Testing: Mockito, JUnit, Spring Boot Testing tools
- Tools: IntelliJ IDEA, DBeaver, Bruno

### Future Improvements 
- [ ] Docker setup
