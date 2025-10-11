# Task 5 - Flyway Migrations

Show Implementation to Database Migration using Flyway. You can make use of a DB from the previous progress report.

## Approach

This project demonstrates how to set up a Spring Boot application with Flyway and Hibernate. The database is configured using the `application.properties` file and Flyway dumps migrations in the `db/migrations` directory.

## Environment Variables

The project uses PostgreSQL, you can add in your database environment variables like so:

```shell
export DB_USER=postgres
export DB_PASS=your_pass
```