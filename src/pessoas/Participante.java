package pessoas;

import java.util.List;

import eventos.Evento;

public class Participante extends Pessoa {

	private String endereco;
	private String telefone;
	private String cpf;
	private String email;
	private List<Evento> eventos;
	
	public Participante(String nome) {
		super(nome);
	}

	public Participante(String nome, String endereco, String telefone, String cpf, String email, List<Evento> eventos) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.eventos = eventos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "Participante [endereco=" + endereco + ", telefone=" + telefone + ", cpf=" + cpf + ", email=" + email
				+ ", eventos=" + eventos + "]";
	}
	
}
