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
						"5- Sair do menu\n "+
						"Escolha uma opção: "));

			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Erro: digite apenas números inteiros para opção.");
				continue;
			}
			
			if (opcao == 5) {
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
					JOptionPane.showMessageDialog(null, "Erro: idade deve ser um número inteiro.");
					break;
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
					break;
				}
				
				// Busca dentro do ArrayList agenda
			
			case 2:
				
			try {
				
			 
				if (cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia");
					break;
				}

				int idadePesquisa = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Digite a idade para pesquisa: "));

				List<Pessoa> encontrados = cadastro.pesquisaPorIdade(idadePesquisa);

				if (encontrados.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma pessoa encontrada com essa idade");
					break;
				} else {
                    cadastro.mostrarPorPagina(encontrados, 3);
                    
				}
			}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: Idade só pode ser um número inteiro.");
				}
				break;
			
				//exibir lista agenda.
			case 3:
				if(cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia");
					break;
				}
                cadastro.mostrarPorPagina(cadastro.cadastrosEmOrdemAlfabetica(), 3);
				break;

			case 4:

				if (cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia");
					break;
				}

				try {
					
					String nomeBusca = JOptionPane.showInputDialog(null, "Digite o nome para realizar busca");

					// recebe objeto Pessoa da lista de cadastro.
					Pessoa pessoaAlterar = cadastro.buscaPorNome(nomeBusca);

					// Altera objeto selecionado da lista de pessoas.
					if (pessoaAlterar != null) {

						pessoaAlterar.setNome(
								JOptionPane.showInputDialog(null, "Pessoa encontrada: \n " + "Digite o nome: "));

						pessoaAlterar.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade: ")));

						pessoaAlterar.setEndereco(JOptionPane.showInputDialog(null, "Digite o endereço: "));

						pessoaAlterar.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone: "));
						JOptionPane.showMessageDialog(null, "Alteração bem sucedida.");
					} else {
						JOptionPane.showMessageDialog(null, "Erro: Pessoa não encontrada.");
					}
					break;
				
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro: Idade deve ser um número inteiro.");
					break;
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
					break;
				}
			default:
				JOptionPane.showMessageDialog(null, "Erro: Opção inválida.");
				break;

			}
		}
		JOptionPane.showMessageDialog(null, "Programa encerrado.");
	}

}
	
