/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Inicio...........: 30/05/2025
* Ultima alteracao.: 30/05/2025
* Nome.............: Aluno
* Funcao...........: Classe para reresentar Aluno e seu dominio , extensao de usuario
*************************************************************** */
package com.francoborba.biblioteca.domain.entities;

public class Aluno extends Usuario {
  
  private int creditos;


  public Aluno(int id, String nome, int creditos) {
    super(id, nome);
    this.creditos = creditos;
  }

   /* ***************************************************************
* Metodo: getCreditos
* Funcao: verificar quantos creditos o aluno tem
* Parametros: void
* Retorno: int
*************************************************************** */
 public int getCreditos() {
    return creditos;
  }

  @Override
  public void adicionarLivro(Livro livro) {
    int creditosAposEmprestimo = creditos - livro.getValorCredito(); // verifica os creditos no possivel emprestimo
    if(creditosAposEmprestimo >= 0 ){ // se ficar maior do que ou igual a 0 empresta
      System.out.println("Livro "+ livro.getTitulo() +" pego emprestado com sucesso");
      super.adicionarLivro(livro);
      this.creditos = creditosAposEmprestimo; // atualiza os creditos
    }else{ // caso nao de apenas imprime a mensagem
      System.out.println("Sem créditos para pegar emprestado este livro");
    }
}
 
}
