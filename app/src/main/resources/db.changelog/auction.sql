CREATE TABLE IF NOT EXISTS product
(
    id              BIGSERIAL,
    name            VARCHAR NOT NULL,
    description     VARCHAR NOT NULL,
    price           NUMERIC(9, 2),
    category        VARCHAR NOT NULL,
    owner_id        BIGSERIAL NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES profile(id)
);

CREATE TABLE IF NOT EXISTS section
(
    id   BIGSERIAL,
    name VARCHAR,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS category
(
    id         BIGSERIAL,
    section_id BIGINT NOT NULL,
    name       VARCHAR,

    PRIMARY KEY (id),
    FOREIGN KEY (section_id) REFERENCES section(id)
);

CREATE TABLE IF NOT EXISTS photo
(
    id         BIGSERIAL,
    product_id INT,
    link       VARCHAR,

    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS parametr
(
    id    BIGSERIAL,
    value VARCHAR,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product_parametr
(
    product_id  INT,
    parametr_id INT,
    value       VARCHAR,

    PRIMARY KEY (product_id, parametr_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (parametr_id) REFERENCES parametr(id)
);