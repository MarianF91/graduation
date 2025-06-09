# Graduation Project – **Numerology API**

A numerology-simulation service developed as the final project for **IT School**.

---

## Technologies Used

| Layer / Concern | Stack |
|-----------------|-------|
| **Runtime**     | Java 23 &nbsp;·&nbsp; Spring Boot 3.4.4 |
| **Persistence** | Spring Data JPA &nbsp;·&nbsp; PostgreSQL 17 |
| **Build / CI**  | Maven &nbsp;·&nbsp; JUnit 5 &nbsp;·&nbsp; Mockito |
| **Docs / Manual testing** | springdoc-openapi (Swagger UI) &nbsp;·&nbsp; Postman |

---

## Key Features

1. **Full numerology profile**  
   &nbsp;&nbsp;&nbsp;&nbsp;• Destiny · Life Path · Expression · Soul Urge · Personality · Birthday · Maturity · Balance · Lesson
2. **Meaning lookup** – returns a text description for any number/type stored in DB.
3. **Auto-persistence** – users and generated profiles are saved transparently via cascade.
4. **CRUD endpoints** – list, fetch or delete profiles (see *API snapshot* below).

---

## Possible Extensions
1. Front-end UI (React or Angular)
2. Export profile as PDF
3. Authentication (user / admin roles, JWT)
4. User history & statistics dashboards

---

## Database Schema

| Table | Purpose |
|-------|---------|
| **`users`** | first / last name + date-of-birth |
| **`numerology_profile`** | calculated numbers (FK → `users`) |
| **`numerology_meaning`** | static meanings for 1-9, 11, 22, 33 |

---

## Run Locally

```bash
git clone https://github.com/MarianF91/graduation.git
cd graduation
./mvnw spring-boot:run        # requires JDK 23+