package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GerenciadorDePessoas {
	
	
	private List<Pessoa> agenda = new ArrayList<Pessoa>();
	 
	public void cadastraPessoa(Pessoa novaPessoa) {
		this.agenda.add(novaPessoa);
	}
	
	public void removerCadastro(int id) {
		Pessoa pessoaRemover = buscaPorID(id);
		if(pessoaRemover != null) {
			agenda.remove(pessoaRemover);
		}
		
	}
	
	public List<Pessoa> listaCadastros() {
		return Collections.unmodifiableList(this.agenda);
	}
	public boolean isVazia() {
		return agenda.isEmpty();
	}
	
	
	public List<Pessoa> pesquisaPorIdade(int idade) {

		List<Pessoa>pEncontradas = new ArrayList<Pessoa>();
		
		if (agenda.isEmpty()) {
			return Collections.emptyList();
		}
		for (Pessoa pessoa : agenda) {
			if (pessoa.getIdade() == idade) {
				pEncontradas.add(pessoa);
			}
		}
		return pEncontradas; 
	}
	
	// Ordenando o Arraylist com base na String nome
	public List<Pessoa> cadastrosEmOrdemAlfabetica() {
		
		Collections.sort(agenda);
		
		return  agenda;
	}
	
	public Pessoa buscaPorID(int id) {
		
		if(agenda.isEmpty()) {
			return null;
		}
		for (Pessoa p : agenda) {
			if (p.getId() == id) {
				return p;
			}
		}

		return null;
	}
	

	public List<Pessoa> getPagina(List<Pessoa> pessoas, int numeroPagina, int tamanhoPagina){
		int inicio = (numeroPagina - 1) * tamanhoPagina;
		int fim = Math.min(inicio + tamanhoPagina, pessoas.size());
		
		if(inicio >= pessoas.size() || inicio < 0) return Collections.emptyList();
		
		return pessoas.subList(inicio, fim);
	}
}







