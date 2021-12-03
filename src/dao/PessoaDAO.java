package dao;

import java.util.List;

import pessoas.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {
	public PessoaDAO() {
		super(Pessoa.class);
	}

	public Pessoa pesquisarPeloNome(String nomeProcurado) {
		List<Pessoa> locais = obterTodos();
		for (Pessoa local : locais) {
			if (local.getNome().equals(nomeProcurado))
				return local;
		}
		return null;
	}

	public DAO<Pessoa> cadastrar(Pessoa entidade) {
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
