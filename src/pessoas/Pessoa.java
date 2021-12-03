package pessoas;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

// ESTRATÉGIA DE HERANÇA: embora eu entenda que a melhor escolha pode variar em cada caso, acredito que JOINED tende a ser 
// o mais interessante. Apesar de ser menos performático, essa estratégia não vai gerar uma tabela enorme com vários
// campos nulos como é no SINGLE_TABLE e nem gerar colunas duplicadas como é no TABLE_PER_CLASS. Além disso, o fato de que
// esse modelo de criação de tabelas no banco de dados ser o que mais se aproxima do paradigma OO é mais um motivo para sua
// escolha
@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 3, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "PES")
public class Pessoa {
	
	@Id
	@Column(name = "idPessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Pessoa [" +
				"\nnome=" + nome + "]";
	}
	
}
