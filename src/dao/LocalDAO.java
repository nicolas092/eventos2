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
			if (local.getInstituicao().equals(nomeProcurado))
				return local;
		}
		return null;
	}
	
	public DAO<Local> cadastrar(Local entidade) {
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
