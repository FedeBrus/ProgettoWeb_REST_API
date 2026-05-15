MERGE INTO Exercises (name, sets, reps, kcal, program_name) KEY(name, program_name) VALUES
('Salto della corda', 5, 100, 150, 'Cardio'),
('Burpees', 4, 15, 80,  'Cardio');

MERGE INTO Exercises (name, sets, reps, kcal, program_name) KEY(name, program_name) VALUES
('Panca Piana', 5, 5, 100, 'Strength'),
('Stacco da terra', 4, 6, 120, 'Strength'),
('Military Press', 4, 8, 90, 'Strength');

MERGE INTO Exercises (name, sets, reps, kcal, program_name) KEY(name, program_name) VALUES
('Squat', 4, 10, 150, 'Full Body'),
('Trazioni alla sbarra', 3, 8, 70, 'Full Body'),
('Affondi', 3, 12, 100, 'Full Body');

MERGE INTO Exercises (name, sets, reps, kcal, program_name) KEY(name, program_name) VALUES
('Dips', 3, 12, 60, 'Push/Pull/Legs'),
('Leg Press', 3, 15, 130, 'Push/Pull/Legs');