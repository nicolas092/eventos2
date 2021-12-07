package pessoas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "ID_PARTICIPANTE", referencedColumnName = "ID_PESSOA") // referente a estretegia de heranca
public class Participante extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(length = 200, nullable = false)
	private String endereco;
	@Column(length = 14, nullable = true)
	private String telefone;
	@Column(length = 11, nullable = false)
	private String cpf;

	@ElementCollection
	private List<String> emails = new ArrayList<>();

	public Participante() {
		super();
	}

	public Participante(String nome, String endereco, String telefone, String cpf, List<String> emails) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.emails = emails;
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

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "nome = " + this.getNome() + ", endereco = " + endereco + ", telefone = " + telefone + ", cpf = " + cpf
				+ ", email = " + emails;
	}

}
