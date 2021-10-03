package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import eventos.Evento;
import eventos.Local;
import pessoas.Participante;
import util.Situacao;

public class Menu {
	static Scanner entrada = new Scanner(System.in);
	static List<Evento> eventos = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcaoEscolhida;
		
		String menuDeOpcoes = """
				----MENU DE OPÇÕES----
				1 – Cadastrar Evento
				2 – Pesquisar evento usando o nome
				3 – Pesquisar evento usando a instituição
				4 – Pesquisar evento usando a situacao
				5 – Sair
				""";
		System.out.println(menuDeOpcoes);
		
		do {
			
			System.out.print("Selecione uma opção do menu: ");
			opcaoEscolhida = entrada.nextInt();
			
			switch (opcaoEscolhida) {
				case 1:
					cadastrarEvento();
					break;
				case 2:
//					pesquisarEventoPeloNome();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Opção inválida");
			}
		} while (opcaoEscolhida != 5);
		
		for (Evento evento : eventos) {
			System.out.println(evento.toString());
		}
		
		entrada.close();
	}
	
	public static void cadastrarEvento() {
		System.out.print("Insira o nome do evento: ");
		entrada.nextLine();
		String nome = entrada.nextLine();
		System.out.print("Valor da taxa de inscrição: ");
		double taxaInscricao = entrada.nextDouble();
		System.out.print("Insira a data do evento (formato xx/xx/xxxx): ");
		String data = entrada.next();
		List<Participante> participantes = new ArrayList<>();
		
		String enumSituacoesDeEvento = """
				----SITUAÇÕES DE EVENTO----
				1 – Andamento
				2 – Cancelado
				3 – Encerrado
				""";
		System.out.println(enumSituacoesDeEvento);
		System.out.print("Qual a situação do evento (insira o número): ");
		entrada.nextLine();
		int numeroDaSituacao = entrada.nextInt();
		Situacao situacao = null;
		switch (numeroDaSituacao) {
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
		}

		
		System.out.println("---CADASTRO DO LOCAL DO EVENTO--");
		System.out.print("Nome da instituição onde será realizado o evento: ");
		entrada.nextLine();
		String instituicao = entrada.nextLine();
		System.out.print("Telefone do local: ");
		String telefone = entrada.nextLine();
		System.out.print("Organizador do evento: ");
		String organizador = entrada.nextLine();
		Local local = new Local(instituicao, telefone, organizador);
		
		Evento eventoCriado = new Evento(nome, taxaInscricao, data, participantes, situacao, local);
		eventos.add(eventoCriado);
	}
	
	/*
	 * public static void pesquisarEventoPeloNome() { String nomeProcurado =
	 * entrada.nextLine(); boolean nomeDeEventoEncontrado = false;
	 * 
	 * for (Evento evento : eventos){ if(evento.getNome().equals(nomeProcurado)) {
	 * System.out.println(evento.toString()); nomeDeEventoEncontrado = true; } }
	 * if(!nomeDeEventoEncontrado) System.out.printf("Evento %s não encontrado",
	 * nomeProcurado); }
	 * 
	 * public static void pesquisarEventoPeloNome() { String nomeProcurado =
	 * entrada.nextLine(); boolean nomeDeEventoEncontrado = false;
	 * 
	 * for (Evento evento : eventos){ if(evento.getNome().equals(nomeProcurado)) {
	 * System.out.println(evento.toString()); nomeDeEventoEncontrado = true; } }
	 * if(!nomeDeEventoEncontrado) System.out.printf("Evento %s não encontrado",
	 * nomeProcurado); }
	 */
	
}







