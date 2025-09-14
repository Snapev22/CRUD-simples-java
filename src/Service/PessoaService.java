package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Exceptions.RegraDeNegocioExecpetion;
import entities.Pessoa;


public class PessoaService {
	
	/**
	 * A classe({@code PessoaService} fornece os serviços relacionados a manipulação de cadastros na agenda.
	 * Ela permite criar cadastro, listar, ordernar alfabeticamente, listar com filto de idade, e remoção de cadastro.
	 * <p> 
	 */
	
	private List<Pessoa> agenda = new ArrayList<Pessoa>();
	
	/**
	 * Construtor padrão da classe PessoaService.
	 * Inicializa a lista de cadastro de pessoas.
	 */
	public PessoaService() {
		this.agenda = new ArrayList<Pessoa>();
	}
	
	/**
	 * Cria um novo cadastro com base nas informações definidas na classe Pessoa.
	 * 
	 * @param novaPessoa o objeto pessoa criado na classe principal
	 */
	public void cadastraPessoa(Pessoa novaPessoa) {
		this.agenda.add(novaPessoa);
	}
	
	public void removerCadastro(int id) {
		Pessoa pessoaRemover = buscaPorID(id);
		if(pessoaRemover != null) {
			agenda.remove(pessoaRemover);
		}
		
	}
	
	/**
	 * Lista todas as pessoas cadastradas.
	 *<p>
	 * Este método retorna uma lista imutável.Não podendo ser modificada (adicionar ou remover elementos)
	 * 
	 * @return uma lista não modificável de todas as pessoas da agenda. 
	 */
	public List<Pessoa> listaCadastros() {
		return Collections.unmodifiableList(this.agenda);
	}
	public boolean isVazia() {
		return agenda.isEmpty();
	}
	
	/**
	 * Lista todas as pessoas cadastradas filtrando pelo atributo idade
	 * 
	 * @param idade A idade usada como filtro para a busca.
	 * @return uma lista de pessoas que correspondem a idade fornecida.
	 * retorna uma lista vazia caso a agenda esteja vazia ou não encontre correspondências.
	 */
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
	
	/**
	 * Lista todas as pessoas cadastradas, ordenadas alfabeticamente pelo atributo nome.
	 * <p>
	 * Retorna uma cópia ordenada, não alterando a ordem da lista interna agenda.
	 * A lista retornada é imutável.
	 * 
	 * @return uma lista não modificavel de pessoas, ordenada por nome.
	 */
	public List<Pessoa> cadastrosEmOrdemAlfabetica() {
		List<Pessoa> agendaOrdenada = new ArrayList<Pessoa>(this.agenda);
		
		Collections.sort(agendaOrdenada);
		
		return  Collections.unmodifiableList(agendaOrdenada);
	}
	
	/**
	 * Retorna  um cadastro com base no ID da conta fornecido.
	 * 
	 * @param id o ID do cadastro a ser pesquisado
	 * @return o cadastro correspondente ao ID fornecido.
	 */
	public Pessoa buscaPorID(int id) {
		
		if(agenda.isEmpty()) {
			return null;
		}
		for (Pessoa p : agenda) {
			if (p.getId() == id) {
				return p;
			}
		}
		throw new RegraDeNegocioExecpetion("Erro: Pessoa não encontrada com o ID" + id);
		
	}
	
	/**
	 * Retorna uma sublista (página) de pessoas a partir de uma lista completa.
	 * * @param pessoas  A lista completa de pessoas a ser paginada.
	 * @param numeroPagina   O número da página que se deseja obter (começando de 1).
	 * @param tamanhoPagina  O número máximo de pessoas por página.
	 * @return  Uma lista imutável contendo as pessoas da página solicitada. 
	 * Retorna uma lista vazia caso o número da página seja inválido ou 
	 * a lista de entrada esteja vazia.
	 */
	public List<Pessoa> getPagina(List<Pessoa> pessoas, int numeroPagina, int tamanhoPagina){
		int inicio = (numeroPagina - 1) * tamanhoPagina;
		int fim = Math.min(inicio + tamanhoPagina, pessoas.size());
		
		if(inicio >= pessoas.size() || inicio < 0) return Collections.emptyList();
		
		return pessoas.subList(inicio, fim);
	}
}
