package listaJogos;

public class Jogo {
	long id;
	String jogo;
	String descricao;
	String plataforma;
	Jogo proximo;
	float valor;
	
	public Jogo(long id, String jogo, String descricao, String plataforma, float valor) {
		this.id = id;
		this.jogo = jogo;
		this.descricao = descricao;
		this.plataforma = plataforma;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJogo() {
		return jogo;
	}

	public void setJogo(String jogo) {
		this.jogo = jogo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
