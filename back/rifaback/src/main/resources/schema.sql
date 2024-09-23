CREATE TABLE IF NOT EXISTS user(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255) UNIQUE ,
    phone VARCHAR(255),
    status TINYINT(1),
    role VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS board(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    size INT,
    title VARCHAR(255),
    description VARCHAR(255),
    rules VARCHAR(255),
    status TINYINT(1),
    price INT,
    charge INT,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS cell(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    user_id BIGINT default 0,
    board_id BIGINT,
    number_cell INT,
    status TINYINT(1),
    FOREIGN KEY (board_id) REFERENCES board(id)
);

CREATE TABLE IF NOT EXISTS transaction(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    date DATETIME,
    name VARCHAR(255),
    phone VARCHAR(255),
    address VARCHAR(255),
    cell_id BIGINT,
    status TINYINT(1),
    FOREIGN KEY (cell_id) REFERENCES cell(id)

)
