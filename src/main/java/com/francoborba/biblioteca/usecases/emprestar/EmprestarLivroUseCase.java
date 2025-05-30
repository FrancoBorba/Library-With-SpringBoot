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
   public void emprestar(int idUsuario, int idLivro) {
        //  Buscar o usuario e o livro
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
        Livro livro = livroRepository.buscarPorId(idLivro);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        // Listar os livros antes , listando todos os livros e somente os disponiveis
        System.out.println("Livros da biblioteca: "+ livroRepository.listarTodos());
        System.out.println("Livros disponives: " + livroRepository.listarDisponiveis());


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


        // Atualizar os dados nos repositorios
        usuarioRepository.salvar(usuario); // ou atualizar(usuario)
        livroRepository.salvar(livro); // ou atualizar(livro)

     
    }

}
