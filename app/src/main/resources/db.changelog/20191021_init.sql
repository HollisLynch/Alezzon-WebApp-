CREATE SEQUENCE hibernate_sequence;

CREATE TABLE IF NOT EXISTS profile
(
    id BIGSERIAL NOT NULL,
    username VARCHAR(30),
    name VARCHAR(50),
    email VARCHAR(30),
    birth VARCHAR(17),
    password VARCHAR,
    role VARCHAR,

    PRIMARY KEY (id)
);