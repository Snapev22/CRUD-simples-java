package Dominio;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private String endereco;
	private String telefone;
	private int idade;

	public Pessoa() {

	}

	public Pessoa(String nome, String endereco, String telefone, int idade) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		setIdade(idade);
	}

	@Override
	public int compareTo(Pessoa proxima) {

		return this.nome.compareTo(proxima.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Campo nome não pode ser vázio.");
		}
		if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+$")) {
			throw new IllegalArgumentException("Nome digitado não é valido.");
		}
		this.nome = nome.trim();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco == null || endereco.trim().isBlank()) {
			throw new IllegalArgumentException("Campo endereço não pode ser vazio.");
		}
		if (!endereco.matches("^[A-Za-zÀ-ÖØ-öø-ÿ0-9,\\-\\s]+$")) {
			throw new IllegalArgumentException("Campo endereço foi digitado com caracteres inválidos.");
		}
		this.endereco = endereco.trim();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Campo telefone não pode ser vazio.");
		}

		if (!telefone.matches("^[0-9()+\\-\\s]+$")) {
			throw new IllegalArgumentException("Telefone inválido.");
		}

		this.telefone = telefone.trim();
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade <= 0) {
			throw new IllegalArgumentException("Idade só pode ser um inteiro positivo");
		}
		this.idade = idade;
	}

	@Override
	public String toString() {
		
		return  "Nome: " + this.nome 
				+"\nIdade: " + this.idade
				+"\nTelefone: " + this.telefone
				+"\nEnderço: "  + this.endereco + "\n";
	}
	
}
