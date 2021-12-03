package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import eventos.Evento;
import eventos.Local;
import pessoas.Participante;
import util.Situacao;

public class Menu2 implements OperacoesConjunto<Evento>{

	static TreeSet<Evento> eventos = new TreeSet<Evento>();

	public static void main(String[] args) {

		PersistenciaDeDados.lerEventos();
		Menu2 opConjunto = new Menu2();
		while(true) {
			switch (opConjunto.montaMenu()) {
			case 1:
				opConjunto.cadastrarEvento();
				break;
			case 2:
				opConjunto.listarTodosEventos();
				break;
			case 3:
				opConjunto.listarTodosEventosProcurandoPeloNomeDoParticipante();
				break;
			case 4:
				opConjunto.removerEventoPeloNome();
				break;
			case 5:
				PersistenciaDeDados.salvarEventos();
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}

	}


	private void cadastrarEvento() {
		String nome = JOptionPane.showInputDialog("Insira o nome do evento:");
		double taxaInscricao = Double.parseDouble(JOptionPane.showInputDialog("Valor da taxa de inscrição:"));
		String data = JOptionPane.showInputDialog("Insira a data do evento (formato xx/xx/xxxx): ");
		String[] arrayData = data.split("/");
		String horarioDeInicio = JOptionPane.showInputDialog("Insira o horário de início do evento (formato HH:MM):");
		String[] arrayHorario = horarioDeInicio.split("/");
		LocalDateTime dataEHorario = LocalDateTime.of(Integer.parseInt(arrayData[2]), Integer.parseInt(arrayData[1]),
				Integer.parseInt(arrayData[0]), Integer.parseInt(arrayHorario[0]), Integer.parseInt(arrayHorario[1]));


		//		CADASTRO DE PARTICIPANTES DO EVENTO------------------------------------------------------
		List<Participante> participantes = new ArrayList<>();
		int quantParticipantes = Integer.parseInt(JOptionPane.showInputDialog("CADASTRO DE PARTICIPANTE(S) DO EVENTO\nQuantidade de participantes a serem cadastrados para o evento:"));
		for(int i = 0; i < quantParticipantes; i++) {
			String nomeParticipante = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nNome:", i + 1));
			String endereco = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nEndereço:", i + 1));
			String telefone = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nTelefone:", i + 1));
			String cpf = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nCPF:", i + 1));
			ArrayList<String> emailsDoParticipante = new ArrayList<String>();
			
			int quantEmailsParticipante = Integer.parseInt(JOptionPane.showInputDialog("Insira quantos e-mails serão informados para o participante %d:", i + 1));
			for (int j = 0; j < quantEmailsParticipante; j++) {
				String email = JOptionPane.showInputDialog(String.format("PARTICIPANTE %d\nE-mail %d:", i + 1, j + 1));
				emailsDoParticipante.add(email);
			}
			
//			participantes.add(new Participante(nomeParticipante, endereco, telefone, cpf, emailsDoParticipante));
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



		Evento eventoCriado = new Evento(nome, taxaInscricao, dataEHorario, situacao, participantes, local);
		Menu2.eventos.add(eventoCriado);

	}


	private int montaMenu() {
		String menu = "Escolha uma das seguintes opções (digite apenas o número):\n";
		for (OpcoesMenu2 opcao : OpcoesMenu2.values()) {
			menu += opcao.getDescricao() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}


	public void removerEventoPeloNome() {
		String nomeDoEvento = JOptionPane.showInputDialog("Insira o nome do evento a ser removido:");
		String resultado = "Nenhum evento possui o nome fornecido";
		for(Evento evento : Menu2.eventos) {
			if(evento.getNome().equalsIgnoreCase(nomeDoEvento)) {
				Menu2.eventos.remove(evento);
				resultado = "Evento removido";
				break;
			}
		}
		JOptionPane.showMessageDialog(null, resultado);
	}



	public void listarTodosEventosProcurandoPeloNomeDoParticipante() {
		String resultado = "";
		String nomeProcurado = JOptionPane.showInputDialog("Insira o nome do participante procurado:");
		for (Evento evento : Menu2.eventos) {
			if(evento != null) {
				for (Participante participante : evento.getParticipantes()) {
					if(participante != null && participante.getNome().equalsIgnoreCase(nomeProcurado)) {
						resultado += evento;
						break;	// esse break serve pra nao repetir o mesmo evento caso o evento tenha mais de um participante
						// com o nome procurado
					}
				}
			}
		}
		if (resultado.equals("")) resultado += "Nenhum evento possui o participante procurado";
		JOptionPane.showMessageDialog(null, resultado);
	}



	public void listarTodosEventos() {
		String resultado = "";
		for (Evento evento : Menu2.eventos) {
			resultado += evento;
		}
		if (resultado.equals("")) resultado += "Nenhum evento cadastrado";
		JOptionPane.showMessageDialog(null, resultado);
	}



	public static int montaMenuDeSituacao() {
		String menu = "Situação do evento (digite apenas o número):\n";
		for(Situacao situacao : Situacao.values()) {
			menu += situacao.getDescricao() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
