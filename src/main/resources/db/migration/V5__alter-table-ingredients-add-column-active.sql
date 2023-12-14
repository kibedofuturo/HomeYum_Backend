-- Add a new column 'active' to the 'ingredients' table with a default value of true (1)
ALTER TABLE ingredients
    ADD COLUMN active BOOLEAN DEFAULT true;

-- Update existing rows in the 'ingredients' table, setting 'active' to true (1)
UPDATE ingredients
SET active = true;

-- Modify the 'active' column to disallow NULL values
ALTER TABLE ingredients
    ALTER COLUMN active SET NOT NULL;
