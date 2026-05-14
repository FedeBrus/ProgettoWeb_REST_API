CREATE TABLE IF NOT EXISTS Exercises(
    name            VARCHAR(255) NOT NULL,
    sets            INT NOT NULL,
    reps            INT NOT NULL,
    kcal            INT NOT NULL,
    program_name    VARCHAR(255),
    PRIMARY KEY (name, program_name)
);
