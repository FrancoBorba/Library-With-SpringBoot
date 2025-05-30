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

  public void devolver(int idUsuario , int idLivro){
    // Buscar o usuario e o livro
    Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
    Livro livro = livroRepository.buscarPorId(idLivro);

    // verificar se o usuario existe
    if (usuario == null) {
      System.out.println("Usuário não encontrado.");
      return;
    }

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

        // Atualizar os dados nos repositorios
        usuarioRepository.salvar(usuario); // ou atualizar(usuario)
        livroRepository.salvar(livro); // ou atualizar(livro)





  }


}
