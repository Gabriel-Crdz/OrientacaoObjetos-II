CREATE DATABASE db_mundo

/* MySQL */
/* Tabelas no singular porque o plural de pais é paisES */
CREATE TABLE tb_pais (
    id INTPRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    continente VARCHAR(80) NOT NULL,
    fundacao INT(4),
    idiomaOficial VARCHAR(20),
    populacao INT
);

/* colunas com os mesmos nomes que na classe da entidade */
CREATE TABLE tb_cidade(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80),
    tamanho NUMERIC(10, 2),
    capital BOOLEAN,
    idPais INT,
    FOREIGN KEY (idPais) REFERENCES pais(id)
)

/* PostgreSQL */
CREATE TABLE tb_pais (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    continente VARCHAR(80) NOT NULL,
    fundacao INT,
    idiomaOficial VARCHAR(20),
    populacao INT
);

CREATE TABLE tb_cidade (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(80),
    tamanho NUMERIC(10,2),
    capital BOOLEAN,
    idPais INT,
    CONSTRAINT fk_cidade_pais FOREIGN KEY (idPais) REFERENCES tb_pais(id)
);

/* INSERT's */
-- Países
INSERT INTO tb_pais (nome, continente, fundacao, idioma, populacao) 
VALUES
('Brasil', 'AS', 1822, 'Português', 212000000),
('Estados Unidos', 'AN', 1776, 'Inglês', 340000000),
('Japão', 'AI', NULL, 'Japonês', 124000000),
('França', 'EU', NULL, 'Francês', 68000000);

-- Cidades
INSERT INTO tb_cidade (nome, tamanho, capital, idPais) 
VALUES
('Brasília', 5760.78, TRUE, 1),
('São Paulo', 1521.11, FALSE, 1),
('Washington', 177.00, TRUE, 2),
('Nova York', 783.80, FALSE, 2),
('Tóquio', 2194.07, TRUE, 3),
('Paris', 105.40, TRUE, 4);