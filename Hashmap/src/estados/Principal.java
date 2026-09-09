package estados;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		HashMap<String, String> capitais = new HashMap<>();
		
		capitais.put("Rio de Janeiro", "Rio de Janeiro");
		capitais.put("Minas Gerais", "Belo Horizonte");
		capitais.put("São Paulo", "São Paulo");
		capitais.put("Bahia", "Salvador");
		capitais.put("Paraná", "Curitiba");
		
		System.out.print("Digite o estado: ");
		String estado = input.nextLine();
		
		if (capitais.containsKey(estado)) {
			String capital = capitais.get(estado);
			System.out.println("A capital é " + capital);
		} else {
			System.out.println("Estado não encontrado");
		}
	}
}