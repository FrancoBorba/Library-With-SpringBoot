/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: Livro
* Funcao...........: Representar o objeto Livro e seu dominio
*************************************************************** */
package com.francoborba.biblioteca.domain.entities;

public class Livro {
  private int id;
  private String titulo;
  private int valorCredito;
  private Boolean disponivel;
  private Usuario emprestadoPara;



  public Livro(int id, String titulo, int valorCredito, Boolean disponivel, Usuario emprestadoPara) {
    this.id = id;
    this.titulo = titulo;
    this.valorCredito = valorCredito;
    this.disponivel = disponivel;
    this.emprestadoPara = emprestadoPara;
  }
  
 /* ***************************************************************
* Metodo: getId
* Funcao: retornar o ID do livro
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getId() {
    return id;
  }

 /* ***************************************************************
* Metodo: getTitulo
* Funcao: retornar o titulo do livro
* Parametros: void
* Retorno: String
*************************************************************** */
  public String getTitulo() {
    return titulo;
  }


   /* ***************************************************************
* Metodo: getValorCredito
* Funcao: retornar quantos creditos um aluno precisa para poder
* pegar emprestado este livro
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getValorCredito() {
    return valorCredito;
  }


   /* ***************************************************************
* Metodo: estaDisponivel
* Funcao: verificar se o livro esta disponivel(terao mais de um livro do mesmo tipo?)
* Parametros: void
* Retorno: boolean
*************************************************************** */
  public Boolean estaDisponivel() {
    return disponivel;
  }

   /* ***************************************************************
* Metodo: emprestadoPara
* Funcao: Retornar o usuario que esta com o livro
* Parametros: void
* Retorno: Usuario
*************************************************************** */
  public Usuario emprestadoPara() {
    return emprestadoPara;
  }


}
