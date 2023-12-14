-- Add a new column 'active' to the 'users' table with a default value of true (1)
ALTER TABLE users
    ADD COLUMN active BOOLEAN DEFAULT true;

-- Update existing rows in the 'users' table, setting 'active' to true (1)
UPDATE users
SET active = true;

-- Modify the 'active' column to disallow NULL values
ALTER TABLE users
    ALTER COLUMN active SET NOT NULL;