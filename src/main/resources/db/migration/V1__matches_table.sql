-- V1 Create matches table
CREATE TABLE matches ( -- workaround: since MATCH is an SQL keyword, we use plural in table definition
id BIGSERIAL PRIMARY KEY,
description varchar(128) NOT NULL,
match_date DATE NOT NULL,
match_time TIME(0) NOT NULL, -- precision 0 means no seconds stored
team_a varchar(128) NOT NULL,
team_b varchar(128) NOT NULL,
sport SMALLINT NOT NULL -- 1 for FOOTBALL, 2 for BASKETBALL
);

-- Insert dummy data
INSERT INTO matches (description, match_date, match_time, team_a, team_b, sport)
VALUES ('Test Match 1', '2025-06-10', '21:15', 'Team A', 'Team B', 1),
        ('Test Match 2', '2025-06-11', '22:30', 'Team D', 'Team C', 2),
        ('Test Match 3', '2025-06-12', '20:35', 'Team A', 'Team C', 1);
