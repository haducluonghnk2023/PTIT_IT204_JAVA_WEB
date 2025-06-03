create database ss15;
use ss15;

CREATE TABLE resume (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        full_name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL UNIQUE,
                        phone_number VARCHAR(50) NOT NULL,
                        education TEXT,
                        experience TEXT,
                        skills TEXT
);
INSERT INTO resume (full_name, email, phone_number, education, experience, skills) VALUES
                                                                                       ('Nguyễn Văn A', 'nguyenvana@example.com', '0901234567', 'Đại học Bách Khoa', '3 năm làm Java Developer', 'Java, Spring Boot, MySQL'),
                                                                                       ('Trần Thị B', 'tranthib@example.com', '0912345678', 'Đại học Kinh tế Quốc dân', '2 năm làm nhân sự', 'Giao tiếp, Quản lý nhân sự'),
                                                                                       ('Lê Văn C', 'levanc@example.com', '0923456789', 'Cao đẳng FPT Polytechnic', '1 năm thực tập Frontend', 'HTML, CSS, JavaScript'),
                                                                                       ('Phạm Thị D', 'phamthid@example.com', '0934567890', 'Đại học Ngoại Thương', '4 năm quản lý dự án', 'Leadership, Agile, Scrum'),
                                                                                       ('Hoàng Văn E', 'hoangvane@example.com', '0945678901', 'Đại học CNTT', '5 năm phát triển phần mềm', 'Python, Django, PostgreSQL');

-- get all
DELIMITER //
CREATE PROCEDURE GetAllResumes ()
BEGIN
    SELECT * FROM resume;
END ;
DELIMITER //;

-- get by id
DELIMITER //
CREATE PROCEDURE GetResumeById (
    IN p_id BIGINT
)
BEGIN
    SELECT * FROM resume WHERE id = p_id;
END ;
DELIMITER //

DELIMITER //

CREATE PROCEDURE AddResume (
    IN p_fullName VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_phoneNumber VARCHAR(50),
    IN p_education TEXT,
    IN p_experience TEXT,
    IN p_skills TEXT
)
BEGIN
    INSERT INTO resume (
        full_name, email, phone_number, education, experience, skills
    )
    VALUES (
               p_fullName, p_email, p_phoneNumber, p_education, p_experience, p_skills
           );
END ;

DELIMITER //


DELIMITER //

CREATE PROCEDURE UpdateResume (
    IN p_id BIGINT,
    IN p_fullName VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_phoneNumber VARCHAR(50),
    IN p_education TEXT,
    IN p_experience TEXT,
    IN p_skills TEXT
)
BEGIN
    UPDATE resume
    SET
        full_name = p_fullName,
        email = p_email,
        phone_number = p_phoneNumber,
        education = p_education,
        experience = p_experience,
        skills = p_skills
    WHERE id = p_id;
END ;

DELIMITER //

-- xoa
DELIMITER //
CREATE PROCEDURE DeleteResume (
    IN p_id BIGINT
)
BEGIN
    DELETE FROM resume WHERE id = p_id;
END ;
DELIMITER //