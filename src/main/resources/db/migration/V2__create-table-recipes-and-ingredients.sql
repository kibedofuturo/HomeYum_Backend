CREATE TABLE ingredients (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             value DOUBLE PRECISION NOT NULL
);

CREATE TABLE recipes (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         preparationmethod TEXT NOT NULL,
                         preparationtime DOUBLE PRECISION NOT NULL,
                         servingnumber INT,
                         difficulty VARCHAR(25),
                         category VARCHAR(25),
                         user_id BIGINT REFERENCES users(id),
                         ingredient_id BIGINT REFERENCES ingredients(id)
);
