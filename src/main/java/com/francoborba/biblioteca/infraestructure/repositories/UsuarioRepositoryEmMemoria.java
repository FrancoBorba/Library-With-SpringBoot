package com.francoborba.biblioteca.infraestructure.repositories;


import java.util.HashMap;
import java.util.Map;
import com.francoborba.biblioteca.domain.entities.Usuario;
import com.francoborba.biblioteca.domain.repository.UsuarioRepository;

public class UsuarioRepositoryEmMemoria implements UsuarioRepository {
  // hash map com chave o id e valor o livro
  private final Map<Integer, Usuario> usuarios = new HashMap<>();
  private int proximoId = 1; // contador de ID para o livro

  @Override
  public Usuario buscarPorId(int id) {
    return usuarios.get(id);
  }
  @Override
  public void salvar(Usuario usuario) {
    usuario.setId(proximoId);
   usuarios.put(proximoId++, usuario);
  }
  @Override
  public void remover(Usuario usuario) {
    usuarios.remove(usuario.getId());
  }
 
}
