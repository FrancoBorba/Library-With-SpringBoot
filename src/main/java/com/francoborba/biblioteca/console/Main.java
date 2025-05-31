package com.francoborba.biblioteca.console;

import java.util.Scanner;

import com.francoborba.biblioteca.domain.entities.Aluno;
import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.entities.Professor;
import com.francoborba.biblioteca.domain.entities.Usuario;
import com.francoborba.biblioteca.domain.repository.LivroRepository;
import com.francoborba.biblioteca.domain.repository.UsuarioRepository;
import com.francoborba.biblioteca.infraestructure.repositories.LivroRepositoryEmMemoria;
import com.francoborba.biblioteca.infraestructure.repositories.UsuarioRepositoryEmMemoria;
import com.francoborba.biblioteca.usecases.devolver.DevolverLivroUseCase;
import com.francoborba.biblioteca.usecases.emprestar.EmprestarLivroUseCase;

public class Main {
    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioRepositoryEmMemoria();
        LivroRepository livroRepository = new LivroRepositoryEmMemoria();

        EmprestarLivroUseCase emprestarLivro = new EmprestarLivroUseCase(livroRepository, usuarioRepository);
        DevolverLivroUseCase devolverLivro = new DevolverLivroUseCase(livroRepository, usuarioRepository);

        // Criar 4 alunos
        Aluno aluno1 = new Aluno("Ana", 10);
        Aluno aluno2 = new Aluno("Bruno", 8);
        Aluno aluno3 = new Aluno("Carla", 12);
        Aluno aluno4 = new Aluno("Diego", 15);

        // Criar 2 professores
        Professor professor1 = new Professor("Eduardo");
        Professor professor2 = new Professor("Fernanda");

        usuarioRepository.salvar(aluno1);
        usuarioRepository.salvar(aluno2);
        usuarioRepository.salvar(aluno3);
        usuarioRepository.salvar(aluno4);
        usuarioRepository.salvar(professor1);
        usuarioRepository.salvar(professor2);

        // Criar 10 livros
        for (int i = 1; i <= 10; i++) {
            Livro livro = new Livro("Livro " + i, i % 5 + 1, true, null);
            livroRepository.salvar(livro);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1. Emprestar livro");
            System.out.println("2. Devolver livro");
            System.out.println("3. Listar livros disponíveis");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuarioEmp = scanner.nextInt();
                    Usuario usuarioEmp = usuarioRepository.buscarPorId(idUsuarioEmp);
                    if (usuarioEmp == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Digite o ID do livro: ");
                    int idLivroEmp = scanner.nextInt();
                    Livro livroEmp = livroRepository.buscarPorId(idLivroEmp);
                    if (livroEmp == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }

                    emprestarLivro.emprestar(usuarioEmp.getId(), livroEmp.getId());
                    break;

                case 2:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuarioDev = scanner.nextInt();
                    Usuario usuarioDev = usuarioRepository.buscarPorId(idUsuarioDev);
                    if (usuarioDev == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Digite o ID do livro: ");
                    int idLivroDev = scanner.nextInt();
                    Livro livroDev = livroRepository.buscarPorId(idLivroDev);
                    if (livroDev == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }

                    devolverLivro.devolver(usuarioDev.getId(), livroDev.getId());
                    break;

                case 3:
                    System.out.println("\n--- LIVROS DISPONÍVEIS ---");
                     System.out.println(livroRepository.listarDisponiveis());
                    break;


                case 4:
                    System.out.println("Encerrando aplicação...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
