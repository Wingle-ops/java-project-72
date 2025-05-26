DROP TABLE IF EXIST urls;
DROP TABLE IF EXIST url_check;

CREATE TABLE urls (
    id SERAIL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    createdAt TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE url_checks (
    id SERIAL PRIMARY KEY,
    url_id BIGINT NOT NULL,
    codeAnswer INT,
    title TEXT,
    h1 TEXT,
    description TEXT,
    dateCheck TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (url_id) REFERENCES urls(id) ON DELETE CASCADE
);