package Dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorDePessoas {
	
	
	 ArrayList<Pessoa> agenda = new ArrayList<Pessoa>();
	
	public void cadastraPessoa(Pessoa novaPessoa) {
		this.agenda.add(novaPessoa);
		JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso.");
	}
	
	public boolean isVazia() {
		return agenda.isEmpty();
	}
	
	// método de busca dentro do array recebe idade como parâmetro de busca.
	public List<Pessoa> pesquisaPorIDde(int idade) {

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
	
	// Usa bubble sort pra ordernar objetos alfabeticamente
	public void cadastrosEmOrdemAlfabetica() {
		
		if(isVazia()) {
			JOptionPane.showMessageDialog(null, "Erro: agenda vazia");
			return;
		}
		
		
		for(int i = 0;i < agenda.size() - 1;i++) {
			for(int j = 0;j < agenda.size()-1 - i;j++) {
				Pessoa pessoaAtual = agenda.get(j);
				Pessoa proximo = agenda.get(j + 1);
				
				if(pessoaAtual.getNome().compareTo(proximo.getNome()) > 0) {
					agenda.set(j, proximo);
					agenda.set(j + 1 , pessoaAtual);
				}
			}
		}
		StringBuilder resultado = new StringBuilder("---Lista de pessoas ordenadas----\n");
		for(Pessoa pessoa: agenda) {
			resultado.append(pessoa).append("\n");
		}	
		JOptionPane.showMessageDialog(null, resultado.toString());
	}

	/*metodo de busca de pessoas na agenda com base na comparação da  String nome, 
	 * retorna um objeto de pessoa se encontrar senão retorna null;
	 */
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








