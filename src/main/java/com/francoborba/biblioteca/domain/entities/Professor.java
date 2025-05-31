/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: Professor
* Funcao...........: Classe para representar o Professor e seus dominio, extensao de usuario
*************************************************************** */
package com.francoborba.biblioteca.domain.entities;

public class Professor extends Usuario {

  public Professor( String nome) {
    super(nome);

  }

   @Override
  public boolean adicionarLivro(Livro livro) {
    System.out.println("Professor " + getNome() + " pegou o livro " + livro.getTitulo() + " emprestado.");
    return super.adicionarLivro(livro);
  }

}
