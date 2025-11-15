# Task 1 - SpringBoot Setup

A basic Spring Boot application with database connectivity, built with Maven.

## Tech Stack
- **Spring Boot** - Java framework
- **Spring Web** - REST API support
- **Spring Data JPA** - Database operations
- **H2 Database** - Embedded database
- **Maven** - Build tool

## Prerequisites
- Java 17+
- Maven 3.6+

## Running the Application

After git cloning the project, run the application with:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Database Access
H2 Console: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave empty)
