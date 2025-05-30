/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: UsuarioRepository
* Funcao...........: Interface de Usuario que ira definir o contrato para a persistencia de dados
* ou seja que o BD(em memoria) tera que implementar
*************************************************************** */
package com.francoborba.biblioteca.domain.repository;

import com.francoborba.biblioteca.domain.entities.Usuario;

public interface UsuarioRepository {
    Usuario buscarPorId(int id);
    void salvar(Usuario usuario);
    void remover(Usuario usuario);
}
