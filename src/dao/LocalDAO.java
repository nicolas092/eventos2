package dao;

import java.util.List;

import eventos.Local;

public class LocalDAO extends DAO<Local> {

	public LocalDAO() {
		super(Local.class);
	}

	public Local pesquisarPeloNome(String nomeProcurado) {
		List<Local> locais = obterTodos();
		for (Local local : locais) {
			if (local.getInstituicao().toLowerCase().contains(nomeProcurado.toLowerCase()))
				return local;
		}
		return null;
	}

	public LocalDAO cadastrar(Local local) {
		try {
			em.getTransaction().begin();
			em.persist(local);
			em.getTransaction().commit();
			System.out.println("Registro da classe " + classe.getName() + " inserido com sucesso Id: "
					+ local.getIdentificador());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
