package dao;

import java.util.List;

import pessoas.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {
	public PessoaDAO() {
		super(Pessoa.class);
	}

	public Pessoa pesquisarPeloNome(String nomeProcurado) {
		List<Pessoa> pessoas = obterTodos();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().toLowerCase().contains(nomeProcurado.toLowerCase()))
				return pessoa;
		}
		return null;
	}

	public DAO<Pessoa> cadastrar(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
			System.out.println("Registro da classe " + classe.getName() + " inserido com sucesso Id: "
					+ pessoa.getIdentificador());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
