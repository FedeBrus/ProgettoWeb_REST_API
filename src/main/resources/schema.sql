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