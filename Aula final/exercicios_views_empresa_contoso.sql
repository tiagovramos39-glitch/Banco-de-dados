-- ============================================================
-- EXERCÍCIOS - VIEW
-- Banco: empresa_contoso
-- Tabela principal: funcionarios
--
-- Objetivo:
-- Praticar a criação e utilização de VIEWs no MySQL.
--
-- IMPORTANTE:
-- Leia com atenção o que cada exercício exige.
-- Desenvolva os comandos nos espaços indicados.
-- ============================================================

USE empresa_contoso;


-- ============================================================
-- EXERCÍCIO 1 - VIEW SIMPLES
-- Nível: MUITO FÁCIL
-- ============================================================
--
-- RECURSO OBRIGATÓRIO:
--   -> CREATE VIEW
--
-- Crie uma VIEW chamada vw_funcionarios_basico.
--
-- Ela deve mostrar apenas:
--   • nome
--   • cargo
--   • salario
--
-- Depois de criar a VIEW, faça uma consulta para mostrar
-- todos os registros existentes nela.
--
-- Desenvolva abaixo:

CREATE VIEW vw_funcionarios_basicos AS
SELECT nome, cargo, salario FROM funcionarios;

SELECT * FROM vw_funcionarios_basicos;

-- ============================================================
-- EXERCÍCIO 2 - VIEW COM FILTRO
-- Nível: FÁCIL
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> CREATE VIEW
--   -> WHERE
--
-- Crie uma VIEW chamada vw_salarios_altos.
--
-- Ela deve mostrar:
--   • nome
--   • cargo
--   • salario
--
-- Porém, devem aparecer apenas funcionários com salário
-- maior que R$ 10.000.
--
-- Depois, consulte a VIEW.
--
-- Desenvolva abaixo:

CREATE VIEW vw_salarios_altos AS
SELECT nome, cargo, salario FROM funcionarios
WHERE salario > 10000;

SELECT * FROM vw_salarios_altos;

-- ============================================================
-- EXERCÍCIO 3 - VIEW COM CAMPO CALCULADO
-- Nível: FÁCIL / INTERMEDIÁRIO
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> CREATE VIEW
--   -> expressão matemática
--   -> AS para criar um apelido para a coluna
--
-- Crie uma VIEW chamada vw_salario_reajustado.
--
-- Ela deve mostrar:
--   • nome
--   • cargo
--   • salario atual
--   • uma coluna chamada salario_com_reajuste
--
-- A coluna salario_com_reajuste deve representar quanto
-- o funcionário receberia com um reajuste de 10%.
--
-- ATENÇÃO:
-- A VIEW NÃO deve alterar o salário real armazenado na tabela.
-- Ela deve apenas calcular e mostrar o novo valor.
--
-- Depois, consulte a VIEW.
--
-- Desenvolva abaixo:

CREATE VIEW vw_salario_reajustado AS
SELECT nome, cargo, salario, 
ROUND((salario * 1.10),2) AS salario_com_reajuste
FROM funcionarios;

SELECT * FROM vw_salario_reajustado;

-- ============================================================
-- EXERCÍCIO 4 - VIEW COM CLASSIFICAÇÃO
-- Nível: INTERMEDIÁRIO
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> CREATE VIEW
--   -> CASE
--
-- Crie uma VIEW chamada vw_faixa_salarial.
--
-- Ela deve mostrar:
--   • nome
--   • cargo
--   • salario
--   • faixa_salarial
--
-- Utilize CASE para criar a coluna faixa_salarial.
--
-- Regras:
--
-- salário menor que 5.000
--     -> 'Baixa'
--
-- salário entre 5.000 e 15.000
--     -> 'Média'
--
-- salário maior que 15.000
--     -> 'Alta'
--
-- Depois, consulte a VIEW.
--
-- Desenvolva abaixo:

CREATE VIEW vw_faixa_salarial AS
SELECT nome, cargo, salario,
CASE
	WHEN salario < 5000 THEN 'Baixa'
    WHEN salario <= 15000 THEN 'Média'
    ELSE 'Alta'
END AS faixa_salarial
FROM funcionarios;

SELECT * FROM vw_faixa_salarial;

-- ============================================================
-- EXERCÍCIO 5 - VIEW COM AGREGAÇÃO
-- Nível: INTERMEDIÁRIO
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> CREATE VIEW
--   -> COUNT()
--   -> AVG()
--   -> GROUP BY
--
-- Crie uma VIEW chamada vw_resumo_cargos.
--
-- Ela deve apresentar um resumo de cada cargo existente
-- na empresa.
--
-- A VIEW deve mostrar:
--   • cargo
--   • quantidade_funcionarios
--   • media_salarial
--
-- Cada cargo deve aparecer apenas uma vez.
--
-- Depois, consulte a VIEW ordenando os cargos pela maior
-- média salarial.
--
-- Desenvolva abaixo:

