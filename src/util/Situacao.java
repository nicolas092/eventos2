package util;

public enum Situacao {
	ANDAMENTO(1, "1 - Andamento"),
	CANCELADO(2, "2 - Cancelado"),
	ENCERRADO(3, "3 - Encerrado");
	
	private final int identificador;
	private final String descricao;
	
	Situacao(int identificador, String descricao) {
		this.identificador = identificador;
		this.descricao = descricao;
	}
	
	public int getValor () {
		return this.identificador;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
