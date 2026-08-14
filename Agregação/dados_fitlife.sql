-- Garante que o banco de dados correto está em uso
USE DB_FITLIFE;

DROP table usuarios;
--
-- INSERTS para a tabela 'usuarios'

CREATE TABLE usuarios (
	id_usuario INT PRIMARY KEY, 
    nome VARCHAR(100), 
    email VARCHAR(100), 
    data_nascimento DATE, 
    cidade VARCHAR(50)
);

INSERT INTO usuarios (id_usuario, nome, email, data_nascimento, cidade) VALUES
(1, 'Ana Silva', 'ana.silva@email.com', '1990-05-15', 'Rio de Janeiro'),
(2, 'Bruno Mendes', 'bruno.mendes@email.com', '1985-11-20', 'São Paulo'),
(3, 'Juliana Castro', 'ju.castro@email.com', '1998-03-01', 'Belo Horizonte'),
(4, 'Pedro Almeida', 'pedro.almeida@email.com', '1975-08-25', 'Rio de Janeiro'),
(5, 'Carlos Eduardo', 'carlos.eduardo@email.com', '2000-01-10', 'Porto Alegre'),
(6, 'Fernanda Lima', 'fernanda.lima@email.com', '1992-07-30', 'Curitiba');

--
-- INSERTS para a tabela 'metas'
--
-- O ENUM para 'status' é ('Ativa', 'Concluida')
-- O ENUM para 'tipo_meta' é ('Peso', 'Distancia', 'Calorias')
-- OBS: A meta de id_meta=2 será atualizada para 'Concluida' no passo DML do desafio.

CREATE TABLE metas (
	id_meta INT PRIMARY KEY, 
    id_usuario INT,
    tipo_meta ENUM('Peso', 'Distância', 'Calorias'), 
    valor_alvo DECIMAL(8,2), 
    data_inicio DATE, 
    status ENUM('Ativa', 'Concluída'),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

INSERT INTO metas (id_meta, id_usuario, tipo_meta, valor_alvo, data_inicio, status) VALUES
(1, 1, 'Peso', 5.00, '2025-10-01', 'Ativa'),        -- Ana: Perder 5kg
(2, 2, 'Distancia', 50.00, '2025-09-15', 'Ativa'),   -- Bruno: Correr 50km
(3, 3, 'Calorias', 10000.00, '2025-10-20', 'Ativa'), -- Juliana: Queimar 10000 calorias
(4, 4, 'Peso', 10.00, '2025-11-01', 'Ativa'),       -- Pedro: Perder 10kg
(5, 1, 'Distancia', 20.00, '2025-11-15', 'Concluida'); -- Ana: Correr 20km (Já concluída)


--
-- INSERTS para a tabela 'atividades'
--

CREATE TABLE atividades (
	id_atividade INT PRIMARY KEY, 
    id_usuario INT, 
    tipo_exercicio VARCHAR(50), 
    duracao_minutos INT, 
    calorias_queimadas INT, 
    data_registro DATE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

INSERT INTO atividades (id_atividade, id_usuario, tipo_exercicio, duracao_minutos, calorias_queimadas, data_registro) VALUES
(101, 1, 'Corrida', 45, 450, '2025-11-20'),
(102, 2, 'Ciclismo', 60, 550, '2025-11-21'),
(103, 3, 'Yoga', 30, 150, '2025-11-22'),
(104, 1, 'Caminhada', 30, 200, '2025-11-23'),
(105, 4, 'Musculação', 90, 700, '2025-11-24'),
(106, 3, 'Corrida', 40, 400, '2025-11-25'),
(107, 5, 'Natação', 45, 500, '2025-11-26'),
(108, 6, 'Caminhada', 60, 300, '2025-11-26'),
(109, 4, 'Ciclismo', 75, 650, '2025-11-27'),
(110, 2, 'Corrida', 50, 500, '2025-11-28');

-- Fim do Script de Carga de Dados.

UPDATE usuarios SET cidade = 'São Paulo' WHERE id_usuario = 5;
UPDATE metas SET status = 'Concluida' WHERE id_meta = 2;

SELECT u.nome, u.email, m.status FROM usuarios AS u
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE m.status = 'Ativa';

SELECT COUNT(*) FROM usuarios WHERE cidade ='Rio de Janeiro';

SELECT u.nome, a.tipo_exercicio FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario
ORDER BY u.nome;

SELECT u.nome, m.tipo_meta, m.valor_alvo, m.status FROM usuarios AS u
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE u.nome = 'Juliana Castro';

-- ---
-- Nível Fácil (1-8)

-- 1. Exibir o nome e o e-mail de todos os usuários que têm alguma meta registrada, juntamente com o tipo de meta associado.

SELECT u.nome, u.email, m.tipo_meta FROM usuarios AS u
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario;

-- 2. Exibir o nome do usuário e a data de registro de todas as atividades, juntamente com o tipo de exercício realizado.

SELECT u.nome, u.data_nascimento, a.tipo_exercicio FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario;

-- 3. Listar o nome do usuário e o valor alvo de todas as metas que têm o status de 'Ativa'.

SELECT u.nome, m.valor_alvo FROM usuarios AS u
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE m.status = 'Ativa';

-- 4. Exibir o tipo de exercício e a duração em minutos para todas as atividades que foram registradas pelo usuário de nome 'Ana Silva'.

SELECT a.tipo_exercicio, a.duracao_minutos FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario WHERE u.nome = 'Ana Silva';

-- 5. Listar o nome de todos os usuários que têm metas do tipo 'Peso', exibindo também o id_meta correspondente.

SELECT u.nome, m.id_meta FROM usuarios AS u
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE m.tipo_meta = 'Peso';

-- 6. Exibir o nome do usuário e a quantidade de calorias queimadas em todas as atividades de 'Caminhada'.

SELECT u.nome, a.calorias_queimadas FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario WHERE tipo_exercicio = 'Caminhada';

-- 7. Listar o nome do usuário e o tipo de meta para todas as metas que foram concluídas (status = 'Concluida').

SELECT u.nome, m.tipo_meta FROM usuarios AS u
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE status = 'Concluida';

-- 8. Exibir o nome e a cidade do usuário que registrou a atividade com o id_atividade igual a 105.

SELECT u.nome, u.cidade FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario WHERE id_atividade = 105;

-- ---
-- Nível Médio (9-10)

-- 9. Listar o nome do usuário e a média de calorias queimadas por ele, mas apenas para os usuários que têm metas ativas.

SELECT u.nome, ROUND(AVG(a.calorias_queimadas), 2) FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE m.status = 'Ativa'
GROUP BY u.id_usuario; 

-- 10. Exibir o nome do usuário e a soma total da duração em minutos de suas atividades. O resultado deve incluir somente usuários que têm registrado atividades e metas de 'Distancia'.

SELECT u.nome, SUM(a.duracao_minutos) FROM usuarios AS u
INNER JOIN atividades AS a ON u.id_usuario = a.id_usuario
INNER JOIN metas AS m ON u.id_usuario = m.id_usuario WHERE m.tipo_meta = 'Distancia'
GROUP BY u.id_usuario;