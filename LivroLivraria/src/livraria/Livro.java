package livraria;

public class Livro {
	private String titulo, autor, editora;
	private int numeroPaginas, anoPublicacao;
	
	public Livro(String titulo, String autor, String editora, int numeroPaginas, int anoPublicacao) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.numeroPaginas = numeroPaginas;
		this.anoPublicacao = anoPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public void exibirDados() {
	System.out.println("Título: " + titulo);
	System.out.println("Autor: " + autor);
	System.out.println("Editora: " + editora);
	System.out.println("Número de páginas: " +numeroPaginas);
	System.out.println("Ano de publicação: " + anoPublicacao);
	System.out.println();
	}
}