package com.francoborba.biblioteca.usecases;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.francoborba.biblioteca.domain.entities.Aluno;
import com.francoborba.biblioteca.domain.entities.Livro;
import com.francoborba.biblioteca.domain.repository.LivroRepository;
import com.francoborba.biblioteca.domain.repository.UsuarioRepository;
import com.francoborba.biblioteca.usecases.devolver.DevolverLivroUseCase;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DevolverLivroUseCaseTest {
   @Mock
  private LivroRepository livroRepository;

  @Mock
  private UsuarioRepository usuarioRepository;

  @Mock
  private Livro livro;

  @Mock
  private Aluno aluno;

  @InjectMocks
  private DevolverLivroUseCase devolverLivroUseCase;

  @BeforeEach
  void setup(){
    devolverLivroUseCase = new DevolverLivroUseCase(livroRepository, usuarioRepository);
  }

  @Test
  void devolverLivroComSucesso(){
    // cria o mock de aluno
    when(usuarioRepository.buscarPorId(1)).thenReturn(aluno);
    // cria o mock de livro
    when(livroRepository.buscarPorId(1)).thenReturn(livro);
  
     when(livroRepository.listarDisponiveis()).thenReturn(List.of(livro));

     devolverLivroUseCase.devolver(1  , 1);

    // verifica se o aluno teve o livro removido
     verify(aluno).removerLivro(livro);

     verify(livro).devolver();
     
  }

  @Test
  void naoDevolverQuandoUsuarioNaoExiste(){
    // usuario nao exite
    when(usuarioRepository.buscarPorId(1)).thenReturn(null);

    devolverLivroUseCase.devolver(1  , 1);

    // nao deve nem procurar o livro ja que o usuario nao existe
    verify(livroRepository , never()).buscarPorId(anyInt());
  }

  @Test
  void naoDevolverQuandoLivroNaoExiste(){
    // usuario  exite
    when(usuarioRepository.buscarPorId(1)).thenReturn(aluno);
    // livro nao existe
    when(livroRepository.buscarPorId(1)).thenReturn(null);

    devolverLivroUseCase.devolver(1  , 1);

    // nao se deve chamar esses metodos
    verify(aluno, never()).removerLivro(livro);
    verify(livro, never()).devolver();
  }

  @Test
  void verificarSeFoiChamadoDuasVezes(){
     when(usuarioRepository.buscarPorId(1)).thenReturn(aluno);
    // cria o mock de livro
    when(livroRepository.buscarPorId(1)).thenReturn(livro);
  
     when(livroRepository.listarDisponiveis()).thenReturn(List.of(livro));

     devolverLivroUseCase.devolver(1  , 1);

     verify(livroRepository, times(2)).listarDisponiveis();
  }
  
  
}
