-- EXERCÍCIO 1: filmes alugados mais de 5 vezes

SELECT id_filme, COUNT(*) AS contagem FROM alugueis
GROUP BY id_filme
HAVING contagem > 5
ORDER BY contagem;

-- EXERCÍCIO 2: clientes que fizeram 3 ou mais alugueis

SELECT id_cliente, COUNT(*) AS contagem FROM alugueis
GROUP BY id_cliente
HAVING contagem >= 3
ORDER BY contagem;

-- EXERCÍCIO 3: gêneros com média de preço acima de 2.50

SELECT genero, ROUND(AVG(preco_aluguel),2) AS media FROM filmes
GROUP BY genero
HAVING media > 2.5
ORDER BY media; 

-- EXERCÍCIO 4: anos com mais de 4 filmes cadastrados

SELECT ano_lancamento, COUNT(*) AS lancados FROM filmes
GROUP BY ano_lancamento
HAVING lancados > 4
ORDER BY lancados;

-- EXERCÍCIO 5: atores que atuaram em mais de 1 filme

SELECT id_ator, COUNT(*) AS contagem FROM atuacoes
GROUP BY id_ator
HAVING contagem > 1
ORDER BY contagem; 

-- EXERCÍCIO 6: estados com mais de 6 clientes

SELECT estado, COUNT(*) AS contagem FROM clientes
GROUP BY estado
HAVING contagem > 6
ORDER BY contagem;

-- EXERCÍCIO 7: filmes com média de nota maior que 8

SELECT id_filme, ROUND(AVG(nota), 2) AS media FROM alugueis
GROUP BY id_filme
HAVING media > 8
ORDER BY media;

-- EXERCÍCIO 8: clientes que alugaram 2+ filmes diferentes

SELECT id_cliente, COUNT(DISTINCT id_filme) AS alugados FROM alugueis
GROUP BY id_cliente
HAVING alugados > 2
ORDER BY alugados;

-- EXERCÍCIO 9: anos cuja soma de duração ultrapassa 500

SELECT ano_lancamento, ROUND(SUM(duracao),2) AS tempo FROM filmes
GROUP BY ano_lancamento
HAVING tempo > 500
ORDER BY tempo;

-- EXERCÍCIO 10: nacionalidades com mais de 8 atores

SELECT nacionalidade, COUNT(*) as patria FROM atores
GROUP BY nacionalidade
HAVING patria > 8
ORDER BY patria;