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

    //funçao para mostrar os resultados em paginas
    // com index sendo o numeroa max de dados em cada pagina

    public void MostrarPorPagina(List<Pessoa> pessoa,int index){

        //opçoes para input
        Object op[] = {"Voltar", "Avançar"};
        //stringbuilder pra guardar os resultados de cada pagina
        StringBuilder resultado = new StringBuilder();
        // quantidade, valor do JOptionpane(0 voltar, 1 avançar, -1, licar no x), numero da pagina atual e total de pagina
        int quant = pessoa.size();
        int i;
        int pag = 0;
        int totPag = (quant-1)/index+1;


        while (true){
            // inicio vai ser a pagina atual multiplicado pelo numero de dados em cada pag, com index 3, no inicio sera 0, dps sera 3 etc...
            int inicio = pag*index;
            // o fim vai ser o valor minino do tamanho do vetor ( caso seja 2 ou 1) e do inico + index caso seja a proxima pagina
            int fim = Math.min(inicio+index, pessoa.size());
            for(int j = inicio; j < fim; j++){
                //adiciona no stringbuilder
                resultado.append(pessoa.get(j)).append("\n");
            }

            //pergunta
            i = JOptionPane.showOptionDialog(null, resultado.toString(), "Pagina "+ (pag+1)+"/"+totPag, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);

            // só volta se a pagina nao for a inicial, e remove os valores
            if(i == 0){
                if(pag > 0){
                    pag--;

                }
                else {
                    break;
                }

            }
            // só avanca se n for a pagina final;
            else if(i == 1){
                if(fim < quant) {
                    pag++;
                }
                else {
                    break;
                }
            }
            else{
                break;
            }
            //remove os valores pra inserir os novos da nova pagina
            resultado.delete(0, resultado.length());

        }
    }

}








