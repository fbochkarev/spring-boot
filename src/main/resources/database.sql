-- Table: users
CREATE TABLE jm_db.users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE jm_db.roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE jm_db.user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO jm_db.users VALUES (1, 'admin', '$2a$10$QmHrTJdc4aRgGmTa7xNB/eCQ8PmhsI9hlhVaqYYQiR5qFIW9wsOSa', 'Lastname123', 'lastname@mail.ru');

INSERT INTO jm_db.roles VALUES (1, 'ROLE_USER');
INSERT INTO jm_db.roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO jm_db.user_roles VALUES (1, 2);