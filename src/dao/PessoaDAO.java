package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Pessoa;

/**
 * A classe {@code PessoaDAO} é responável por métodos correspondentes as operações de CRUD no banco de dados relacionado
 * as pessoas cadastradas no sistema.
 * <p>
 * Utiliza a classe {@code ConexaoDb} para obter conexão com banco de dados.
 * </p>
 * 
 * 
 */
public class PessoaDAO {
	
	private ConexaoDb conexaoDb;

	/**
	 * Construtor padrão.
	 * Inicializa o objeto {@code ConexaoDb} para gerenciar a conexão com o banco de dados.
	 */
	public PessoaDAO(){
		this.conexaoDb = new ConexaoDb();
	}
	
	/**
	 * Abre novo cadastro no banco de dados.
	 * * @param pessoa O objeto {@code Pessoa} a ser cadastrado.
	 * @throws RuntimeException se ocorrer um erro de SQL durante o cadastro.
	 */
	public void abrirCadastro(Pessoa pessoa) {
		String sqlQuery = "INSERT INTO pessoas (nome, endereco, telefone, idade)" +
	                       "VALUES (?, ?, ?, ?)";
		
		try(Connection connection = conexaoDb.recuperaConexao();
				PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEndereco());
			ps.setString(3, pessoa.getTelefone());
			ps.setInt(4, pessoa.getIdade());
			ps.execute();
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao cadastrar pessoa", e);
		}			
	}
	
	/**
	 * Retorna todos os cadastros de pessoas no banco de dados.
	 * <p>
	 * * @return uma lista imutável de objetos {@code Pessoa}.
	 * @throws RuntimeException se ocorrer um erro de SQL durante a listagem.
	 */
	public List<Pessoa> listarTodosCadastros(){
		
		List<Pessoa> cadastros = new ArrayList<Pessoa>();
		String sqlQuery = """
				SELECT id, nome, endereco, telefone, idade
				FROM  pessoas
				ORDER BY id ASC """;
		
		try(Connection connection = conexaoDb.recuperaConexao();
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				int idade = rs.getInt("idade");
				
				if(endereco == null || endereco.isBlank()) {
					endereco = "não informado";
				}
				
				if(telefone == null || telefone.isBlank()) {
					telefone = "não informado";
				}
				
				Pessoa p = new Pessoa(id, nome, endereco, telefone, idade);
				cadastros.add(p);
			}
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao listar pessoas", e);
		}
		return  Collections.unmodifiableList(cadastros);
		
	}
	
	/**
	 * Busca uma pessoa no banco de dados utilizando o ID de cadastro fornecido.
	 * 
	 * * @param id O ID da pessoa a ser buscada.
	 * @return O objeto {@code Pessoa} correspondente ao ID, ou {@code null} se não for encontrado.
	 * @throws RuntimeException se ocorrer um erro de SQL durante a busca.
	 */
	public Pessoa buscaPorId(int id) {
		String sqlQuery = """ 
				SELECT id, nome, endereco, telefone, idade		
				FROM pessoas
				WHERE id = ?				
				""";
		try(Connection connection = conexaoDb.recuperaConexao();
			PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					int pessoaId = rs.getInt("id");
					String nome = rs.getString("nome");
					String endereco = rs.getString("endereco");
					String telefone = rs.getString("telefone");
					int idade = rs.getInt("idade");
					
					return new Pessoa(pessoaId, nome, endereco, telefone, idade);
				}
				else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar pessoa com id: " + id, e);
		}		
	}
	
	/**
	 * Atualiza as informações de uma pessoa existente no banco de dados.
	 * 
	 * A atualização é baseada no ID contido no objeto {@code Pessoa}.
	 * * @param pessoa O objeto {@code Pessoa} com as informações atualizadas.
	 * @throws RuntimeException se ocorrer um erro de SQL durante a atualização.
	 */
	public void alteraPessoa(Pessoa pessoa) {
		String sqlQuery = """
				UPDATE pessoas 
				SET nome = ?, endereco = ?, telefone = ?, idade = ?
				WHERE ID = ?
				""";
		try(Connection connection = conexaoDb.recuperaConexao();
			PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEndereco());
			ps.setString(3, pessoa.getTelefone());
			ps.setInt(4, pessoa.getIdade());
			ps.setInt(5, pessoa.getId());
			
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar pessoa", e);
		}
	}
	
	/**
	 * Remove uma pessoa do banco de dados com base no ID fornecido.
	 * @param id o ID da pessoa a ser removida.
	 * @throws RuntimeException se ocorrer um erro de SQL durante a remoção.
	 */
	public void removerPessoa(int id) {
		String sqlQuery = "DELETE FROM pessoas WHERE id = ?";
		
		try(Connection connection = conexaoDb.recuperaConexao();
			PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			
			ps.setInt(1, id);
			ps.execute();
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao remover pessoa", e);
		}
	}
	/**
	 * Verifica se a tabela de pessoas no banco de dados está vazia.
	 * * @return {@code true} se a tabela não tiver registros, {@code false} caso contrário.
	 * @throws RuntimeException se ocorrer um erro de SQL durante a verificação.
	 */
	public  boolean isVazia() {
		String sqlQuery = "SELECT COUNT(*) FROM pessoas";
		
		try(Connection connection = conexaoDb.recuperaConexao();
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery()){
			
			if(rs.next()) {
				return rs.getInt(1) == 0;
			}
		}catch (SQLException e) {
			throw new RuntimeException("Erro  ao verificar se a agenda esta vázia", e);
		}
		
		return true;
	}
}







