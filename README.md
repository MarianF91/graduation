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
- users – stores user data (name, date of birth)
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

Quick Demo

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API docs**:     http://localhost:8080/v3/api-docs
- **Create profile**: POST http://localhost:8080/api/profiles
- **List users**:    GET  http://localhost:8080/api/users
- **Get meaning**:   GET  http://localhost:8080/api/profiles/meanings?number=6&type=DESTINY

To reset the database and ensure ID sequences start from 1:

1. Open `pgAdmin` or your SQL interface.
2. Run the following SQL script:

```sql
TRUNCATE TABLE numerology_profile, users CASCADE;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE numerology_profile_id_seq RESTART WITH 1;