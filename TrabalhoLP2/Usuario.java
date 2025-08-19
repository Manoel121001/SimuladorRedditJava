package TrabalhoLP2;


public class Usuario {

	private final String nome;
	private boolean logado = false;
	private int quantidadeDePosts = 0;
	private int quantidadeDeComentarios = 0;


	public Usuario(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public boolean getLogado(){return logado;}

	public void setLogado(boolean logado) {this.logado = logado;}

	public void setQuantidadeDePosts(int numPost) {
		this.quantidadeDePosts = numPost;
	}

	public void setQuantidadeDeComentarios(int quantidadeDeComentarios) {
		this.quantidadeDeComentarios = quantidadeDeComentarios;
	}
}

