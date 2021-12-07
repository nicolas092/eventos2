package teste;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import dao.EventoDAO;
import dao.LocalDAO;
import dao.ParticipanteDAO;
import dao.PessoaDAO;
import eventos.Evento;
import eventos.Local;
import pessoas.Participante;
import pessoas.Pessoa;
import util.Situacao;

public class TestesMapeamentos {
	public static void main(String[] args) {
//		PESSOADAO
		PessoaDAO pessoadao = new PessoaDAO();
		Pessoa pessoa1 = new Pessoa("Nícolas Pessoa");
		Pessoa pessoa2 = new Pessoa("Nícolas Pessoa");
		pessoadao.cadastrar(pessoa1).cadastrar(pessoa2);

		pessoa1.setNome("Nícolas Pessoa com nome alterado");
		pessoadao.atualizar(pessoa1, pessoa1.getIdentificador());

		System.out.println("Pesquisa pelo id 1:\n" + pessoadao.pesquisarPelaChavePrimaria(1L));
		System.out.println("Pesquisa pelo nome \"alt\":\n" + pessoadao.pesquisarPeloNome("alt"));

		System.out.println("Lista de todas as pessoas cadastradas:");
		pessoadao.obterTodos().forEach(System.out::println);

		pessoadao.excluir(pessoa2.getIdentificador());

		pessoadao.fecharEntityManager();
//		----------------------------------------------------------------------------------------------
//		PARTICIPANTEDAO
		System.out.println("--------------------------------------------");
		ParticipanteDAO participantedao = new ParticipanteDAO();
		List<String> emails = Arrays.asList("meuemail@hotmail.com", "meuemail@gmail.com");
		Participante participante1 = new Participante("Nícolas", "av. Liberdade", "51986559754", "04836108012", emails);
		Participante participante2 = new Participante("Silvia", "av. Liberdade", "51986559754", "04836108012", emails);
		Participante participante3 = new Participante("Fabio", "av. Liberdade", "51986559754", "04836108012", emails);
		Participante participante4 = new Participante("Alex", "av. Liberdade", "51986559754", "04836108012", emails);
		Participante participante5 = new Participante("Karen", "av. Liberdade", "51986559754", "04836108012", emails);
		Participante participante6 = new Participante("Tanisi", "av. Liberdade", "51986559754", "04836108012", emails);
		participantedao.cadastrar(participante1).cadastrar(participante2).cadastrar(participante3)
				.cadastrar(participante4).cadastrar(participante5).cadastrar(participante6);

		participante1.setNome("Nícolas com Nome Atualizado");
		participantedao.atualizar(participante1, participante1.getIdentificador());

		System.out.println("Pesquisa pelo id 4:\n" + participantedao.pesquisarPelaChavePrimaria(4L));
		System.out.println("Pesquisa pelo nome \"nícolas\":\n" + participantedao.pesquisarPeloNome("nícolas"));

		System.out.println("Lista de todos os participantes cadastrados:");
		participantedao.obterTodos().forEach(System.out::println);

		participantedao.excluir(participante1.getIdentificador());

		participantedao.fecharEntityManager();
//		----------------------------------------------------------------------------------------------
//		LOCALDAO
		System.out.println("--------------------------------------------");
		LocalDAO localdao = new LocalDAO();
		Local local1 = new Local("Sesi", "55051999996666", "Nícolas");
		Local local2 = new Local("Sesc", "55051999996666", "Silvia");
		Local local3 = new Local("Senai", "55051999996666", "Silvia");
		localdao.cadastrar(local1).cadastrar(local2).cadastrar(local3);

		local2.setOrganizador("Robert");
		localdao.atualizar(local2, local2.getIdentificador());

		System.out.println("Pesquisa pelo id 2:\n" + localdao.pesquisarPelaChavePrimaria(2L));
		System.out.println("Pesquisa pelo nome \"sesi\":\n" + localdao.pesquisarPeloNome("sesi"));

		System.out.println("Lista de todas os locais cadastrados:");
		localdao.obterTodos().forEach(System.out::println);

		localdao.excluir(local2.getIdentificador());

		localdao.fecharEntityManager();
//		----------------------------------------------------------------------------------------------
//		EVENTODAO
		System.out.println("--------------------------------------------");
		EventoDAO eventodao = new EventoDAO();
		Evento evento1 = new Evento("Aniversário", 15.5, LocalDateTime.of(2021, 12, 19, 0, 0), Situacao.ANDAMENTO,
				Arrays.asList(participante2, participante3, participante4), local1);
		Evento evento2 = new Evento("Recuperação", 25, LocalDateTime.of(2021, 12, 1, 0, 0), Situacao.ENCERRADO,
				Arrays.asList(participante4, participante5, participante6), local3);
		Evento evento3 = new Evento("Evento teste", 25, LocalDateTime.of(2020, 12, 1, 0, 0), Situacao.ENCERRADO);
		eventodao.cadastrar(evento1).cadastrar(evento2).cadastrar(evento3);

		System.out.println("Evento 1 tem data válida (2021)? " + evento1.getData() + " " + evento1.validarData());
		System.out.println("Evento 2 tem data válida (2021)? " + evento2.getData() + " " + evento2.validarData());
		System.out.println("Evento 3 tem data válida (2021)? " + evento3.getData() + " " + evento3.validarData());

		evento2.setNome("Formatura");
		eventodao.atualizar(evento2, evento2.getIdentificador());

		System.out.println("Pesquisa pelo id 1:\n" + eventodao.pesquisarPelaChavePrimaria(1L));
		System.out.println("Pesquisa pelo nome \"form\":\n" + eventodao.pesquisarPeloNome("form"));

		System.out.println("Lista de todos os eventos cadastrados:");
		eventodao.obterTodos().forEach(System.out::println);

		eventodao.excluir(evento3.getIdentificador());

		eventodao.fecharEntityManager().fecharEntityManagerFactory();
	}
}
