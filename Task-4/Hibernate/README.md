# Task 4 - Hibernate

Use important Hibernate annotation to design a database table (entity) with at least 10 fields.

## Dependencies (Maven)

- [Hibernate](https://hibernate.org/orm/): JPA compliant ORM.
- [PostgreSQL (driver)](https://jdbc.postgresql.org/): Opensource SQL/Relational Database.
- [Jakarta Persistence API](https://github.com/jakartaee/persistence/): Entity annotations library.
- [Jakarta Bean Validation API](https://beanvalidation.org/): For application level Entity validation.
- [Lombok](https://projectlombok.org/): Getters/Setters automation.
- [Logback](https://logback.qos.ch/): Logging library alongside SLF4J.

## Project Details

I set up a locally hosted Postgres instance and configure Hibernate to connect with it using the persistence.xml file.

I also use Lombok to speed up Entity modelling instead of having to manually write getters and setters for each entity
field. 

The project uses annotations from the Jakarta Persistence package such as `@Column`, `@Id`, and `@Table`, and in the Main
method I manually perform (commit) database transactions.

## Setup Database Connection

Set database connection details in shell environment variables like so:

```sh
export DB_URL="jdbc:postgresql://localhost:5432/postgres"
export DB_USER="postgres"
export DB_PASS="<your_password>"
```

## Database Schema

I decided to model entities for a hypothetical multiplayer Chess system.

### Entities:

- Player: Player account.
- Game: Game state including players, what side they play as, etc.
- Board: Board state.
- Move: Move with FEN strings.
- Winner (Enum): Winner Enum, can be one of 'w' (for white) and 'b' (for black).
- Time Control: Max game duration (on chess[dot]com they use the notations 'Rapid', 'Blitz', and 'Bullet').
- Game Result: Overall game results and other useful metrics.