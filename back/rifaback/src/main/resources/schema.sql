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
    charge INT
);

CREATE TABLE IF NOT EXISTS cell(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    board_id BIGINT,
    number_cell INT,
    status TINYINT(1),
    FOREIGN KEY (board_id) REFERENCES board(id)
);

CREATE TABLE IF NOT EXISTS userboard(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    board_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (board_id) REFERENCES board(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS usercell(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cell_id BIGINT,
    user_id BIGINT,
    FOREIGN KEY (cell_id) REFERENCES cell(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
)
