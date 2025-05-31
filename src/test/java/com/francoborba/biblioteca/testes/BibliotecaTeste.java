package com.francoborba.biblioteca.testes;

import com.francoborba.biblioteca.domain.entities.Aluno;
import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.entities.Professor;
import com.francoborba.biblioteca.domain.entities.Usuario;
import com.francoborba.biblioteca.infraestructure.repositories.LivroRepositoryEmMemoria;
import com.francoborba.biblioteca.infraestructure.repositories.UsuarioRepositoryEmMemoria;
import com.francoborba.biblioteca.usecases.devolver.DevolverLivroUseCase;
import com.francoborba.biblioteca.usecases.emprestar.EmprestarLivroUseCase;

public class BibliotecaTeste {
public static void main(String[] args) {

        // Repositórios
        LivroRepositoryEmMemoria livroRepo = new LivroRepositoryEmMemoria();
        UsuarioRepositoryEmMemoria usuarioRepo = new UsuarioRepositoryEmMemoria();

        // Use Cases (supondo que você tenha construtores padrão)
        EmprestarLivroUseCase emprestarUseCase = new EmprestarLivroUseCase(livroRepo, usuarioRepo);
        DevolverLivroUseCase devolverUseCase = new DevolverLivroUseCase(livroRepo, usuarioRepo);

        // Criar livros e salvar
        Livro l1 = new Livro( "Algoritmos", 3, true, null);
        Livro l2 = new Livro( "Estruturas de Dados", 2, true, null);
        Livro l3 = new Livro("Redes de computadores", 6 , true, null);
        livroRepo.salvar(l1);
        livroRepo.salvar(l2);
        livroRepo.salvar(l3);

        // Criar usuários (Aluno e Professor)
        Usuario aluno = new Aluno( "Franco Ribeiro", 10);
        Usuario professor = new Professor( "Dra. Silva");
        usuarioRepo.salvar(aluno);
        usuarioRepo.salvar(professor);

        // Testes de empréstimo
        System.out.println("Tentando emprestar livro para aluno:");
        emprestarUseCase.emprestar(aluno.getId(), l1.getId());
        

        System.out.println("Tentando emprestar mesmo livro para professor:");
        emprestarUseCase.emprestar(professor.getId(), l1.getId());
  

        System.out.println("Aluna pegando mais um livro:");
        emprestarUseCase.emprestar(aluno.getId(), l2.getId());



        System.out.println("Aluna pegando mais um livro:");
        emprestarUseCase.emprestar(aluno.getId(), l3.getId());

        System.out.println("Professor pegando livro de redes:");
        emprestarUseCase.emprestar(professor.getId(), l3.getId());

        System.out.println("Aluna devolvendo livro de estrutura de dados:");
        devolverUseCase.devolver(aluno.getId(), l2.getId());
     

     

    }
}
