#language: pt

Funcionalidade: Login

  @ID01
  Cenário: ID01 - Realizar login
    Dado que eu esteja na tela de login
    Quando faço login com o usuario "erich.fratini.1998" e senha "treinamentogit"
    Então sou autenticado com sucesso

  @ID02
  Cenário: ID02 - Debug stopots
    Dado que eu esteja no stopots "https://stopots.com.br/"
