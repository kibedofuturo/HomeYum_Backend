CREATE TABLE ratings (
                         id INT AUTO_INCREMENT not null,
                         text VARCHAR(255) not null ,
                         score INT not null,
                         user_id BIGINT,
                         active TINYINT,
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         primary key (id)
);