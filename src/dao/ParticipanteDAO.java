package dao;

import java.util.List;

import pessoas.Participante;

public class ParticipanteDAO extends DAO<Participante> {
	public ParticipanteDAO() {
		super(Participante.class);
	}

	public Participante pesquisarPeloNome(String nomeProcurado) {
		List<Participante> participantes = obterTodos();
		for (Participante participante : participantes) {
			if (participante.getNome().toLowerCase().contains(nomeProcurado.toLowerCase()))
				return participante;
		}
		return null;
	}

	public ParticipanteDAO cadastrar(Participante participante) {
		try {
			em.getTransaction().begin();
			em.persist(participante);
			em.getTransaction().commit();
			System.out.println("Registro da classe " + classe.getName() + " inserido com sucesso Id: "
					+ participante.getIdentificador());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
