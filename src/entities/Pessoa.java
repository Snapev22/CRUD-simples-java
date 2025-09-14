package entities;

import Exceptions.RegraDeNegocioExecpetion;

/**
 * Classe responsável por representar uma pessoa a ser cadastrada.
 * 
 */
public class Pessoa implements Comparable<Pessoa> {

	private static int proximoId = 1;
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private int idade;

	public Pessoa() {
		
		this.id = proximoId;
		proximoId++;
	}

	public Pessoa(String nome, String endereco, String telefone, int idade) {
		this();
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		setIdade(idade);
	}

	/**
	 * Compara pessoas 	para ordennação.
	 * <p>
	 * A ordenação é baseada no nome de cada pessoa.
	 * 
	 * @param proxima A outra pessoa a ser comparada.
	 * @return um valor negativo, zero ou positivo se essa pessoa for, respectivamente,
	 * menor que, igual a, ou maior que  a pessoa especificada.
	 */
	@Override
	public int compareTo(Pessoa proxima) {

		return this.nome.compareTo(proxima.getNome());
	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @throws RegraDeNegocioException se o nome for nulo, vazio ou tiver caracteres inválidos.
	 */

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new RegraDeNegocioExecpetion("Campo nome não pode ser vázio.");
		}
		if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+$")) {
			throw new RegraDeNegocioExecpetion("Nome digitado não é valido.");
		}
		this.nome = nome.trim();
	}

	public String getEndereco() {
		return endereco;
	}

	/**
	 * 
	 * @throws RegraDeNegocioException se o endereço for nulo, vazio ou tiver caracteres inválidos.
	 */
	public void setEndereco(String endereco) {
		if (endereco == null || endereco.trim().isBlank()) {
			throw new RegraDeNegocioExecpetion("Campo endereço não pode ser vazio.");
		}
		if (!endereco.matches("^[A-Za-zÀ-ÖØ-öø-ÿ0-9,\\-\\s]+$")) {
			throw new RegraDeNegocioExecpetion("Campo endereço foi digitado com caracteres inválidos.");
		}
		this.endereco = endereco.trim();
	}

	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * @throws RegraDeNegocioException se o telefone for nulo, vazio ou tiver caracteres inválidos.
	 */
	public void setTelefone(String telefone) {
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new RegraDeNegocioExecpetion("Campo telefone não pode ser vazio.");
		}

		if (!telefone.matches("^[0-9()+\\-\\s]+$")) {
			throw new RegraDeNegocioExecpetion("Telefone inválido.");
		}

		this.telefone = telefone.trim();
	}	
	
	public int getIdade() {
		return idade;
	}

	/**
	 * 
	 * @throws RegraDeNegocioException se idade for diferente de um número inteiro positivo.
	 */
	public void setIdade(int idade) {
		if (idade <= 0) {
			throw new RegraDeNegocioExecpetion("Idade só pode ser um inteiro positivo");
		}
		this.idade = idade;
	}

	@Override
	public String toString() {
		
		return  "ID: " + this.id + 
				"\nNome: " + this.nome 
				+"\nIdade: " + this.idade
				+"\nTelefone: " + this.telefone
				+"\nEndereço: "  + this.endereco + "\n";
	}
}
