CREATE TABLE "user"
(
    id                VARCHAR(50) PRIMARY KEY,
    username          VARCHAR(50) UNIQUE NOT NULL,
    email             VARCHAR(255) UNIQUE NOT NULL,
    password          VARCHAR(255) NOT NULL,
    registration_date TIMESTAMP NOT NULL,
    role              VARCHAR(50) NOT NULL
);

CREATE TABLE movie
(
    id               VARCHAR(50) PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    description      TEXT NOT NULL,
    duration         INT NOT NULL,
    release_date     DATE NOT NULL,
    rating           VARCHAR(5) NOT NULL
);

CREATE TABLE theater
(
    id       VARCHAR(50) PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE screen
(
    id               VARCHAR(50) PRIMARY KEY,
    theater_id       VARCHAR(50) REFERENCES theater (id),
    name             VARCHAR(50) NOT NULL,
    number_of_rows   INT NOT NULL,
    number_of_columns INT NOT NULL
);

CREATE TABLE screening
(
    id        VARCHAR(50) PRIMARY KEY,
    movie_id  VARCHAR(50) REFERENCES movie (id),
    screen_id VARCHAR(50) REFERENCES screen (id),
    timestamp TIMESTAMP NOT NULL
);

CREATE TABLE reservation
(
    id             VARCHAR(50) PRIMARY KEY,
    user_id        VARCHAR(50) REFERENCES "user" (id),
    timestamp      TIMESTAMP NOT NULL
);

CREATE TABLE screening_reservation
(
    reservation_id VARCHAR(50) REFERENCES reservation(id),
    screening_id   VARCHAR(50) REFERENCES screening(id),
    row_number     INT NOT NULL,
    seat_number    INT NOT NULL,
    ticket_price   REAL NOT NULL,
    ticket_type    VARCHAR(50) NOT NULL,
    PRIMARY KEY (reservation_id, screening_id, row_number, seat_number)
);