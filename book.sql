CREATE DATABASE IF NOT EXISTS book;
USE book;

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  author varchar(45) NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Thêm bản ghi với id = 1
INSERT INTO book (id, title, author, `year`)
VALUES (1, "abc", "xyz", 2014);

SELECT * FROM book;

DELIMITER $$
DROP PROCEDURE IF EXISTS CopyBookData;
CREATE PROCEDURE CopyBookData()
BEGIN
    DECLARE v_max INT UNSIGNED DEFAULT 10000;
    DECLARE v_counter INT UNSIGNED DEFAULT 1;

    WHILE v_counter < v_max DO
        INSERT INTO book (id, title, author, `year`)
        SELECT id + v_counter, CONCAT(title, v_counter), CONCAT(author, v_counter), `year`
        FROM book
        WHERE id = 1;
        SET v_counter = v_counter + 1;
    END WHILE;
END$$

DELIMITER ;
CALL CopyBookData();

SELECT * FROM book;

COMMIT;
