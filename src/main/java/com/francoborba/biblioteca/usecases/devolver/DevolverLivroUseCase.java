/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: DevolverLivroUseCase
* Funcao...........: Devolver o livro para a biblioteca com todas as regras de negocio
*************************************************************** */
package com.francoborba.biblioteca.usecases.devolver;

import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.entities.Usuario;
import com.francoborba.biblioteca.domain.repository.LivroRepository;
import com.francoborba.biblioteca.domain.repository.UsuarioRepository;

public class DevolverLivroUseCase {
  
    private final LivroRepository livroRepository;
  private final UsuarioRepository usuarioRepository;

  // Construtor com a injecao de dependencia 
  public DevolverLivroUseCase(LivroRepository livroRepository , UsuarioRepository usuarioRepository){
    this.livroRepository = livroRepository;
    this.usuarioRepository = usuarioRepository;  
  }

 /* ***************************************************************
* Metodo: devolver
* Funcao: devolver um Livro a biblioteca com todas as regras de negocio e validacoes
* Parametros: id do usuario que vai remover e id do livro a ser removido
* Retorno: void
*************************************************************** */
  public void devolver(int idUsuario , int idLivro){
    // Buscar o usuario e o livro
    Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
    

    // verificar se o usuario existe
    if (usuario == null) {
      System.out.println("Usuário não encontrado.");
      return;
    }

  Livro livro = livroRepository.buscarPorId(idLivro); // so busca depois (identifiquei no teste)
    // Verificar se o livro existe
    if(livro == null){
      System.out.println("Este livro não pertence a esta biblioteca");
      return ;
    }

    // listar todos os livros disponiveis antes da devolucao
    System.out.println("Livros disponiveis antes da devolução: " + livroRepository.listarDisponiveis());

    usuario.removerLivro(livro); // faz a validacao de creditos

    livro.devolver(); // marca como disponivel

   // listar todos os livros disponiveis depois da devolucao
    System.out.println("Livros disponiveis depois da devolução: " + livroRepository.listarDisponiveis());

  }


}
