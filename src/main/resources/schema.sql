CREATE TABLE IF NOT EXISTS Run(
    id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    started timestamp NOT NULL,
    completed timestamp NOT NULL,
    location VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Workout(
    id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    weight Integer,
    sets Integer NOT NULL,
    reps Integer NOT NULL,
    PRIMARY KEY (id)
    );