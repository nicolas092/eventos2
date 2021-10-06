package menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import eventos.Evento;
import eventos.Local;
import pessoas.Participante;
import util.Situacao;

public class Menu {
	static List<Evento> eventos = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while(true) {
			switch (montaMenu()) {
				case 1:
					cadastrarEvento();
					break;
				case 2:
					pesquisarEventoPeloNome();
					break;
				case 3:
					pesquisarEventoPelaInstituicao();
					break;
				case 4:
					pesquisarEventoPelaSituacao();
					break;
				case 5:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
		
	}
	
	
	
	
	public static void cadastrarEvento() {
		
		
		
		String nome = JOptionPane.showInputDialog("Insira o nome do evento:");
		double taxaInscricao = Double.parseDouble(JOptionPane.showInputDialog("Valor da taxa de inscrição:"));
		String data = JOptionPane.showInputDialog("Insira a data do evento (formato xx/xx/xxxx): ");
		
		
		
//		CADASTRO DE PARTICIPANTES DO EVENTO------------------------------------------------------
		List<Participante> participantes = new ArrayList<>();
		int quantParticipantes = Integer.parseInt(JOptionPane.showInputDialog("CADASTRO DE PARTICIPANTE(S) DO EVENTO\nQuantidade de participantes a serem cadastrados para o evento:"));
		for(int i = 0; i < quantParticipantes; i++) {
			String nomeParticipante = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nNome:", i + 1));
			String endereco = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nEndereço:", i + 1));
			String telefone = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nTelefone:", i + 1));
			String cpf = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nCPF:", i + 1));
			String email = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nE-mail:", i + 1));
			participantes.add(new Participante(nomeParticipante, endereco, telefone, cpf, email));
		}
//		-------------------------------------------------------------------------------------------
		
		
//		CADASTRO DA SITUACAO DO EVENTO-------------------------------------------------------------
		Situacao situacao = null;
		while(situacao == null) {
			switch(montaMenuDeSituacao()) {
			case 1:
				situacao = Situacao.ANDAMENTO;
				break;
			case 2:
				situacao = Situacao.CANCELADO;
				break;
			case 3:
				situacao = Situacao.ENCERRADO;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
//		--------------------------------------------------------------------------------------------
		
		
//		CADASTRO DE LOCAL DO EVENTO-------------------------------------------------------------
		String instituicao = JOptionPane.showInputDialog("CADASTRO DE LOCAL DO EVENTO\nNome da instituição onde será realizado o evento:");
		String telefone = JOptionPane.showInputDialog("Telefone do local:");
		String organizador = JOptionPane.showInputDialog("Organizador do evento:");
		Local local = new Local(instituicao, telefone, organizador);
//		--------------------------------------------------------------------------------------------
		

		
		Evento eventoCriado = new Evento(nome, taxaInscricao, data, situacao, participantes, local);
		eventos.add(eventoCriado);
		
	}

	
	
	public static void pesquisarEventoPeloNome() {
		String nomeProcurado = JOptionPane.showInputDialog("Nome a ser buscado:");
		String resultadoDaBusca = "";
		for(Evento evento : eventos) {
			if(evento.getNome().equalsIgnoreCase(nomeProcurado)) resultadoDaBusca += evento.toString() + "\n";
		}
		resultadoDaBusca = resultadoDaBusca.equals("") ? "Não foi localizado nenhum evento com esse nome" : resultadoDaBusca;
		JOptionPane.showMessageDialog(null, resultadoDaBusca);
	}
	
	
		
	public static void pesquisarEventoPelaInstituicao() {
		String instituicaoProcurada = JOptionPane.showInputDialog("Insituição a ser buscada:");
		String resultadoDaBusca = "";
		for(Evento evento : eventos) {
			if(evento.getLocal().getInstituicao().equalsIgnoreCase(instituicaoProcurada)) resultadoDaBusca += evento.toString() + "\n";
		}
		resultadoDaBusca = resultadoDaBusca.equals("") ? "Não foi localizado nenhum evento com esse nome de instituição." : resultadoDaBusca;
		JOptionPane.showMessageDialog(null, resultadoDaBusca);
	}

	
	
	public static void pesquisarEventoPelaSituacao() {
		String menuDeSituacoes = "Situação a ser buscada (digite apenas o número):\n";
		
		for(Situacao situacao : Situacao.values()) {
			menuDeSituacoes += situacao.getDescricao() + "\n";
		}
		
		int situacaoProcurada = Integer.parseInt(JOptionPane.showInputDialog(menuDeSituacoes));
		
		Situacao situacao = null;
		while(situacao == null) {
			switch(situacaoProcurada) {
				case 1:
					situacao = Situacao.ANDAMENTO;
					break;
				case 2:
					situacao = Situacao.CANCELADO;
					break;
				case 3:
					situacao = Situacao.ENCERRADO;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
		
		String resultadoDaBusca = "";
		for(Evento evento : eventos) {
			if(evento.getSituacao() == situacao) {
				resultadoDaBusca += evento.toString() + "\n";
			}
		}
		resultadoDaBusca = resultadoDaBusca.equals("") ? "Não foi localizado nenhum evento na situação requerida." : resultadoDaBusca;
		JOptionPane.showMessageDialog(null, resultadoDaBusca);
	}

	
	
	public static int montaMenu() {
		String menu = "Escolha uma das seguintes opções (digite apenas o número):\n";
		for (OpcoesMenu opcao : OpcoesMenu.values()) {
			menu += opcao.getDescricao() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu)); 
	}
	
	
	
	public static int montaMenuDeSituacao() {
		String menu = "Situação do evento (digite apenas o número):\n";
		for(Situacao situacao : Situacao.values()) {
			menu += situacao.getDescricao() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
}














































/*
 * public static void pesquisarEventoPeloNome(String nomeProcurado) { boolean
 * achouAlgumEvento = false; for (Evento evento : eventos) {
 * if(nomeProcurado.equalsIgnoreCase(evento.getNome())) {
 * System.out.println(evento.toString()); achouAlgumEvento = true; } }
 * if(!achouAlgumEvento)
 * System.out.printf("Não foi encontrado nenhum evento com o nome \"%s\"\n",
 * nomeProcurado); }
 * 
 * public static void pesquisarEventoPelaInstituicao(String
 * instituicaoProcurada) { boolean achouAlgumEvento = false; for (Evento evento
 * : eventos) {
 * if(evento.getLocal().getInstituicao().equalsIgnoreCase(instituicaoProcurada))
 * { System.out.println(evento.toString()); achouAlgumEvento = true; } }
 * if(!achouAlgumEvento) System.out.
 * printf("Não foi encontrado nenhuma instituição com o nome \"%s\"\n",
 * instituicaoProcurada); }
 * 
 * public static void pesquisarEventoPelaSituacao(int situacaoProcurada) {
 * boolean achouAlgumEvento = false; for(Evento evento : eventos) {
 * if(evento.getSituacao().getValor() == situacaoProcurada) {
 * System.out.println(evento.toString()); achouAlgumEvento = true; } }
 * if(!achouAlgumEvento)
 * System.out.println("Não foi localizado nenhum evento nessa situação\n");
 * 
 * }
 */






