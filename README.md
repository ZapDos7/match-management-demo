# Match Management API
Match management REST API using Spring Boot

## Instructions

1. Clone the code to a local machine with Java 21, maven & PostgreSQL installed.
2. Update database credentials in `application.yml`
3. Run the app with `mvn spring-boot:run` or using your preferred IDE.
4. Visit the app's endpoints [via browser](http://localhost:8080/matches), cURL, or using Postman or any such tool of your preference.
5. Visit the app's [swagger documentation page](http://localhost:8080/swagger-ui.html) for more info.

#### Next Steps
- [x] Return custom resources instead of entities 
- [x] Functionality: return all match odds per match
- [x] Page instead of list in Controller getters, also sorting
- [ ] Validations & Error handling
- [ ] Testing
- [ ] Introduction of Docker
- [ ] Functionality: edit match odd per id/specifier