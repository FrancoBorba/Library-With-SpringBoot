/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: UsuarioRepository
* Funcao...........: Interface de Livro que ira definir o contrato para a persistencia de dados
* ou seja que o BD(em memoria) tera que implementar 
*************************************************************** */
package com.francoborba.biblioteca.domain.repository;

import com.francoborba.biblioteca.domain.entities.Livro;
import java.util.List;

public interface LivroRepository {
    Livro buscarPorId(int id);
    void salvar(Livro livro);
    void remover(Livro livro);
    List<Livro> listarTodos();
    List<Livro> listarDisponiveis();
}
