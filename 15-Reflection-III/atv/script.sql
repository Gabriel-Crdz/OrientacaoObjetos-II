CREATE DATABASE db_mundo

USE db_mundo

/* Tabelas no singular porque o plural de pais é paisES */
CREATE TABLE tb_pais (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    continente VARCHAR(80) NOT NULL,
    fundacao DATE,
    idiomaOficial VARCHAR(20),
    populacao INTEGER
);

/* colunas com os mesmos nomes que na classe da entidade */
CREATE TABLE tb_cidade(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80),
    tamanho NUMERIC(10, 2),
    capital BOOLEAN,
    idPais INTEGER,
    FOREIGN KEY (idPais) REFERENCES pais(id)
)