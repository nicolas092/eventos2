package teste;

import java.util.List;
import java.util.Scanner;

import eventos.Evento;
import eventos.Local;
import pessoas.Participante;
import util.Situacao;

public class MetodoMain {
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcaoEscolhida;
		String menu = """
				1 – Cadastrar Evento
				2 – Pesquisar evento usando o nome
				3 – Pesquisar evento usando a instituição
				4 – Pesquisar evento usando a situacao
				5 – Sair""";
				
		System.out.println(menu);
		
		do {
			opcaoEscolhida = entrada.nextInt();
			switch (opcaoEscolhida) {
				case 1:
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
		} while (opcaoEscolhida != 5);
		
		entrada.close();
	}
	
	public Evento cadastrarEvento() {
		String nome = entrada.nextLine();
		double taxaInscricao = entrada.nextDouble();
		String data = entrada.next();
//		List<Participante> participantes = ;
//		Situacao situacao = ;
//		Local local = ;
//		Evento eventoCriado = new Evento(nome, taxaInscricao, participantes, situacao);
//		return eventoCriado;
	}
}







