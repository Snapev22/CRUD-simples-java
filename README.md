# 📚 Agenda CRUD em Java com Persistência MySQL

Este é um sistema de **Agenda CRUD** construído em **Java**, que utiliza a **API JDBC** para persistência de dados em um banco de dados **MySQL**. É um demonstrativo prático da comunicação entre a aplicação e o banco de dados.

### 💡 O que este projeto demonstra:

* **Persistência de Dados:** Uso de **JDBC** para realizar operações CRUD diretamente no banco de dados **MySQL**.
* **Boas Práticas:** Implementação de um **padrão em camadas** (Service e DAO) para separar a lógica de negócio do acesso a dados.
* **Tratamento de Erros:** Validação de regras de negócio (`RegraDeNegocioExcepetion`) para garantir a integridade dos dados.
* **Funcionalidades:** Cadastro, busca, alteração, remoção e filtros por idade e ordenação alfabética.

### 🛠️ Tecnologias Chave

* **Linguagem:** Java
* **Banco de Dados:** MySQL
* **Conexão:** JDBC
* **Extra:** Configuração para **HikariCP** (Pool de Conexões).

### 🔩 Estrutura do Banco de Dados (Tabela `pessoas`)

Para rodar o projeto, utilize a seguinte estrutura básica para a tabela `pessoas` no seu MySQL:

```sql
CREATE TABLE pessoas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    idade INT NOT NULL
);

### 🚀 Como Rodar

1.  Clone o repositório.
2.  Configure o schema `agenda_db` e a tabela `pessoas` no MySQL.
3.  Ajuste as credenciais de acesso no arquivo `dao/ConexaoDb.java`.
4.  Execute a classe `main.AgendaTest01.java` para iniciar o menu via `JOptionPane`.