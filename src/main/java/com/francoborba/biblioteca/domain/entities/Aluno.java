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
 
}
