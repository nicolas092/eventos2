package util;

public enum Situacao {
	ANDAMENTO(1), CANCELADO(2), ENCERRADO(3);
	
	private final int valor;
	
	Situacao(int valor) {
		this.valor = valor;
	}
	
	public int getValor () {
		return this.valor;
	}
}
