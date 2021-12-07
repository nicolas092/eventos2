package eventos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import pessoas.Participante;
import util.Situacao;

@Entity
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_EVENTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(nullable = false)
	private double taxaInscricao;

//	escolhi LocalDateTime pois o mais comum é que um evento tenha também, além de dia
//	específico, um horário definido para iniciar. Além disso, optei por usar o
//	pacote java.time por ser uma solução mais recente
	private LocalDateTime data;

//	escolhi EnumType.ORDINAL porque entendo que a necessidade de mudar os valores da Enum
//	("ENCERRADO" para "FINALIZADO" por exemplo) tende a ser mais recorrente
//	do que mudar a ordem das constantes
	@Enumerated(EnumType.ORDINAL)
	private Situacao situacao;

	@OneToMany // (cascade = CascadeType.PERSIST) comentado pois os registros já foram
				// inseridos manualmente
	private List<Participante> participantes = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Local local;

	public Evento() {
		super();
	}

	public Evento(String nome, double taxaInscricao, LocalDateTime data, Situacao situacao) {
		super();
		this.nome = nome;
		this.taxaInscricao = taxaInscricao;
		this.data = data;
		this.situacao = situacao;
	}

	public Evento(String nome, double taxaInscricao, LocalDateTime data, Situacao situacao,
			List<Participante> participantes, Local local) {
		super();
		this.nome = nome;
		this.taxaInscricao = taxaInscricao;
		this.data = data;
		this.situacao = situacao;
		this.participantes = participantes;
		this.local = local;
	}

	public boolean validarData() {
		if (this.data.getYear() == 2021)
			return true;
		else
			return false;
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTaxaInscricao() {
		return taxaInscricao;
	}

	public void setTaxaInscricao(double taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String toString() {
		String auxParticipantes = "";
		if (participantes != null) {
			for (Participante participante : participantes) {
				if (participante != null)
					auxParticipantes += participante.toString() + "\n";
			}
		}

		String auxLocal = "";
		if (local != null)
			auxLocal += local.toString();
		else
			auxLocal += " local não informado";

		return "EVENTO" + "\nnome = " + nome + ", taxaInscricao = R$" + taxaInscricao + ", data = " + data
				+ ", situacao = " + situacao + "\nLocal" + auxLocal + "\nParticipantes\n"
				+ (auxParticipantes.equals("") ? "nenhum participante informado\n" : auxParticipantes);
	}

}
