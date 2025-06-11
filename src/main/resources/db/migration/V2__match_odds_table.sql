-- V2 Create match_odds table
CREATE TABLE match_odds (
    id BIGSERIAL PRIMARY KEY,
    match_id BIGSERIAL NOT NULL,
    specifier VARCHAR(10) NOT NULL,
    odd DECIMAL(5,2) NOT NULL,
    CONSTRAINT fk_match_odds_match_id FOREIGN KEY (match_id) REFERENCES matches(id) ON DELETE CASCADE
);

-- Insert dummy data
INSERT INTO match_odds (match_id, specifier, odd)
VALUES (3, '2', 0.5),
        (1, 'X', 1.5);
