# graduation
Graduation project from IT School

A Numerology simulation app

Technologies Used

- **Java 21**
- **Spring Boot 3.2+**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **JUnit 5 & Mockito**
- **Swagger UI (OpenAPI)**
- **Postman** (manual testing)

Key Features

- Calculates:
    - Destiny Number
    - Soul Urge Number
    - Personality Number
    - Expression Number
    - Maturity Number
- Retrieves **meanings** for each number from the database
- Automatically saves users and generated profiles
- Supports fetching all existing users

Database Structure
- users – stores user data (name, birthdate)
- numerology_profile – stores calculated numbers (linked to a user)
- numerology_meaning – stores meanings for numbers 1–9 (+ master numbers)

Testing

Unit tests for:
- Numerology calculations
- Meaning retrieval from the database
- Run tests with: ./mvnw clean test

Possible Extensions
- Add a frontend UI (React, Angular)
- Export profile as PDF
- Track user history
- Add login system (user/admin roles)

Quick Demo (Postman)
- POST http://localhost:8080/api/profile
- GET http://localhost:8080/api/users
- GET http://localhost:8080/api/profile/get-meaning?number=6&type=destiny