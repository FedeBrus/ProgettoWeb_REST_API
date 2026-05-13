CREATE TABLE IF NOT EXISTS Programs(
    name            VARCHAR(255) NOT NULL,
    is_default      BOOLEAN NOT NULL,
    owner           VARCHAR(255),
    PRIMARY KEY (name, owner)
);

CREATE TABLE IF NOT EXISTS Exercises(
    name            VARCHAR(255) NOT NULL,
    sets            INT NOT NULL,
    reps            INT NOT NULL,
    kcal            INT NOT NULL,
    program_name    VARCHAR(255),
    program_owner   VARCHAR(255),
    PRIMARY KEY (name, program_name, program_owner),
    FOREIGN KEY (program_name, program_owner) REFERENCES Programs(name, owner) ON UPDATE CASCADE ON DELETE CASCADE
);