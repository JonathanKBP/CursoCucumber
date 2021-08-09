# language: pt

Funcionalidade: Alugar Filme
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços de datas de entrega

Cenário: Deve alugar um filme com sucesso
  Dado um filme com estoque de 2 unidades
  E que o preço do aluguel seja R$ 3
  Quando alugar
  Então o preço do aluguel será R$ 3
  E a data de entrega será em 1 dia
  E o estoque do filme será 1 unidades

Cenário: Não deve alugar filme sem estoque
  Dado um filme com estoque de 0 unidades
  Quando alugar
  Então não será possivel por falta de estoque
  E o estoque do filme será 0 unidades

Cenário: Deve dar condições especiais para categoria extendida
  Dado um filme com estoque de 2 unidades
  E que o preço do aluguel seja R$ 4
  E que o tipo de aluguel seja extendido
  Quando alugar
  Então o preço do aluguel será R$ 8
  E a data de entrega será em 3 dias
  E a pontuação será de 2 pontos

Cenário: Deve alugar para categoria comum
  Dado um filme com estoque de 2 unidades
  E que o preço do aluguel seja R$ 4
  E que o tipo de aluguel seja comum
  Quando alugar
  Então o preço do aluguel será R$ 4
  E a data de entrega será em 1 dia
  E a pontuação será de 1 pontos