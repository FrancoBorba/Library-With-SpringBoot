/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: UsuarioRepository
* Funcao...........: Clase que ira representar o bando de dados implementado o Livro repository afim de garantir a clean architetures
*************************************************************** */
package com.francoborba.biblioteca.infraestructure.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.repository.LivroRepository;

public class RepositoryEmMemoria implements LivroRepository{

  // hash map com chave o id e valor o livro
  private final Map<Integer, Livro> livros = new HashMap<>();
  private int proximoId = 0; // contador de ID para o livro

  @Override
  public Livro buscarPorId(int id) {
    return livros.get(id);
  }

  @Override
  public void salvar(Livro livro) {
    livros.put(proximoId++, livro);
  }

  @Override
  public void remover(Livro livro) {
    livros.remove(livro.getId());
  }

  @Override
  public List<Livro> listarTodos() {
    return new ArrayList<>(livros.values());
  }

  @Override
  public List<Livro> listarDisponiveis() {

    List<Livro> disponiveis = new ArrayList<>();

    for(Livro livro : livros.values()){
        if(livro.estaDisponivel()){
          disponiveis.add(livro);
        }
    }
    return disponiveis;
  }
  
  
}
