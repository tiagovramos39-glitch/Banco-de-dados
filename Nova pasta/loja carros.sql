CREATE DATABASE loja_carros;

USE loja_carros;

CREATE TABLE marca(
	id_marca INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45),
    pais_origem VARCHAR(45)
);

CREATE TABLE veiculo(
	id_veiculo INT PRIMARY KEY AUTO_INCREMENT,
    placa CHAR(7),
    ano_fabricacao INT,
    modelo VARCHAR(45),
    fabricante VARCHAR(45),
    preco DECIMAL(10,2),
    id_marca INT,
    FOREIGN KEY (id_marca) REFERENCES marca(id_marca)
);

INSERT INTO marca (nome, pais_origem) VALUES ('Honda', 'Japão');

SELECT * FROM marca;

INSERT INTO veiculo (placa, ano_fabricacao, modelo, fabricante, preco, id_marca) VALUES ('sqv6j60', 2023, 'City', 'XPTO', 100000.00, 1);

SELECT * FROM veiculo;