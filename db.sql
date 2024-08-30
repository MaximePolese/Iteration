-- Script to create the 'counter' table
CREATE TABLE counter (
  id INT PRIMARY KEY AUTO_INCREMENT,
  count INT NOT NULL
);

-- Insert three instances into the 'counter' table
INSERT INTO counter (count) VALUES (0);
INSERT INTO counter (count) VALUES (0);
INSERT INTO counter (count) VALUES (0);