CREATE VIEW vw_resumo_cargos AS
SELECT cargo, COUNT(*) AS quantidade_funcionarias, ROUND(AVG(salario),2) AS media_salarial
FROM funcionarios GROUP BY cargo;

SELECT *FROM vw_resumo_cargos;

-- ============================================================
-- EXERCÍCIO 6 - CONSULTANDO UMA VIEW
-- Nível: INTERMEDIÁRIO
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> utilizar uma VIEW já criada
--   -> WHERE
--   -> ORDER BY
--
-- Utilize a VIEW vw_faixa_salarial criada anteriormente.
--
-- Faça uma consulta que:
-- 1. Mostre somente funcionários da faixa salarial 'Alta'.
-- 2. Ordene o resultado do maior salário para o menor.
--
-- IMPORTANTE:
-- Neste exercício NÃO crie uma nova VIEW.
-- Faça apenas um SELECT utilizando a VIEW existente.
--
-- Desenvolva abaixo:

SELECT * FROM vw_faixa_salarial
WHERE faixa_salarial = 'Alta'
ORDER BY salario DESC;

-- ============================================================
-- EXERCÍCIO 7 - VIEW PARA RELATÓRIO
-- Nível: INTERMEDIÁRIO / AVANÇADO
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> CREATE VIEW
--   -> YEAR()
--   -> YEAR(CURDATE())
--
-- Crie uma VIEW chamada vw_tempo_funcionario.
--
-- Como o banco possui a data de nascimento, crie uma coluna
-- calculada chamada idade_aproximada.
--
-- Utilize:
--
-- YEAR(CURDATE()) - YEAR(nascimento)
--
-- A VIEW deve mostrar:
--   • nome
--   • cargo
--   • nascimento
--   • idade_aproximada
--
-- OBSERVAÇÃO:
-- Esse cálculo gera uma idade aproximada, pois considera
-- somente os anos.
--
-- Depois, consulte a VIEW.
--
-- Desenvolva abaixo:

CREATE VIEW vw_tempo_funcionario AS
SELECT nome, cargo, nascimento,
YEAR(CURDATE()) - YEAR(nascimento) AS idade_aproximada
FROM funcionarios;

SELECT*FROM vw_tempo_funcionario;

-- OU

CREATE VIEW vw_tempo_funcionario_preciso AS
SELECT nome, cargo, nascimento,
TIMESTAMPDIFF(YEAR, nascimento, CURDATE()) AS idade
FROM funcionarios;

SELECT*FROM vw_tempo_funcionario_preciso;

-- ============================================================
-- EXERCÍCIO 8 - DESAFIO FINAL
-- Nível: DESAFIO
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> CREATE VIEW
--   -> CASE
--   -> campo calculado
--
-- Crie uma VIEW chamada vw_relatorio_funcionarios.
--
-- Ela deverá funcionar como um pequeno relatório da empresa.
--
-- Exiba:
--   • nome
--   • cargo
--   • salario
--   • salario_anual
--   • classificacao
--
-- A coluna salario_anual deve representar:
--
-- salario * 12
--
-- A coluna classificacao deve utilizar CASE:
--
-- salário menor que 5.000
--     -> 'Até 5 mil'
--
-- salário entre 5.000 e 10.000
--     -> 'De 5 a 10 mil'
--
-- salário maior que 10.000
--     -> 'Acima de 10 mil'
--
-- Depois de criar a VIEW, faça uma consulta mostrando apenas
-- os funcionários classificados como 'Acima de 10 mil',
-- ordenando pelo maior salario_anual.
--
-- Desenvolva abaixo:




-- ============================================================
-- EXERCÍCIO EXTRA - MANUTENÇÃO DE VIEW
-- ============================================================
--
-- RECURSOS OBRIGATÓRIOS:
--   -> SHOW CREATE VIEW
--   -> DROP VIEW
--
-- 1. Mostre o comando utilizado pelo MySQL para criar a VIEW
--    vw_funcionarios_basico.
--
-- 2. Depois, exclua essa VIEW.
--
-- ATENÇÃO:
-- Execute este exercício somente depois de terminar os demais.
--
-- Desenvolva abaixo:




-- ============================================================
-- FIM DOS EXERCÍCIOS
-- ============================================================
--
-- Antes de entregar:
--
-- 1. Execute cada CREATE VIEW.
-- 2. Execute um SELECT para conferir o resultado.
-- 3. Verifique se os nomes das colunas estão claros.
-- 4. Confira se os filtros e cálculos estão corretos.
--
-- ============================================================
