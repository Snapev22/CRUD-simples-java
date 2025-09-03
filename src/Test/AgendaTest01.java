package Test;

import Dominio.Pessoa;

import java.util.List;

import javax.swing.JOptionPane;

import Dominio.GerenciadorDePessoas;

public class AgendaTest01 {

	public static void main(String[] args) {
		GerenciadorDePessoas cadastro = new GerenciadorDePessoas();

		while (true) {
			
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"\n----------Menu de agenda------\n" +
					"1- Cadastro\n" + 
					"2- Pesquisa por idade\n"+
					"3- Ordenação alfabética\n" + 
					"4- Altera cadastro\n" + 
					"5- Sair do menu\n "+
					"Escolha uma opção: "));

			if (opcao == 5) {
				break;
			}
			switch (opcao) {
			
			case 1:

				Pessoa pessoa = new Pessoa();

				pessoa.setNome(JOptionPane.showInputDialog(null,"Digite o nome: "));	
				
				pessoa.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null,
						"Digite a idade: ")));	
				
				pessoa.setEndereco(JOptionPane.showInputDialog(null,"Digite o endereço: "));
				
				pessoa.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone: "));
				
				// chamada do metodo de cadastro
				cadastro.cadastraPessoa(pessoa);
				break;
			
			case 2:
				// Busca dentro do ArrayList agenda
				if(cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia");
					break;
				}
				
				int idade = Integer.parseInt(JOptionPane.showInputDialog
						(null,"Digite a idade para pesquisa: "));
				
				List<Pessoa> encontrados = cadastro.pesquisaPorIDde(idade);
				
				if(encontrados.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma pessoa encontrada com essa idade");
					break;
				}else {

                    cadastro.MostrarPorPagina(encontrados, 3);

					//StringBuilder resultado = new StringBuilder();
					//for(Pessoa p : encontrados) {
					//	resultado.append(p).append("\n");
					//}
					//JOptionPane.showMessageDialog(null, resultado.toString());
				}
				break;
			
			case 3:
				
				cadastro.cadastrosEmOrdemAlfabetica();
				break;
			
			case 4:
				if(cadastro.isVazia()) {
					JOptionPane.showMessageDialog(null, "Erro: agenda vazia");
					break;
				}
				
				String nomeBusca =  JOptionPane.showInputDialog
					(null,"Digite o nome para realizar busca");
			
				// recebe objeto Pessoa da lista de cadastro.
				Pessoa pessoaAlterar = cadastro.buscaPorNome(nomeBusca);
				
				// Altera objeto selecionado da lista de pessoas.
				if (pessoaAlterar != null) {
					
					pessoaAlterar.setNome(JOptionPane.showInputDialog
							(null, "Pessoa encontrada: \n "+ "Digite o nome: "));
					
					pessoaAlterar.setIdade(Integer.parseInt(JOptionPane.showInputDialog
							(null,"Digite a idade: ")));
					

					pessoaAlterar.setEndereco(JOptionPane.showInputDialog
							(null, "Digite o endereço: "));

					pessoaAlterar.setTelefone(JOptionPane.showInputDialog
							(null, "Digite o telefone: "));
					JOptionPane.showMessageDialog(null, "Alteração bem sucedida.");
				} else {
					JOptionPane.showMessageDialog(null, "Erro: Pessoa não encontrada.");
				}
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Erro: Opção inválida.");
				System.exit(0);
				break;

			}
		}
		JOptionPane.showMessageDialog(null, "Programa encerrado.");
	}

}
	
	
