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
	
	// Ordenando o Arraylist com base na String nome
	public List<Pessoa> cadastrosEmOrdemAlfabetica() {
		
		Collections.sort(agenda);
		
		return  agenda;
	}
	
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
	
    //funçao para mostrar os resultados em paginas
    // com index sendo o numeroa max de dados em cada pagina
    public void mostrarPorPagina(List<Pessoa> pessoa,int pessoasPorPagina){

        String opcoes[] = {"Voltar", "Avançar"};
        int totalPessoas = pessoa.size();
        int opcaoSelecionada; 
        int paginaAtual = 0;
        int totPaginas = (int) Math.ceil((double) totalPessoas / pessoasPorPagina);

        while (true){
        	
            int inicio = paginaAtual * pessoasPorPagina;
            // fim deve ser o menor entre o limite da página e o tamanho da lista
            int fim = Math.min(inicio + pessoasPorPagina, pessoa.size());
           
            StringBuilder resultado = new StringBuilder();
            for(int j = inicio; j < fim; j++){
                resultado.append(pessoa.get(j)).append("\n");
            }

            //0 voltar, 1 avançar, -1, clicar no x
            opcaoSelecionada = JOptionPane.showOptionDialog(null, 
            		resultado.toString(), 
            		"Pagina "+ (paginaAtual+1) + "/" + totPaginas, 
            		JOptionPane.DEFAULT_OPTION, 
            		JOptionPane.INFORMATION_MESSAGE, null, 
            		opcoes,
            		opcoes[0]);

			// só volta se a pagina nao for a inicial, e remove os valores
			if (opcaoSelecionada == 0 && paginaAtual > 0) {
				paginaAtual--;
			} else if (opcaoSelecionada == 1 && fim < totalPessoas) {
				paginaAtual++;
			} else {
				break; // saiu da primeira pagina ou ultima pagina, ou clickou no X
			}

		}
	}

}







