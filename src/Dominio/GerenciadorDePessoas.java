package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorDePessoas {
	
	
	private List<Pessoa> agenda = new ArrayList<Pessoa>();
	 
	
	public void cadastraPessoa(Pessoa novaPessoa) {
		this.agenda.add(novaPessoa);
		JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso.");
	}
	
	public boolean isVazia() {
		return agenda.isEmpty();
	}
	
	// método de busca dentro do array recebe idade como parâmetro de busca.
	public List<Pessoa> pesquisaPorIdade(int idade) {

		List<Pessoa>pEncontradas = new ArrayList<Pessoa>();
		
		if (agenda.isEmpty()) {
			return null;
		}
		for (Pessoa pessoa : agenda) {
			if (pessoa.getIdade() == idade) {
				pEncontradas.add(pessoa);
			}
		}
		return pEncontradas; 
	}
	
	// Ordenando o array com parametro String nome
	public StringBuilder cadastrosEmOrdemAlfabetica() {
		
		Collections.sort(agenda);
		
		StringBuilder resultado = new StringBuilder("---Lista de pessoas ordenadas----\n");
		for(Pessoa pessoa: agenda) {
			resultado.append(pessoa).append("\n");
		}	
		return  resultado;
	}
	
	//metodo de busca de pessoas na agenda com base na comparação da  String nome 
	public Pessoa buscaPorNome(String nome) {
		
		if(agenda.isEmpty()) {
			return null;
		}
		for (Pessoa p : agenda) {
			if (p.getNome().trim().equalsIgnoreCase(nome.trim())) {
				return p;
			}
		}

		return null;
	}
}








