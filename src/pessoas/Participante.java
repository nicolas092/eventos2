package pessoas;

import java.io.Serializable;
import java.util.ArrayList;

public class Participante extends Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2521736816830815866L;
	private String endereco;
	private String telefone;
	private String cpf;
//	@ElementCollection
//	@CollectionTable(name = "emails_dos_participantes")
	private ArrayList<String> email;
	
	public Participante(String nome) {
		super(nome);
	}

	public Participante(String nome, String endereco, String telefone, String cpf, ArrayList<String> email) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
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

	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "nome = " + this.getNome() +
				", endereco = " + endereco +
				", telefone = " + telefone +
				", cpf = " + cpf +
				", email = " + email;
	}
	
}
