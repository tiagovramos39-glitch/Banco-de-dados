package livraria;

public class LivroDeLivraria extends Livro{
	private double preco;
	private int estoque;
	
	public LivroDeLivraria(String titulo, String autor, String editora, int numeroPaginas, int anoPublicacao,
			double preco, int estoque) {
		super(titulo, autor, editora, numeroPaginas, anoPublicacao);
		this.preco = preco;
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public void exibirDados() {
		System.out.println("Título: " + getTitulo());
		System.out.println("Autor: " + getAutor());
		System.out.println("Editora: " + getEditora());
		System.out.println("Número de páginas: " +getNumeroPaginas());
		System.out.println("Ano de publicação: " + getAnoPublicacao());
		System.out.println("Preço: " + preco);
		System.out.println("Quantidade em estoque: " + estoque);
		System.out.println();
	}
	
}