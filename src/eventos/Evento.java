package eventos;

import java.util.List;
import pessoas.Participante;
import util.Situacao;
import util.Validador;

public class Evento implements Validador {
	private String nome;
	private double taxaInscricao;
	private String data;
	private List<Participante> participantes;
	private Situacao situacao;
	private Local local;
	
	public Evento() {
		super();
	}

	public Evento(String nome, double taxaInscricao, String data, List<Participante> participantes, Situacao situacao, Local local) {
		super();
		this.nome = nome;
		this.taxaInscricao = taxaInscricao;
		this.data = data;
		this.participantes = participantes;
		this.situacao = situacao;
		this.local = local;
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
		return "Evento [nome=" + nome + ", taxaInscricao=" + taxaInscricao + ", data=" + data + ", participantes="
				+ participantes + ", situacao=" + situacao + ", local=" + local + "]";
	}

	@Override
	public boolean validarData() {	// datas validas: somente ano de 2021
		int ano = Integer.parseInt(this.data.split("/")[2]);
		if (ano == 2021 || ano == 21) return true;
		return false;
	}

}
