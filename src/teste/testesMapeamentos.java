package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pessoas.Participante;
import pessoas.Pessoa;

public class testesMapeamentos {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-name");
		EntityManager em = emf.createEntityManager();

		Pessoa pessoa = new Pessoa("Nícolas");
		Pessoa pessoa2 = new Participante("Nícolas", "av. Liberdade", "51986559754", "04836108012");
		em.getTransaction().begin();
		em.persist(pessoa);
		em.persist(pessoa2);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
