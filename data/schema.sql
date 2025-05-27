DROP TABLE IF EXISTS payment_entity;
CREATE TABLE payment_entity
(
    id                CHAR(36) PRIMARY KEY,
    transaction_id    VARCHAR(255) UNIQUE NOT NULL,
    status            VARCHAR(255)        NOT NULL,
    created           VARCHAR(255)        NOT NULL,
    order_entity      VARCHAR(255),
     amount            VARCHAR(255)        NOT NULL
);

DROP TABLE IF EXISTS order_entity;
CREATE TABLE order_entity
(
    id                CHAR(36) PRIMARY KEY,
    credit_id    VARCHAR(255)            NOT NULL,
    created           VARCHAR(255)        NOT NULL,
    payment_id      VARCHAR(255)
);