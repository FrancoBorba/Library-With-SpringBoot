package com.francoborba.biblioteca.usecases;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import java.util.List;
import com.francoborba.biblioteca.domain.entities.*;
import com.francoborba.biblioteca.domain.repository.*;
import com.francoborba.biblioteca.usecases.emprestar.EmprestarLivroUseCase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmprestarLivroUseCaseTest {

  @Mock
  private LivroRepository livroRepository;

  @Mock
  private UsuarioRepository usuarioRepository;

  @Mock
  private Livro livro;

  @Mock
  private Aluno aluno;

  @InjectMocks
  private EmprestarLivroUseCase emprestarLivroUseCase;

  @BeforeEach
  void setup() {
    emprestarLivroUseCase = new EmprestarLivroUseCase(livroRepository, usuarioRepository);
  }

  @Test
  void deveEmprestarLivroComSucesso() {
   
    when(usuarioRepository.buscarPorId(1)).thenReturn(aluno); // simula que existe um usuario de id 1
    when(livroRepository.buscarPorId(1)).thenReturn(livro); // simula um livro de id 1
    when(livro.estaDisponivel()).thenReturn(true); // diz que o livro esta disponivel
    when(aluno.adicionarLivro(livro)).thenReturn(true); // simuula que o emprestimo foi aceito
    // apenas pq faco no use case mas indiferente para o teste
    when(livroRepository.listarTodos()).thenReturn(List.of(livro)); 
    when(livroRepository.listarDisponiveis()).thenReturn(List.of(livro));

    // simula que que o usuario 1 quer pegar emprestado o livro 1
    emprestarLivroUseCase.emprestar(1, 1);

    // verifica se o metodo foi chamado
    verify(aluno).adicionarLivro(livro);
    // Verifica que o livro "emprestou para" o aluno ou seja que a acao principal ocorreu
    verify(livro).emprestarPara(aluno);
  }

  @Test
  void naoEmprestaLivroIndisponivel() {
    when(usuarioRepository.buscarPorId(1)).thenReturn(aluno);
    when(livroRepository.buscarPorId(1)).thenReturn(livro);
    when(livro.estaDisponivel()).thenReturn(false); // diz que o livro nao esta disponivel
    when(livroRepository.listarTodos()).thenReturn(List.of(livro));
    when(livroRepository.listarDisponiveis()).thenReturn(List.of());

    emprestarLivroUseCase.emprestar(1, 1);

    // verifica que estes metodo nao podem ter sido chmado nem uma vez
    // ja que o livro esta indisponivel
    verify(aluno, never()).adicionarLivro(any());
    verify(livro, never()).emprestarPara(any());
  }

  @Test
  void naoEmprestaQuandoUsuarioNaoExiste() {
    // configura mock para que o usuario nao exista 
    when(usuarioRepository.buscarPorId(1)).thenReturn(null); 

    emprestarLivroUseCase.emprestar(1, 1);
 
    // logo nao deve nem buscar o livro ja que o usuario nao existe
    verify(livroRepository, never()).buscarPorId(anyInt());
  }

  @Test
  void naoEmprestaQuandoLivroNaoExiste() {
    when(usuarioRepository.buscarPorId(1)).thenReturn(aluno);
    //Configura o mock de livro para ser null
    when(livroRepository.buscarPorId(1)).thenReturn(null);

    emprestarLivroUseCase.emprestar(1, 1);

    // verifica que o metodo de adicionar livro nao foi chamado ja uqe livro nao existe
    verify(aluno, never()).adicionarLivro(any());
  }

  @Test
  void naoEmprestaSeAdicionarLivroFalhar() {
    when(usuarioRepository.buscarPorId(1)).thenReturn(aluno); // Mock do aluno
    when(livroRepository.buscarPorId(1)).thenReturn(livro); // Mock do Professor
    when(livro.estaDisponivel()).thenReturn(true); // livro disponivel
    when(aluno.adicionarLivro(livro)).thenReturn(false); // nao teria creditos suficientes
    when(livroRepository.listarTodos()).thenReturn(List.of(livro)); 
    when(livroRepository.listarDisponiveis()).thenReturn(List.of(livro));

    emprestarLivroUseCase.emprestar(1, 1);

    // Como o aluno nao tem creditos nao pode ser chamado emprestar para
    verify(livro, never()).emprestarPara(any());
  }
}
