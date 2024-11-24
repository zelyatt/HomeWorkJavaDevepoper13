CREATE SEQUENCE client_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ticket_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(200) NOT NULL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);


CREATE TABLE planet (
                        id VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(500) NOT NULL CHECK (LENGTH(name) BETWEEN 1 AND 500)
);

CREATE TABLE ticket (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        client_id BIGINT NOT NULL,
                        from_planet_id VARCHAR(10) NOT NULL,
                        to_planet_id VARCHAR(10) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES client(id),
                        FOREIGN KEY (from_planet_id) REFERENCES planet(id),
                        FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
ALTER TABLE ticket
    ADD COLUMN price DECIMAL(10, 2) NOT NULL;

