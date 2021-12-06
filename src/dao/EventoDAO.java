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
			if (evento.getNome().toLowerCase().contains(nomeProcurado.toLowerCase()))
				return evento;
		}
		return null;
	}

	public DAO<Evento> cadastrar(Evento evento) {
		try {
			em.getTransaction().begin();
			em.persist(evento);
			em.getTransaction().commit();
			System.out.println("Registro da classe " + classe.getName() + " inserido com sucesso Id: "
					+ evento.getIdentificador());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
