Graduation Project – Numerology App
A numerology simulation application built as part of the IT School graduation project.

 Technologies Used
- Java 21
- Spring Boot 3.2+
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit 5 & Mockito
- Postman (for manual testing)

 Key Features
1. Calculates numerology numbers:
- Destiny Number;
- Soul Urge Number;
- Personality Number;
- Expression Number;
- Maturity Number;
- Birthday Number;
- Lesson Number;
- Balance Number;
- Life Path Number;
2. Retrieves meanings for each number from the database.
3. Automatically saves users and generated profiles.
4. Allows fetching all existing profiles.

Database Structure
- users – stores user data (name, date of birth)
- numerology_profile – stores calculated numerology numbers (linked to a user)
- numerology_meaning – stores meanings for numbers 1–9 and master numbers

Testing
1. Includes unit tests for:
- Core numerology calculations;
- Meaning retrieval logic;
2. Run tests:
- bash: ./mvnw clean test

Possible Extensions
- Add a frontend UI (e.g., React or Angular).
- Export profile as PDF.
- Track user history.
- Add login/auth system (user/admin roles).

API Quick Demo
- Swagger UI: http://localhost:8080/swagger-ui.html
- API Docs: http://localhost:8080/v3/api-docs
- Endpoints:
1) POST: /api/profiles -> Create numerology profile
2) GET: /api/users -> List all users
3) GET: /api/profiles/meanings?number=6&type=DESTINY -> Get meaning for a number

Manual Database Reset (optional)
If needed for testing purposes:
- sql:
```sql
TRUNCATE TABLE numerology_profile, users CASCADE;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE numerology_profile_id_seq RESTART WITH 1;