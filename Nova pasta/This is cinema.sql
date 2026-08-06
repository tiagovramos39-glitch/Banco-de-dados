CREATE DATABASE cinema;

USE cinema;

CREATE TABLE clientes(
	id_cliente INT PRIMARY KEY,
    nome_cliente VARCHAR(60),
    estado VARCHAR(45),
    regiao VARCHAR(45),
    sexo VARCHAR(40),
    data_nascimento DATE,
    data_conta DATE
);

CREATE TABLE filmes(
	id_filme INT PRIMARY KEY,
    titulo VARCHAR(60),
    genero VARCHAR(45),
    duracao VARCHAR(45),
    ano_lancamento INT,
    preco_aluguel DOUBLE
);

CREATE TABLE atores(
	id_ator INT PRIMARY KEY,
    nome_autor VARCHAR(60),
    ano_nascimento DATE,
    nacionalidade VARCHAR(20),
    sexo VARCHAR(10)
);

CREATE TABLE alugueis(
	id_aluguel VARCHAR(45) PRIMARY KEY,
    id_cliente INT, 
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    id_filme INT,
    FOREIGN KEY (id_filme) REFERENCES filmes(id_filme),
    nota DOUBLE,
    data_aluguel DATE
);

CREATE TABLE atuacaoes(
	id_protagonista INT PRIMARY KEY,
    id_ator INT,
	FOREIGN KEY (id_ator) REFERENCES atores(id_ator),
    id_filme INT,
	FOREIGN KEY (id_filme) REFERENCES filmes(id_filme)
);

INSERT INTO clientes(id_cliente, nome_cliente)