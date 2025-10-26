## Task 7 -  Implementing REST Resource Endpoints

Declaring resource endpoints, capturing parameters, returning responses from endpoints,
service injections, handling errors, input validation, securing a resource endpoint,
providing a REST API specification.

### Deliverable

Create a spring boot application with at least 4 endpoints, implement exception handling,
validate inputs and create a service, repository and controller layer.

### Dependencies

- [Spring Boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/)
- [Spring Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation/)
- [Spring Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/)
- [Spring Devtools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools/)
- [PostgreSQL JDBC Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql/)
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/)
- [Flyway](https://mvnrepository.com/artifact/org.flywaydb/flyway-core/)
- [Spring Doc OpenAPI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui/)

### Configuration

The only required configurations are environment variables:

- `DB_URL`: Database remote or local connection URL.
- `DB_USER`: Database user.
- `DB_PASS`: Database password.

### Details

- This project follows standard structure by separating code into controllers, repositories, and services layers.
- I have implemented a global exception handler that handles both request body and validation errors.
- The project represents database entities under the `models` folder with the appropriate foreign and primary key constraints.
- I have a repository layer under the `repositories` folder that extend the Jpa repository interface for both entities.
- Request and Response specific details are contained in the controllers, while business logic is kept in services.
- Data Transfer Objects (Dtos) are used for creating and updating resources.