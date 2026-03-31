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

CREATE TABLE vendedores(
    codigo INT(4) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    contato VARCHAR(10) NOT NULL,
    cargo VARCHAR(7) NOT NULL,
    salarioBase DECIMAL(10, 2) NOT NULL,
    anoAdmissao INT(4) NOT NULL,
    PRIMARY KEY(codigo)
);