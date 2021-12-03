package dao;

import java.util.List;

import eventos.Evento;

public class EventoDAO extends DAO<Evento> {

	public EventoDAO() {
		super(Evento.class);
	}

	public Evento pesquisarPeloNome(String nomeProcurado) {
		List<Evento> eventos = obterTodos();
		for (Evento evento : eventos) {
			if (evento.getNome().equals(nomeProcurado))
				return evento;
		}
		return null;
	}

	public DAO<Evento> cadastrar(Evento entidade) {
		try {
			em.persist(entidade);
			System.out.println("Cadastro de registro da classe " + classe.getName() + " inserido com sucesso Id: "
					+ entidade.getIdentificador());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
