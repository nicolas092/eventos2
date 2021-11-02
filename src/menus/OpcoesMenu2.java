package menus;

public enum OpcoesMenu2 {
	CADASTRAR_EVENTO(1, "1 - Cadastrar evento"),
	LISTAR_TODOS_OS_EVENTOS(2, "2 - Listar todos os eventos"),
	LISTAR_TODOS_OS_EVENTOS_COM_NOME_DE_PARTICIPANTE(3, "3 - Listar todos os eventos que um participante se inscreveu"),
	REMOVER_EVENTO_PELO_NOME(4, "4 - Remover evento usando o nome"),
	SAIR(5, "5 - Sair");

	private final int identificador;
	private final String descricao;
	
	private OpcoesMenu2(int identificador, String descricao) {
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
