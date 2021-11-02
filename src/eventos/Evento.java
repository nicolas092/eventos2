package eventos;

import java.io.Serializable;
import java.util.List;
import pessoas.Participante;
import util.Situacao;
import util.Validador;

public class Evento implements Validador, Serializable, Comparable<Evento> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5823077336776252082L;
	private String nome;
	private double taxaInscricao;
	private String data;
	private Situacao situacao;
	private List<Participante> participantes;
	private Local local;

	public Evento() {
		super();
	}

	public Evento(String nome, double taxaInscricao, String data, Situacao situacao, List<Participante> participantes, Local local) {
		super();
		this.nome = nome;
		this.taxaInscricao = taxaInscricao;
		this.data = data;
		this.situacao = situacao;
		this.participantes = participantes;
		this.local = local;
	}

	@Override
	public boolean validarData() {	// datas validas: somente ano de 2021
		int ano = Integer.parseInt(this.data.split("/")[2]);
		if (ano == 2021 || ano == 21) return true;
		return false;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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

