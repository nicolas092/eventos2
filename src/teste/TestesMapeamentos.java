package teste;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import dao.EventoDAO;
import dao.LocalDAO;
import dao.ParticipanteDAO;
import eventos.Evento;
import eventos.Local;
import pessoas.Participante;
import util.Situacao;

public class TestesMapeamentos {
	public static void main(String[] args) {
		ParticipanteDAO participantedao = new ParticipanteDAO();
		Participante participante1 = new Participante("Nícolas Participante", "av. Liberdade", "51986559754",
				"04836108012");
		Participante participante2 = new Participante("Silvia Professora", "av. Liberdade", "51986559754",
				"04836108012");
		participantedao.cadastrar(participante1);
		participantedao.cadastrar(participante2);

		participante1.setNome("Nícolas com Nome Atualizado");
		participantedao.atualizar(participante1, participante1.getIdentificador());

		System.out.println("Pesquisa pelo id 1:\n" + participantedao.pesquisarPelaChavePrimaria(1L));
		System.out.println("Pesquisa pelo nome \"nícolas\":\n" + participantedao.pesquisarPeloNome("nícolas"));

		System.out.println("\nLista de todos os participantes cadastrados:");
		for (Participante p : participantedao.obterTodos()) {
			System.out.println(p);
		}

		participantedao.excluir(participante1.getIdentificador());

		participantedao.fecharEntityManager();
		participantedao.fecharEntityManagerFactory();
//		----------------------------------------------------------------------------------------------
//		PessoaDAO pessoadao = new PessoaDAO();
//		Pessoa pessoa1 = new Pessoa("Nícolas Pessoa");
//		Pessoa pessoa2 = new Pessoa("Nícolas Pessoa");
//		pessoadao.cadastrar(pessoa1);
//		pessoadao.cadastrar(pessoa2);
//
//		pessoa1.setNome("Nícolas Pessoa com nome alterado");
//		pessoadao.atualizar(pessoa1, pessoa1.getIdentificador());
//
//		System.out.println("Pesquisa pelo id 1:\n" + pessoadao.pesquisarPelaChavePrimaria(1L));
//		System.out.println("Pesquisa pelo nome \"alt\":\n" + pessoadao.pesquisarPeloNome("alt"));
//
//		System.out.println("\nLista de todas as pessoas cadastradas:");
//		for (Pessoa p : pessoadao.obterTodos()) {
//			System.out.println(p);
//		}
//
//		pessoadao.excluir(pessoa2.getIdentificador());
//
//		pessoadao.fecharEntityManager();
//		pessoadao.fecharEntityManagerFactory();
//		----------------------------------------------------------------------------------------------
//		ParticipanteDAO participantedao = new ParticipanteDAO();
//		Participante participante1 = new Participante("Nícolas Participante", "av. Liberdade", "51986559754",
//				"04836108012");
//		Participante participante2 = new Participante("Silvia Professora", "av. Liberdade", "51986559754",
//				"04836108012");
//		participantedao.cadastrar(participante1);
//		participantedao.cadastrar(participante2);
//		participantedao.fecharEntityManager();
//
//		LocalDAO localdao = new LocalDAO();
//		Local local = new Local("Sesi", "55051999996666", "Nícolas");
//		localdao.cadastrar(local);
//		localdao.fecharEntityManager();
//
//		List<Participante> participantes = Arrays.asList(participante1, participante2);
//
//		EventoDAO eventodao = new EventoDAO();
//		Evento evento1 = new Evento("Aniversário", 15.5, LocalDateTime.of(2021, 12, 19, 0, 0), Situacao.ANDAMENTO,
//				participantes, local);
//		Evento evento2 = new Evento("Casamento", 25, LocalDateTime.of(2021, 12, 1, 0, 0), Situacao.ENCERRADO,
//				participantes, local);
//		eventodao.cadastrar(evento1);
//		eventodao.cadastrar(evento2);
//
//		evento2.setNome("Divórcio");
//		eventodao.atualizar(evento2, evento2.getIdentificador());
//
//		System.out.println("Pesquisa pelo id 1:\n" + eventodao.pesquisarPelaChavePrimaria(1L));
//		System.out.println("Pesquisa pelo nome \"divórcio\":\n" + eventodao.pesquisarPeloNome("divórcio"));
//
//		System.out.println("\nLista de todos os eventos cadastrados:");
//		for (Evento e : eventodao.obterTodos()) {
//			System.out.println(e);
//		}
//
//		eventodao.excluir(evento2.getIdentificador());
//
//		eventodao.fecharEntityManager();
//		eventodao.fecharEntityManagerFactory();
//		----------------------------------------------------------------------------------------------
//		LocalDAO localdao = new LocalDAO();
//		Local local1 = new Local("Sesi", "55051999996666", "Nícolas");
//		Local local2 = new Local("Sesc", "55051999996666", "Silvia");
//		localdao.cadastrar(local1);
//		localdao.cadastrar(local2);
//
//		local2.setOrganizador("Robert");
//		localdao.atualizar(local2, local2.getIdentificador());
//
//		System.out.println("Pesquisa pelo id 2:\n" + localdao.pesquisarPelaChavePrimaria(2L));
//		System.out.println("Pesquisa pelo nome \"sesi\":\n" + localdao.pesquisarPeloNome("sesi"));
//
//		System.out.println("\nLista de todas os eventos cadastrados:");
//		for (Local l : localdao.obterTodos()) {
//			System.out.println(l);
//		}
//
//		localdao.excluir(local2.getIdentificador());
//		
//		localdao.fecharEntityManager();
//
//		local.fecharEntityManagerFactory();
//		localdao.fecharEntityManagerFactory();

	}
}
