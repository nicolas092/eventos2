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
	static final String situacoesDeEvento = """
			\n----SITUAÇÕES DE EVENTO----
			1 – Andamento
			2 – Cancelado
			3 – Encerrado""";
	
	public static void main(String[] args) {
		int opcaoEscolhida;
		
		String menuDeOpcoes = """
				----MENU DE OPÇÕES----
				1 – Cadastrar Evento
				2 – Pesquisar evento usando o nome
				3 – Pesquisar evento usando a instituição
				4 – Pesquisar evento usando a situacao
				5 – Sair""";
		System.out.println(menuDeOpcoes);
		
		do {
			
			System.out.print("\nSelecione uma opção do menu de opções: ");
			opcaoEscolhida = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcaoEscolhida) {
				case 1:
					cadastrarEvento();
					break;
				case 2:
					System.out.print("Digite o nome do evento a ser buscado: ");
					pesquisarEventoPeloNome(entrada.nextLine());
					break;
				case 3:
					System.out.print("Digite o nome da instituição/local do evento a ser buscado: ");
					pesquisarEventoPelaInstituicao(entrada.nextLine());
					break;
				case 4:
					System.out.println(situacoesDeEvento);
					System.out.print("Digite a situação (número) de evento a ser buscada: ");
					pesquisarEventoPelaSituacao(entrada.nextInt());
					break;
				case 5:
					System.out.println("\n----FIM----");
					break;
				default:
					System.out.println("Opção inválida");
			}
		} while (opcaoEscolhida != 5);
		
		entrada.close();
	}
	
	public static void cadastrarEvento() {
		System.out.println("\n----CADASTRO DE EVENTO----");
		System.out.print("Insira o nome do evento: ");
		String nome = entrada.nextLine();
		System.out.print("Valor da taxa de inscrição: ");
		double taxaInscricao = entrada.nextDouble();
		System.out.print("Insira a data do evento (formato xx/xx/xxxx): ");
		String data = entrada.next();
		List<Participante> participantes = new ArrayList<>();
		
		System.out.println(situacoesDeEvento);
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

		
		System.out.println("\n---CADASTRO DO LOCAL DO EVENTO--");
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
	
	public static void pesquisarEventoPeloNome(String nomeProcurado) {
		for (Evento evento : eventos) {
			if(nomeProcurado.equalsIgnoreCase(evento.getNome())) System.out.println(evento.toString());
			return;
		}
		System.out.printf("Não foi encontrado nenhum evento com o nome \"%s\"");
	}
	
	public static void pesquisarEventoPelaInstituicao(String instituicaoProcurada) {
		for (Evento evento : eventos) {
			if(evento.getLocal().getInstituicao().equalsIgnoreCase(instituicaoProcurada)) System.out.println(evento.toString());
			return;
		}
		System.out.printf("Não foi encontrado nenhuma instituição com o nome \"%s\"");
	}
	
	public static void pesquisarEventoPelaSituacao(int situacaoProcurada) {
		boolean achouAlgumEvento = false;
		for(Evento evento : eventos) {
			if(evento.getSituacao().getValor() == situacaoProcurada) {
				System.out.println(evento.toString());
				achouAlgumEvento = true;
			}
		}
		if(!achouAlgumEvento) System.out.println("Não foi localizado nenhum evento nessa situação");
		
	}
	
}







