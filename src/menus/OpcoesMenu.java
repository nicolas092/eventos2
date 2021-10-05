package menus;

public enum OpcoesMenu {
	CADASTRAR_EVENTO(1, "1 - Cadastrar evento"),
	PESQUISAR_EVENTO_COM_NOME(2, "2 - Pesquisar evento pelo nome"),
	PESQUISAR_EVENTO_COM_INSTITUICAO(3, "3 - Pesquisar evento pela instituicao"),
	PESQUISAR_EVENTO_COM_SITUACAO(4, "4 - Pesquisar evento pela situacao"),
	SAIR(5, "5 - Sair");

	private final int identificador;
	private final String descricao;
	
	private OpcoesMenu(int identificador, String descricao) {
		this.identificador = identificador;
		this.descricao = descricao;
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
