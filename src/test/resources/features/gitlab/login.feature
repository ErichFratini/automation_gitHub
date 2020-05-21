#language: pt

Funcionalidade: Login

  Contexto:
    Dado que eu esteja na tela de login
    Quando faço login com o usuario "" e senha ""
    Então sou autenticado com sucesso

  @ID01
  Cenário: ID01 - Realizar login
    Dado que eu esteja na tela de login
    Quando faço login com o usuario "" e senha ""
    Então sou autenticado com sucesso
