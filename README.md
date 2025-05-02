# Graduation Project – **Numerology API**

A numerology simulation service developed as the final project for IT School.

---

## Technologies Used
| Layer | Stack |
|-------|-------|
| Runtime | **Java 23**, **Spring Boot 3.4.4** |
| Persistence | Spring Data JPA + **PostgreSQL 17** |
| Build / CI | Maven, JUnit 5, Mockito |
| Docs & Testing | springdoc-openapi (Swagger UI), Postman |

---

## Key Features
1. Calculates the full numerology profile
    * Destiny, Life Path, Expression, Soul Urge, Personality, Birthday, Maturity, Balance, Lesson.
2. Retrieves a description (meaning) for any number/type from DB.
3. Persists **User** and **NumerologyProfile** automatically (cascade).
4. CRUD endpoints to list, fetch or delete profiles.

---

## Database Schema
| Table | Purpose |
|-------|---------|
| `users` | first/last name & date-of-birth |
| `numerology_profile` | all calculated numbers (FK → `users`) |
| `numerology_meaning` | static meanings for 1-9, 11, 22, 33 |

---

## Testing
* **Unit** tests for calculator & services
* **Integration** test that boots the full Spring context & hits the API
* Run everything:

```bash
./mvnw clean verify      # JDK 23
