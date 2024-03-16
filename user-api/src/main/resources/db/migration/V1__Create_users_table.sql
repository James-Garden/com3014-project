CREATE TABLE users(
    id INT GENERATED ALWAYS AS IDENTITY,
    username TEXT,
    email TEXT,
    password_hash TEXT
);
