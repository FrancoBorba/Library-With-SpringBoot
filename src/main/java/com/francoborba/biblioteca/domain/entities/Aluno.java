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


  public Aluno( String nome, int creditos) {
    super( nome);
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

     /* ***************************************************************
* Metodo: adicionarLivros
* Funcao: adicionar um livro a lista de livros de um Aluno com as regras de negocio
* Parametros: Livro a ser adicionado
* Retorno: boolean(retorna true se for adicionado e false se nao for)
*************************************************************** */
  @Override
  public boolean adicionarLivro(Livro livro) {
    int creditosAposEmprestimo = creditos - livro.getValorCredito(); // verifica os creditos no possivel emprestimo
    if(creditosAposEmprestimo >= 0 ){ // se ficar maior do que ou igual a 0 empresta
      System.out.println("Livro "+ livro.getTitulo() +" pego emprestado com sucesso");
      super.adicionarLivro(livro);
      this.creditos = creditosAposEmprestimo; // atualiza os creditos
      return true;
    }else{ // caso nao de apenas imprime a mensagem
      System.out.println("Sem créditos para pegar emprestado este livro");
     return false;
    }
    
}

 /* ***************************************************************
* Metodo: removerLivros
* Funcao: remover um livro da lista de livros de um Aluno com as regras de negocio
* Parametros: Livro a ser rmeovido
* Retorno: void
*************************************************************** */
 @Override 
 public void removerLivro(Livro livro){
  int creditosAntesDoEmprestimo = creditos;
  super.removerLivro(livro);
  this.creditos = creditosAntesDoEmprestimo + livro.getValorCredito();
  System.out.println("Livro devolvido com sucesso , créditos atualizados para: " + creditos );
 }
 
}
