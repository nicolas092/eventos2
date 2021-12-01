package eventos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import pessoas.Participante;
import util.Situacao;

public class Evento implements Serializable, Comparable<Evento> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5823077336776252082L;
	private String nome;
	private double taxaInscricao;
//	escolhi LocalDateTime pois o mais comum é que um evento tenha, além de dia específico,
//	um horário definido para iniciar. Além disso, optei por usar o pacote java.time por ser uma solução mais recente
	private LocalDateTime data;
//	escolhi EnumType.ORDINAL porque entendo que mudar os valores da Enum ("ENCERRADO" para "FINALIZADO" por exemplo)
//	pode ser interessante, mas não vejo porque mudar a ordem das constantes
//	@Enumerated(EnumType.ORDINAL)
	private Situacao situacao;
	private List<Participante> participantes;
	private Local local;

	public Evento() {
		super();
	}

	public Evento(String nome, double taxaInscricao, LocalDateTime data, Situacao situacao, List<Participante> participantes, Local local) {
		super();
		this.nome = nome;
		this.taxaInscricao = taxaInscricao;
		this.data = data;
		this.situacao = situacao;
		this.participantes = participantes;
		this.local = local;
	}
	
	/*
	 * public boolean validarData() {
	 * 
	 * }
	 */

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
		if(participantes != null) {																// participantes nunca sera nulo
			for(Participante participante : participantes) {
				if(participante != null) auxParticipantes += participante.toString() + "\n";	// embora listas possam ter valores nulos,
			}																					// participante nunca sera nulo
		}

		String auxLocal = "";
		if(local != null) auxLocal += local.toString(); 
		else auxLocal += "local não informado";

		return "EVENTO" +
		"\nnome = " + nome +
		", taxaInscricao = R$" + taxaInscricao +
		", data = " + data +
		", situacao = " + situacao +
		"\nLocal" + auxLocal +
		"\nParticipantes\n" + (auxParticipantes.equals("") ? "nenhum participante informado\n" : auxParticipantes);
	}



	@Override
	public int compareTo(Evento o) {
		return nome.compareToIgnoreCase(o.getNome());
	}



}

