-- Add a new column 'active' to the 'recipes' table with a default value of 1
ALTER TABLE recipes
    ADD COLUMN active BOOLEAN DEFAULT true;

-- Update existing rows in the 'recipes' table, setting 'active' to 1
UPDATE recipes
SET active = true;

-- Modify the 'active' column to disallow NULL values
ALTER TABLE recipes
    ALTER COLUMN active SET NOT NULL;
