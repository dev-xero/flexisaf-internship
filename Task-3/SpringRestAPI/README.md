# Task 3 - Spring REST API

A simple REST API built with Spring Boot for managing players and characters in a gaming application.

## Features

- **Player Management**: Register, authenticate, and manage player accounts
- **Character Management**: Create and manage game characters
- **Secure Password Hashing**: Uses BCrypt for password security
- **Interactive API Documentation**: Swagger UI for easy testing
- **In-Memory Database**: H2 database for development and testing

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA** - Database operations
- **Spring Security** - Password encryption
- **H2 Database** - In-memory database
- **SpringDoc OpenAPI** - API documentation
- **Maven** - Build tool

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Running the Application

1. **Clone the repository**

2. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the API**
    - Application: `http://localhost:8080`
    - Swagger UI: `http://localhost:8080/swagger-ui.html`

## API Endpoints

### Players
- `GET /players` - Get all players
- `GET /players/{id}` - Get player by ID
- `POST /players` - Register a new player

### Characters
- `GET /characters` - Get all characters
- `GET /characters/{id}` - Get character by ID
- `POST /characters` - Create a new character

## Configuration

### Security Configuration
Spring Security is configured to allow all requests during development. Password hashing is handled using BCrypt.

## Example Usage

### Register a Player
```bash
curl -X POST http://localhost:8080/players \
  -H "Content-Type: application/json" \
  -d '{
    "username": "Naruto",
    "password": "uzumaki_hokage"
  }'
```

### Get All Players
```bash
curl -X GET http://localhost:8080/players
```

## API Documentation

Once the application is running, visit `http://localhost:8080/swagger-ui.html` to interact with the API using Swagger UI.