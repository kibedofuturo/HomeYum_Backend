ALTER TABLE ingredients ADD COLUMN active TINYINT DEFAULT 1;
UPDATE ingredients SET active = 1;
ALTER TABLE ingredients MODIFY active TINYINT NOT NULL;