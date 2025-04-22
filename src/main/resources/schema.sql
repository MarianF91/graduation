-- Drop existing sequences and tables if they exist
DROP SEQUENCE IF EXISTS users_id_seq CASCADE;
DROP SEQUENCE IF EXISTS numerology_profile_id_seq CASCADE;

DROP TABLE IF EXISTS numerology_profile CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS numerology_meaning CASCADE;

-- Create sequences
CREATE SEQUENCE users_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE numerology_profile_id_seq START WITH 1 INCREMENT BY 1;

-- Create users table
CREATE TABLE users
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('users_id_seq'),
    first_name  VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    birth_year  INT          NOT NULL,
    birth_month INT          NOT NULL,
    birth_day   INT          NOT NULL,
    CONSTRAINT unique_user_data UNIQUE (first_name, last_name, birth_year, birth_month, birth_day)
);

-- Create numerology_profile table
CREATE TABLE numerology_profile
(
    id                 BIGINT PRIMARY KEY DEFAULT nextval('numerology_profile_id_seq'),
    user_id            BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    destiny_number     INT    NOT NULL,
    soul_urge_number   INT    NOT NULL,
    personality_number INT    NOT NULL,
    expression_number  INT    NOT NULL,
    maturity_number    INT    NOT NULL
);

-- Create numerology_meaning table (for meanings)
CREATE TABLE numerology_meaning
(
    number      INT         NOT NULL,
    type        VARCHAR(50) NOT NULL,
    description TEXT        NOT NULL,
    PRIMARY KEY (number, type)
);