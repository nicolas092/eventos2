package eventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Local implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_LOCAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	@Column(length = 50, nullable = false)
	private String instituicao;
	@Column(length = 14, nullable = false)
	private String telefone;
	@Column(length = 50, nullable = false)
	private String organizador;

	@OneToMany(mappedBy = "local", cascade = CascadeType.PERSIST)
	private List<Evento> eventos = new ArrayList<>();

	public Local() {
		super();
	}

	public Local(String instituicao, String telefone, String organizador) {
		super();
		this.instituicao = instituicao;
		this.telefone = telefone;
		this.organizador = organizador;
	}
	
	public Local(String instituicao, String telefone, String organizador, List<Evento> eventos) {
		super();
		this.instituicao = instituicao;
		this.telefone = telefone;
		this.organizador = organizador;
		this.setEventos(eventos);
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public String toString() {
		return "instituição = " + instituicao + ", telefone = " + telefone + ", organizador = " + organizador;
	}

}
