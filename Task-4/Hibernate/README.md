# Task 4 - Hibernate

Use important Hibernate annotation to design a database table (entity) with at least 10 fields.

## Dependencies (Maven)

- [Hibernate](https://hibernate.org/orm/): JPA compliant ORM
- [PostgreSQL (driver)](https://jdbc.postgresql.org/): Opensource SQL/Relational Database
- [Jakarta Persistence API](https://github.com/jakartaee/persistence/): Entity annotations library
- [Lombok](https://projectlombok.org/): Getters/Setters automation
- [Logback](https://logback.qos.ch/): Logging library alongside SLF4J

## Project Details

I set up a locally hosted Postgres instance and configure Hibernate to connect with it using the persistence.xml file.

I also use Lombok to speed up Entity modelling instead of having to manually write getters and setters for each entity
field. 

The project uses annotations from the Jakarta Persistence package such as `@Column`, `@Id`, and `@Table`, and in the Main
method I manually perform (commit) from database transactions.