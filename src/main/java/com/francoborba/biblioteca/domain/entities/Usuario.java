/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: Usuario
* Funcao...........: Classe abstrata para definir os atributos obrigatorios de um Aluno e Professor
*************************************************************** */
package com.francoborba.biblioteca.domain.entities;

public abstract class Usuario {
  private int id;
  private String nome;
  

  public Usuario(int id, String nome) {
    this.id = id;
    this.nome = nome;
  }


   /* ***************************************************************
* Metodo: getId
* Funcao: verificar o ID do Usuario
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getId() {
    return id;
  }

   /* ***************************************************************
* Metodo: getNome
* Funcao: verificar o nome do Usuario
* Parametros: void
* Retorno: String
*************************************************************** */
  public String getNome() {
    return nome;
  }


}
