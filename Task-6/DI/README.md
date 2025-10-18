# Task 6 - Dependency Injection

Practice Dependency Injection using constructors and setters and fields.

## Dependencies (Maven)

- [Spring Web](https://github.com/spring-projects/spring-framework/): Starter for building web, including RESTful, applications using Spring MVC.
- [Spring Data JPA](https://projects.spring.io/spring-data-jpa/): Spring Data module for JPA repositories.
- [Spring Validation](https://spring.io/projects/spring-boot/): Starter for using Java Bean Validation with Hibernate Validator.
- [SpringBoot Dev Tools](https://spring.io/projects/spring-boot/): Spring Boot Developer Tools.
- [Spring Security Crypto](	https://spring.io/projects/spring-security/): Spring Security Crypto Module.
- [Hibernate](https://hibernate.org/orm/): Hibernate's core ORM functionality.
- [SpringDoc OpenAPI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui/): SpringDoc OpenAPI Starter WebMVC UI.
- [PostgreSQL (driver)](https://jdbc.postgresql.org/): PostgreSQL JDBC Driver Postgresql.
- [Lombok](https://projectlombok.org/): Lombok is a Java library that provides annotations to simplify Java development by automating the generation of boilerplate code.

## Database Configuration

The project uses Spring's data JPA which uses Hibernate as the JPA provider. In the application properties you can set connection credentials such as username, password, database url etc:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
```

Replace the template with your own credentials or use system environment variables.