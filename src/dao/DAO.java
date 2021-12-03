package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	private static EntityManagerFactory emf;
	protected EntityManager em;
	protected Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("persistence-unit-name");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DAO(Class<E> classe) {
		em = emf.createEntityManager();
		this.classe = classe;
	}

	public DAO<E> abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> excluir(Long identificador) {
		try {
			em.remove(em.find(classe, identificador));
			System.out
					.println("Registro " + identificador + " da classe " + classe.getName() + " excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public DAO<E> atualizar(E entidade) {
		try {
			em.merge(entidade);
			System.out.println("Registro da classe " + classe.getName() + " atualizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;

	}

	public E pesquisarPelaChavePrimaria(Long identificador) {
		E instanciaProcurada = null;
		try {
			instanciaProcurada = em.find(classe, identificador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instanciaProcurada;
	}

	public List<E> obterTodos() {
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		return query.getResultList();
	}

	public void fecharEntityManager() {
		em.close();
	}

	public void fecharEntityManagerFactory() {
		emf.close();
	}

}
