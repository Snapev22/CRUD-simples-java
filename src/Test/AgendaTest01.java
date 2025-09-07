package Test;

import Dominio.Pessoa;

import java.util.List;

import javax.swing.JOptionPane;

import Dominio.GerenciadorDePessoas;

public class AgendaTest01 {

	public static void main(String[] args) {
		GerenciadorDePessoas cadastro = new GerenciadorDePessoas();
		
		while (true) {
			
			int opcao = -1;
		
			try {
				 opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
						"\n----------Menu de agenda------\n" +
						"1- Cadastro\n" + 
						"2- Pesquisa por idade\n"+
						"3- Ordenação alfabética\n" + 
						"4- Altera cadastro\n" + 
						"5- Remove cadastro\n"+
						"6- Sair do menu\n" + 
						"Escolha uma opção: "));

			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Erro: digite apenas números inteiros para opção.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
			if (opcao == 6) {
				break;
			}
			switch (opcao) {
			
			//Cadastro no Array Agenda
			case 1:

				try {
					String nome = JOptionPane.showInputDialog(null, "Digite o nome: ");

					int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade: "));

					String endereco = JOptionPane.showInputDialog(null, "Digite o endereço: ");

					String telefone = JOptionPane.showInputDialog(null, "Digite o telefone: ");

					Pessoa pessoa = new Pessoa(nome, endereco, telefone, idade);
					cadastro.cadastraPessoa(pessoa);
					break;

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: idade deve ser um número inteiro.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
					break;
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro de entrada", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				// Busca dentro do ArrayList agenda
			
			case 2:
				
			try {
				
				if (cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia" , "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}

				int idadePesquisa = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Digite a idade para pesquisa: "));

				List<Pessoa> encontrados = cadastro.pesquisaPorIdade(idadePesquisa);

				if (encontrados.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma pessoa encontrada com essa idade","Informação", JOptionPane.INFORMATION_MESSAGE);
					break;
				} else {
                    cadastro.mostrarPorPagina(encontrados, 3);
                    
				}
			}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: Idade só pode ser um número inteiro." , "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				}
				break;
			
				//exibir lista agenda.
			case 3:
				if(cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
                cadastro.mostrarPorPagina(cadastro.cadastrosEmOrdemAlfabetica(), 3);
				break;

			case 4:

				if (cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}

				try {

					int idBusca = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Digite o ID para realizar busca: "));
					Pessoa pessoaAlterar = cadastro.buscaPorID(idBusca);

					// Altera objeto selecionado da lista de pessoas.
					if (pessoaAlterar != null) {
						try {
							int confirmar = JOptionPane.showConfirmDialog(null,
									"Pessoa encontrada. Deseja alterar cadastro?\n\n" + pessoaAlterar.toString(),
									"Confirmarção de Alteração", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);

							if (confirmar == JOptionPane.YES_OPTION) {
								pessoaAlterar.setNome(JOptionPane.showInputDialog(null,
										"Pessoa encontrada: \n " + "Digite o nome: "));

								pessoaAlterar.setIdade(
										Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade: ")));

								pessoaAlterar.setEndereco(JOptionPane.showInputDialog(null, "Digite o endereço: "));

								pessoaAlterar.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone: "));
								JOptionPane.showMessageDialog(null, "Alteração bem sucedida.", "Sucesso",
										JOptionPane.INFORMATION_MESSAGE);
							break;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Erro: Idade deve ser um número inteiro.", "Erro de idade", 
									JOptionPane.ERROR_MESSAGE);
							break;
						} catch (IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro de validação", 
									JOptionPane.ERROR_MESSAGE);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Erro: Pessoa não encontrada com o ID" + idBusca + ".", "Erro", 
								JOptionPane.ERROR_MESSAGE);
					}
					break;

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: ID deve ser um número inteiro positivo", "Erro de ID", 
							JOptionPane.ERROR_MESSAGE);
				}
				break;
				// remover cadastro
			case 5:
				if(cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro:  agenda vazia", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
				try {
					int idExcluir = Integer.parseInt( JOptionPane.showInputDialog(null,"Digite o id que deseja excluir: "));
					cadastro.removerCadastro(idExcluir);
					break;
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: Id deve ser um numero inteiro positivo", "Erro de ID", JOptionPane.ERROR_MESSAGE);
					break;
				}
							
				default:
				JOptionPane.showMessageDialog(null, "Erro: Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
				break;

			}
		}
		JOptionPane.showMessageDialog(null, "Programa encerrado.", "Fim", JOptionPane.INFORMATION_MESSAGE);
	}

}
	
