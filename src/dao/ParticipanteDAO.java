package dao;

import java.util.List;

import pessoas.Participante;

public class ParticipanteDAO extends DAO<Participante> {
	public ParticipanteDAO() {
		super(Participante.class);
	}

	public Participante pesquisarPeloNome(String nomeProcurado) {
		List<Participante> locais = obterTodos();
		for (Participante local : locais) {
			if (local.getNome().equals(nomeProcurado))
				return local;
		}
		return null;
	}

	public DAO<Participante> cadastrar(Participante entidade) {
		try {
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
			System.out.println("Cadastro de registro da classe " + classe.getName() + " inserido com sucesso Id: "
					+ entidade.getIdentificador());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
