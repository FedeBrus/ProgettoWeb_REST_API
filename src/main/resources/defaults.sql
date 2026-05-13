INSERT INTO Programs (name, is_default, owner) VALUES ('Cardio', TRUE, 'DEFAULT');
INSERT INTO Programs (name, is_default, owner) VALUES ('Strength', TRUE, 'DEFAULT');
INSERT INTO Programs (name, is_default, owner) VALUES ('Full Body', TRUE, 'DEFAULT');
INSERT INTO Programs (name, is_default, owner) VALUES ('Push/Pull/Legs', TRUE, 'DEFAULT');

INSERT INTO Exercises (name, sets, reps, kcal, program_name, program_owner) VALUES
('Salto della corda', 5, 100, 150, 'Cardio', 'DEFAULT'),
('Burpees', 4, 15, 80,  'Cardio', 'DEFAULT');

INSERT INTO Exercises (name, sets, reps, kcal, program_name, program_owner) VALUES
('Panca Piana', 5, 5, 100, 'Strength', 'DEFAULT'),
('Stacco da terra', 4, 6, 120, 'Strength', 'DEFAULT'),
('Military Press', 4, 8, 90, 'Strength', 'DEFAULT');

INSERT INTO Exercises (name, sets, reps, kcal, program_name, program_owner) VALUES
('Squat', 4, 10, 150, 'Full Body', 'DEFAULT'),
('Trazioni alla sbarra', 3, 8, 70, 'Full Body', 'DEFAULT'),
('Affondi', 3, 12, 100, 'Full Body', 'DEFAULT');

INSERT INTO Exercises (name, sets, reps, kcal, program_name, program_owner) VALUES
('Dips', 3, 12, 60, 'Push/Pull/Legs', 'DEFAULT'),
('Leg Press', 3, 15, 130, 'Push/Pull/Legs', 'DEFAULT');