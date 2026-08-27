-- =============================================================
-- ATIVIDADE: CORRECAO DE DEPENDENCIAS TRANSITIVAS (3FN)
-- SGBD: MySQL 8+
-- =============================================================

DROP DATABASE IF EXISTS empresa_dependencia_transitiva;
CREATE DATABASE empresa_dependencia_transitiva;
USE empresa_dependencia_transitiva;

-- 1. SETORES E FUNCIONARIOS
-- id_funcionario -> id_setor -> nome_setor

CREATE TABLE setor (
    id_setor INT PRIMARY KEY,
    nome_setor VARCHAR(80) NOT NULL
);

CREATE TABLE funcionario (
    id_funcionario INT PRIMARY KEY,
    nome_funcionario VARCHAR(100) NOT NULL,
    cargo VARCHAR(60) NOT NULL,
    id_setor INT NOT NULL,
    nome_setor VARCHAR(80) NOT NULL,
    CONSTRAINT fk_funcionario_setor
        FOREIGN KEY (id_setor) REFERENCES setor(id_setor)
);

INSERT INTO setor (id_setor, nome_setor) VALUES
(10, 'Tecnologia da Informacao'),
(20, 'Recursos Humanos'),
(30, 'Financeiro');

INSERT INTO funcionario
(id_funcionario, nome_funcionario, cargo, id_setor, nome_setor)
VALUES
(1, 'Ana Souza',     'Analista de Sistemas', 10, 'Tecnologia da Informacao'),
(2, 'Carlos Lima',   'Tecnico de Suporte',   10, 'TI'),
(3, 'Beatriz Alves', 'Assistente de RH',     20, 'RH'),
(4, 'Paulo Santos',  'Analista de RH',       20, 'Gestao de Pessoas'),
(5, 'Marcos Rocha',  'Contador',             30, 'Departamento Financeiro'),
(6, 'Julia Mendes',  'Auxiliar Financeiro',  30, 'Financas');

-- 2. CATEGORIAS E PRODUTOS
-- id_produto -> id_categoria -> nome_categoria

CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY,
    nome_categoria VARCHAR(80) NOT NULL
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    id_categoria INT NOT NULL,
    nome_categoria VARCHAR(80) NOT NULL,
    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

INSERT INTO categoria (id_categoria, nome_categoria) VALUES
(1, 'Informatica'),
(2, 'Escritorio');

INSERT INTO produto
(id_produto, nome_produto, preco, id_categoria, nome_categoria)
VALUES
(1, 'Teclado USB',    89.90, 1, 'Perifericos'),
(2, 'Mouse sem fio', 119.90, 1, 'Acessorios de TI'),
(3, 'Papel A4',       32.50, 2, 'Material de Escritorio'),
(4, 'Caneta azul',     3.50, 2, 'Papelaria');

-- 3. CURSOS E ALUNOS
-- id_aluno -> id_curso -> nome_curso

CREATE TABLE curso (
    id_curso INT PRIMARY KEY,
    nome_curso VARCHAR(100) NOT NULL
);

CREATE TABLE aluno (
    id_aluno INT PRIMARY KEY,
    nome_aluno VARCHAR(100) NOT NULL,
    id_curso INT NOT NULL,
    nome_curso VARCHAR(100) NOT NULL,
    CONSTRAINT fk_aluno_curso
        FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
);

INSERT INTO curso (id_curso, nome_curso) VALUES
(100, 'Tecnico em Desenvolvimento de Sistemas'),
(200, 'Tecnico em Redes de Computadores');

INSERT INTO aluno
(id_aluno, nome_aluno, id_curso, nome_curso)
VALUES
(1, 'Joao Ribeiro',   100, 'Desenvolvimento de Sistemas'),
(2, 'Larissa Gomes',  100, 'Tecnico em Informatica'),
(3, 'Pedro Martins',  200, 'Redes de Computadores'),
(4, 'Camila Freitas', 200, 'Tecnico em Redes');

-- CONSULTAS INICIAIS
-- Execute para visualizar os dados e identificar as inconsistencias.

SELECT * FROM setor;
SELECT * FROM funcionario;
SELECT * FROM categoria;
SELECT * FROM produto;
SELECT * FROM curso;
SELECT * FROM aluno;

-- A partir deste ponto, siga as instrucoes presentes no arquivo Word.
-- Nao utilize DELETE nem DROP TABLE durante a resolucao da atividade.

UPDATE funcionario
SET nome_setor = (
SELECT nome_setor
FROM setor
WHERE id_setor = 10
)
WHERE id_setor = 10
AND nome_setor <> (
SELECT nome_setor
FROM setor
WHERE id_setor = 10
);

SELECT *
FROM funcionario
WHERE id_setor = 30;

UPDATE funcionario
SET nome_setor = (
SELECT nome_setor
FROM setor
WHERE id_setor = 20
)
WHERE id_setor = 20
AND nome_setor <> (
SELECT nome_setor
FROM setor
WHERE id_setor = 20
);

UPDATE funcionario
SET nome_setor = (
SELECT nome_setor
FROM setor
WHERE id_setor = 30
)
WHERE id_setor = 30
AND nome_setor <> (
SELECT nome_setor
FROM setor
WHERE id_setor = 30
);

UPDATE produto
SET nome_categoria = (
SELECT nome_categoria
FROM categoria
WHERE id_categoria = 1
)
WHERE id_categoria = 1
AND nome_categoria <> (
SELECT nome_categoria
FROM categoria
WHERE id_categoria = 1
);

UPDATE produto
SET nome_categoria = (
SELECT nome_categoria
FROM categoria
WHERE id_categoria = 2
)
WHERE id_categoria = 2
AND nome_categoria <> (
SELECT nome_categoria
FROM categoria
WHERE id_categoria = 2
);

UPDATE aluno
SET nome_curso = (
SELECT nome_curso
FROM curso
WHERE id_curso = 100
)
WHERE id_curso = 100
AND nome_curso <> (
SELECT nome_curso
FROM curso
WHERE id_curso = 100
);

UPDATE aluno
SET nome_curso = (
SELECT nome_curso
FROM curso
WHERE id_curso = 200
)
WHERE id_curso = 200
AND nome_curso <> (
SELECT nome_curso
FROM curso
WHERE id_curso = 200
);

SELECT f.*
FROM funcionario f
INNER JOIN setor s
ON f.id_setor = s.id_setor
WHERE f.nome_setor <> s.nome_setor;

SELECT p.*
FROM produto p
INNER JOIN categoria c
ON p.id_categoria = c.id_categoria
WHERE p.nome_categoria <> c.nome_categoria;

SELECT a.*
FROM aluno a
INNER JOIN curso c
ON a.id_curso = c.id_curso
WHERE a.nome_curso <> c.nome_curso;

ALTER TABLE funcionario
DROP COLUMN nome_setor;

ALTER TABLE produto
DROP COLUMN nome_categoria;

ALTER TABLE aluno
DROP COLUMN nome_curso;

SELECT f.nome_funcionario, f.cargo, s.nome_setor FROM funcionario AS f
INNER JOIN setor AS s ON f.id_setor = s.id_setor;

SELECT p.nome_produto, p.preco, c.nome_categoria FROM produto AS p
INNER JOIN categoria AS c ON p.id_categoria = c.id_categoria;

SELECT a.nome_aluno, c.nome_curso FROM aluno AS a
INNER JOIN curso AS c ON a.id_curso = c.id_curso;

