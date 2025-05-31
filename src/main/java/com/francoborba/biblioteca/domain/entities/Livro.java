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



  public Livro( String titulo, int valorCredito, Boolean disponivel, Usuario emprestadoPara) {
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
* Metodo: setId
* Funcao: definir  o ID do livro
* Parametros: int
* Retorno: void
*************************************************************** */
  public void setId(int id) {
    this.id = id;
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

  
   /* ***************************************************************
* Metodo: emprestarPara
* Funcao: Emprestar o livro para o usuario caso disponivel
* Parametros: Usuario que deseja o livro
* Retorno: void
*************************************************************** */
  public void emprestarPara(Usuario usuario){
    if(!disponivel){ // verifica disponibilidade
      System.out.println("Livro " + titulo + " está indisponivel ");
    }
    this.emprestadoPara = usuario; // Adiciona o usario que esta com o livro
    this.disponivel = false; // Muda a disponibilidade para falso
  }


    
   /* ***************************************************************
* Metodo: devolver
* Funcao: Definir o livro como disponivel de novo
* Parametros: void
* Retorno: void
*************************************************************** */
  public void devolver(){
    System.out.println("Livro " + titulo + " devolvido");
    this.disponivel = true;
  }

  @Override
  public String toString() {
    return "Livro [titulo=" + titulo + ", valorCredito=" + valorCredito + "]";
  }


}
