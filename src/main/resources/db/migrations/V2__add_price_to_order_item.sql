
INSERT INTO client (name) VALUES ('Alice'), ('Bob'), ('Charlie'), ('David'), ('Eva'),
                                 ('Frank'), ('Grace'), ('Hank'), ('Ivy'), ('Jack');

INSERT INTO planet (id, name) VALUES
                                  ('EARTH', 'Earth'), ('MARS', 'Mars'), ('VEN', 'Venus'), ('JUP', 'Jupiter'), ('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'EARTH', 'MARS'), (2, 'MARS', 'VEN'), (3, 'VEN', 'JUP'), (4, 'JUP', 'SAT'),
                                                                 (5, 'SAT', 'EARTH'), (6, 'EARTH', 'VEN'), (7, 'VEN', 'SAT'), (8, 'SAT', 'JUP'),
                                                                 (9, 'JUP', 'MARS'), (10, 'MARS', 'EARTH');
