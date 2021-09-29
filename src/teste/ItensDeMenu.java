package teste;

public enum ItensDeMenu {
	CADASTRAR_EVENTO(1), PESQUISAR_EVENTO_COM_NOME(2), PESQUISAR_EVENTO_COM_INSTITUICAO(3),
	PESQUISAR_EVENTO_COM_SITUACAO(4), SAIR(5);

	private final int valor;
	
	ItensDeMenu(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
}
