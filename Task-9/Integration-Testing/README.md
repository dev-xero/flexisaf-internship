## Task 9 - Integration Testing

Setting up test frameworks, setting up the test context and test data, mocking application resources, verifying actual results of tests against expected results, cleanup of test resources.

## Deliverable

Write test cases for previous projects.

## Dependencies
- [Spring Boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/)
- [Spring Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/)
- [Spring Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/)

## Running Tests
```bash
mvn test
```

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create new user |
| PUT | `/api/users/{id}` | Update existing user |
| DELETE | `/api/users/{id}` | Delete user |

### Example Request

```bash
# Create a user
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'

# Get all users
curl http://localhost:8080/api/users
```

## Configuration

No additional configuration required. The application uses in-memory storage and runs with default settings.

## Details

- This project follows standard Spring Boot structure by separating code into controllers and services layers.
- The User model is a simple POJO with id, name, and email fields.
- In-memory storage is implemented using ConcurrentHashMap for thread-safe operations.
- The service layer contains business logic for CRUD operations with proper Optional handling.
- The controller layer handles HTTP requests/responses with appropriate status codes.
- Comprehensive unit and integration tests are included using JUnit 5 and MockMvc.