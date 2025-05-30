/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: Usuario
* Funcao...........: Classe abstrata para definir os atributos obrigatorios de um Aluno e Professor
*************************************************************** */
package com.francoborba.biblioteca.domain.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
  private int id;
  private String nome;

  private ArrayList<Livro> livrosEmprestados;
  

  public Usuario(int id, String nome) {
    this.id = id;
    this.nome = nome;
    livrosEmprestados = new ArrayList<>();
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



   /* ***************************************************************
* Metodo: getLivros
* Funcao: Retornar todos os livros que o usuario tem emprestado
* Parametros: void
* Retorno: List<Livro>
*************************************************************** */
 public List<Livro> getLivros() {
    return new ArrayList<>(livrosEmprestados);
}

 /* ***************************************************************
* Metodo: adicionarLivro
* Funcao: adicionar um livro da lista de livros ou seja pegar um livro emprestado
* Parametros: Livro a ser adicionado
* Retorno: void
*************************************************************** */
public boolean adicionarLivro(Livro livro) {
   return this.livrosEmprestados.add(livro);

}

 /* ***************************************************************
* Metodo: removerLivro
* Funcao: remover um livro da lista de livros
* Parametros: Livro a ser removido
* Retorno: void
*************************************************************** */
public void removerLivro(Livro livro) {
    this.livrosEmprestados.remove(livro);
}

  


}
