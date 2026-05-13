CREATE TABLE IF NOT EXISTS Programs(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    is_default      BOOLEAN NOT NULL,
    owner           VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Exercises(
    name            VARCHAR(255) NOT NULL,
    sets            INT NOT NULL,
    reps            INT NOT NULL,
    kcal            INT NOT NULL,
    program_id      INT NOT NULL,
    PRIMARY KEY (name, program_id),
    FOREIGN KEY (program_id) REFERENCES Programs(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Programs (name, is_default, owner) VALUES ('Cardio', TRUE, NULL);
INSERT INTO Programs (name, is_default, owner) VALUES ('Strength', TRUE, NULL);
INSERT INTO Programs (name, is_default, owner) VALUES ('Full Body', TRUE, NULL);
INSERT INTO Programs (name, is_default, owner) VALUES ('Push/Pull/Legs', TRUE, NULL);

INSERT INTO Exercises (name, sets, reps, kcal, program_id) VALUES
('Salto della corda', 5, 100, 150, 1),
('Burpees', 4, 15, 80, 1);

INSERT INTO Exercises (name, sets, reps, kcal, program_id) VALUES
('Panca Piana', 5, 5, 100, 2),
('Stacco da terra', 4, 6, 120, 2),
('Military Press', 4, 8, 90, 2);

INSERT INTO Exercises (name, sets, reps, kcal, program_id) VALUES
('Squat', 4, 10, 150, 3),
('Trazioni alla sbarra', 3, 8, 70, 3),
('Affondi', 3, 12, 100, 3);

INSERT INTO Exercises (name, sets, reps, kcal, program_id) VALUES
('Dips', 3, 12, 60, 4),
('Leg Press', 3, 15, 130, 4);