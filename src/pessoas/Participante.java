package pessoas;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "participantes")
@PrimaryKeyJoinColumn(name = "idParticipante", referencedColumnName = "idPessoa")
public class Participante extends Pessoa {

	@Column(length = 200, nullable = false)
	private String endereco;
	@Column(length = 14, nullable = true)
	private String telefone;
	@Column(length = 11, nullable = false)
	private String cpf;
//	@ElementCollection
//	@CollectionTable(name = "emails_dos_participantes")
//	private ArrayList<String> emails;
	
	public Participante() {
		super();
	}

	public Participante(String nome, String endereco, String telefone, String cpf/* , ArrayList<String> emails */) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
//		this.emails = emails;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/*
	 * public ArrayList<String> getEmail() { return emails; }
	 * 
	 * public void setEmail(ArrayList<String> emails) { this.emails = emails; }
	 */

	@Override
	public String toString() {
		return "nome = " + this.getNome() +
				", endereco = " + endereco +
				", telefone = " + telefone +
				", cpf = " + cpf +
				", email = " /* + emails */;
	}
	
}
