CREATE DATABASE db_locadora
    DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE veiculos(
    codigo INT(4) NOT NULL AUTO_INCREMENT,
    marca VARCHAR(30) NOT NULL,
    modelo VARCHAR(40) NOT NULL,
    chassi VARCHAR(30) NOT NULL,
    ano INT(4) NOT NULL,
    PRIMARY KEY(codigo)
);