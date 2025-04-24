-- Create Users Table
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    birth_year  INT          NOT NULL,
    birth_month INT          NOT NULL,
    birth_day   INT          NOT NULL,
    CONSTRAINT unique_user_data UNIQUE (first_name, last_name, birth_year, birth_month, birth_day)
    );

-- Create Profiles Table
CREATE TABLE IF NOT EXISTS numerology_profile (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    destiny_number     INT NOT NULL,
    soul_urge_number   INT NOT NULL,
    personality_number INT NOT NULL,
    expression_number  INT NOT NULL,
    maturity_number    INT NOT NULL,
    balance_number     INT NOT NULL,
    birthday_number    INT NOT NULL,
    lesson_number      INT NOT NULL,
    life_path_number   INT NOT NULL,
    CONSTRAINT unique_user_profile UNIQUE (user_id)
    );

-- Create Meanings Table
CREATE TABLE IF NOT EXISTS numerology_meaning (
    number      INT         NOT NULL,
    type        VARCHAR(50) NOT NULL,
    description TEXT        NOT NULL,
    PRIMARY KEY (number, type)
    );