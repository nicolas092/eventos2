package teste;

import dao.ParticipanteDAO;
import pessoas.Participante;

public class TestesMapeamentos {
	public static void main(String[] args) {
		ParticipanteDAO dao = new ParticipanteDAO();
		
		Participante pessoa = new Participante("Nícolas", "av. Liberdade", "51986559754", "04836108012");
		dao.cadastrar(pessoa);
		
		dao.fecharEntityManager();
		dao.fecharEntityManagerFactory();
	}
}
