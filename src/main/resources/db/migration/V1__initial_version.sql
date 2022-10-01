CREATE TABLE shortened_urls (
    id  VARCHAR (255) not null,
    original_url VARCHAR(255),
    title VARCHAR(255),
    created_at TIMESTAMP,
    PRIMARY KEY (id)
);

ALTER TABLE shortened_urls OWNER TO postgres;