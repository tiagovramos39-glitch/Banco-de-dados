package livraria;

public class Principal {

	public static void main(String[] args) {
		LivroDeLivraria l1 = new LivroDeLivraria("O Hobbit", "Tolkien", "HarperCollins Brasil", 336, 1937, 68.99, 10);
		Livro l2 = new Livro("O Alquimista", "Paulo Coelho", "Rocco", 208, 1988);
		
		
		
		l1.exibirDados();
		l2.exibirDados();
	}
}