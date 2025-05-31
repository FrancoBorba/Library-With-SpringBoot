package com.francoborba.biblioteca.testes;

import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.repository.LivroRepository;
import com.francoborba.biblioteca.infraestructure.repositories.LivroRepositoryEmMemoria;

public class TesteLivroRepository { 
  public static void main(String[] args) {
    LivroRepository livroRepo = new LivroRepositoryEmMemoria();

    // Criando livros
    Livro l1 = new Livro("Clean Code", 2, true, null);
    Livro l2 = new Livro("Domain-Driven Design", 3, true, null);
    Livro l3 = new Livro("Refatoração", 2, false, null); // este já não está disponível

    // Salvando livros
    livroRepo.salvar(l1);
    livroRepo.salvar(l2);
    livroRepo.salvar(l3);

    // Testar listarTodos
    System.out.println("📚 Todos os livros:");
    livroRepo.listarTodos().forEach(l -> System.out.println(l.getId() + " - " + l.getTitulo()));

    // Testar listarDisponiveis
    System.out.println("\n✅ Livros disponíveis:");
    livroRepo.listarDisponiveis().forEach(l -> System.out.println(l.getId() + " - " + l.getTitulo()));

    // Buscar por ID
    System.out.println("\n🔍 Buscar livro ID 1:");
    Livro buscado = livroRepo.buscarPorId(1);
    if (buscado != null) {
      System.out.println("Encontrado: " + buscado.getTitulo());
    } else {
      System.out.println("Livro não encontrado.");
    }

    // Remover livro
    System.out.println("\n❌ Removendo livro ID 1...");
    livroRepo.remover(buscado);

    // Listar novamente
    System.out.println("\n📚 Todos os livros após remoção:");
    livroRepo.listarTodos().forEach(l -> System.out.println(l.getId() + " - " + l.getTitulo()));
  }
}
