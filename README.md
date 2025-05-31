# 📚 Biblioteca Simulada - Teste Prático Estágio Java

Projeto desenvolvido como teste prático para simular o funcionamento básico de uma biblioteca, onde usuários (alunos e professores) podem pegar e devolver livros emprestados.

---

## ✅ Funcionalidades Implementadas


- 📥 Empréstimo de livros:
  - Alunos só podem emprestar se tiverem **créditos >= 0**.
  - Professores podem emprestar livremente.
  - Alunos perdem  crédito por empréstimo.
- 📤 Devolução de livros:
  - Somente o **usuário que pegou o livro** pode devolvê-lo.
  - Alunos ganham  crédito equivalente ao do livro ao devolver.
- 📄 Exibição da lista de livros disponíveis antes e depois das operações.
- 🚫 Validações completas:
  - Livro inexistente
  - Livro não está com o usuário
  - Usuário não possui créditos
  - Usuário não cadastrado

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4**
- **JUnit 5** para testes unitários
- Arquitetura baseada em princípios **Clean Architecture**:
  - Separação entre domínio, casos de uso e infraestrutura
  - Baixo acoplamento entre camadas
- Banco de dados em **memória** (listas e mapas)

---
## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/seu-repo.git
   cd seu-repo
   
2. **Importe o projeto em sua IDE (IntelliJ, VS Code, Eclipse, etc.)**

Execute a aplicação:

A aplicação roda diretamente no console. Execute a seguinte classe:
   
   src/main/java/com/francoborba/biblioteca/console/Main.java

  ## 🧪 Testes
Os testes unitários foram desenvolvidos com JUnit 5.

Testam os principais fluxos de empréstimo e devolução, incluindo cenários de sucesso e erro.

  
## 💡 Observações Finais
O projeto não utiliza banco de dados, respeitando o requisito de manter os dados apenas em memória.

Não há interface REST ou Web — a execução e interação com o sistema ocorre 100% no terminal/console. Podendo ser expandido no futuro

A arquitetura foi pensada com foco em organização, boas práticas e testabilidade.

## 👨‍💻 Autor
Franco Ribeiro Borba
Estudante de Ciência da Computação
GitHub: @FrancoBorba
