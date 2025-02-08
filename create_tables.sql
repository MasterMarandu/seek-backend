DROP TABLE  Task;

DROP TABLE  user_roles;

DROP TABLE  Roles;

DROP TABLE  Users;



CREATE TABLE Task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
);


CREATE TABLE Roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES Roles(id) ON DELETE CASCADE
);


INSERT INTO Roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO Roles (name) VALUES ('ROLE_USER');


INSERT INTO Users (username, password) VALUES ('admin', '$2a$10$aIZH072mVsHAg9DPk4xqtOQA6IJicGCcKV73GmukMTayiKV7aTZiu');
INSERT INTO Users (username, password) VALUES ('user', '$2a$10$aIZH072mVsHAg9DPk4xqtOQA6IJicGCcKV73GmukMTayiKV7aTZiu1');


INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- Admin con ROLE_ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- User con ROLE_USER

INSERT INTO Task (title, description, status) VALUES ('Task 1', 'El primer task', 'por_hacer');

INSERT INTO Task (title, description, status) VALUES ('Task 2', 'El segundo task', 'en_progreso');

INSERT INTO Task (title, description, status) VALUES ('Task 3', 'El tercer task', 'completada');

