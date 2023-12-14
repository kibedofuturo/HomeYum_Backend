CREATE TABLE ratings (
                         id SERIAL PRIMARY KEY,
                         text VARCHAR(255) NOT NULL,
                         score INT NOT NULL,
                         user_id BIGINT REFERENCES users(id),
                         active BOOLEAN,
                         CHECK (active IN (true, false))
);
