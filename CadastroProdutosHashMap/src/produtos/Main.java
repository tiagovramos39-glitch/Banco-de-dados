package produtos;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		HashMap<Integer, Produto> produtos = new HashMap<>();
		
		produtos.put(01, new Produto ("Teclado", 120.00, 10));
		produtos.put(02, new Produto ("Notebook", 980.99, 50));
		produtos.put(03, new Produto ("Televisão", 750.80, 80));
		produtos.put(04, new Produto ("Nintendo Switch", 1986.40, 25));
		produtos.put(05, new Produto ("Pen drive", 50.00, 150));
		
		
		System.out.print("Informe o código do produto: ");
		int codigo = Integer.parseInt(leia.nextLine());
		 if (produtos.containsKey(codigo)) {
			 produtos.get(codigo).exibirDados();
			 } else {
				 System.out.println("Produto não encontrado");
			 }
		 }
}