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
			em.getTransaction().begin();
			em.remove(em.find(classe, identificador));
			em.getTransaction().commit();
			System.out.println("Registro da classe " + classe.getName() + " removido com sucesso Id: "
					+ identificador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public DAO<E> atualizar(E entidade, Long identificador) {
		try {
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
			System.out.println("Registro da classe " + classe.getName() + " atualizado com sucesso Id: "
					+ identificador);
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

	public DAO<E> fecharEntityManager() {
		em.close();
		return this;
	}

	public DAO<E> fecharEntityManagerFactory() {
		emf.close();
		return this;
	}

}
