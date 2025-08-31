package Dominio;


public class Pessoa {
	
	private String nome;
	private String endereco;
	private String telefone;
	private int idade;
	
	
	public Pessoa() {
		
	}

	// getters e setters
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
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
