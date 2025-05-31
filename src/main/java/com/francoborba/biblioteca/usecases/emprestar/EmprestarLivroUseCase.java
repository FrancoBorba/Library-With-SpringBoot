/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: EmprestarLivroUseCase
* Funcao...........: Emprestar um livro para um usuario com todas as regras de negocio
*************************************************************** */
package com.francoborba.biblioteca.usecases.emprestar;


import com.francoborba.biblioteca.domain.entities.Aluno;
import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.entities.Usuario;
import com.francoborba.biblioteca.domain.repository.LivroRepository;
import com.francoborba.biblioteca.domain.repository.UsuarioRepository;

public class EmprestarLivroUseCase {

  private final LivroRepository livroRepository;
  private final UsuarioRepository usuarioRepository;

  // Construtor com a injecao de dependencia 
  public EmprestarLivroUseCase(LivroRepository livroRepository , UsuarioRepository usuarioRepository){
    this.livroRepository = livroRepository;
    this.usuarioRepository = usuarioRepository;  
  }

  
 /* ***************************************************************
* Metodo: emprestar
* Funcao: emprestar um livro da biblioteca com todas as regras de negocio e validacao
* Parametros: id do usuario que vai pegar o livro e id do livro a ser pego
* Retorno: void
*************************************************************** */
   public void emprestar(int idUsuario, int idLivro) {
        //  Buscar o usuario e o livro
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
     

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        // Listar os livros antes , listando todos os livros e somente os disponiveis
        System.out.println("Livros da biblioteca: "+ livroRepository.listarTodos());
        System.out.println("Livros disponives: " + livroRepository.listarDisponiveis());

   Livro livro = livroRepository.buscarPorId(idLivro); // corrigindo pois nao tinha passado no teste
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        

        //  Verificar se o livro esta disponível
        if (!livro.estaDisponivel()) {
            System.out.println("Livro indisponível para empréstimo.");
            return;
        }

      // Apenas mostrar a quantidade de Creditos se for aluno
        if (usuario instanceof Aluno) {
       Aluno aluno = (Aluno) usuario;
      System.out.println("Creditos atuais do aluno: " + aluno.getCreditos());
        }


        //  Realizar o empreestimo
     boolean emprestimoRealizado =  usuario.adicionarLivro(livro); // Aqui dentro faz a verificacao dos creditos e atualizacao

    if (!emprestimoRealizado) { // se falhar
      // A mensagem de erro ja e impressa dentro de adicionarLivro, entao so encerramos aqui
      return;
    }

        livro.emprestarPara(usuario); // deixa o livro como indisponivel e vincula ao usuario



    }

}
