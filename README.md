# 📚 Agenda CRUD em Java com Persistência MySQL

Projeto desenvolvido em **Java** para criar uma aplicação de agenda com gerenciamento completo de cadastros CRUD . É um demonstrativo prático da comunicação entre a aplicação e o banco de dados.

### 💡 O que este projeto demonstra:

* **Persistência de Dados:** Uso de **JDBC** para realizar operações CRUD diretamente no banco de dados **MySQL**.
* **Boas Práticas:** Implementação de um padrão em camadas (Service e DAO) para separar a lógica de negócio do acesso a dados.
* **Tratamento de Erros:** Validação de regras de negócio (`RegraDeNegocioExcepetion`) para garantir a integridade dos dados.
* **Funcionalidades:** Cadastro, busca, alteração, remoção e filtros por idade e ordenação alfabética.

### 🛠️ Tecnologias Chave

* **Linguagem:** Java
* **Banco de Dados:** MySQL
* **Conexão:** JDBC
* **Extra:** Configuração para **HikariCP** (Pool de Conexões).

### 🚀 Como Rodar

1.  Clone o repositório.
2.  Configure o schema `agenda_db` e a tabela `pessoas` no MySQL.
3.  Ajuste as credenciais de acesso no arquivo `dao/ConexaoDb.java`.
4.  Execute a classe `main.AgendaTest01.java` para iniciar o menu via `JOptionPane`.