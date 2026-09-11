package estacionamento;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String placa, modelo, proprietario;
		int ano, opcao, codigo = 1;
		Scanner leia = new Scanner(System.in);
		HashMap<Integer, Veiculo> veiculos = new HashMap<>();
		
		do {
			System.out.println("Escolha uma opção: \n" 
					+ "1 - Registrar entrada de veículo"
					+ "2 - Pesquisar veículo pelo código"
					+ "3 - Listar veículos"
					+ "4 - Alterar proprietário"
					+ "5 - Registrar saída do veículo"
					+ "0 - Encerrar");
			
			opcao = Integer.parseInt(leia.nextLine());
			switch (opcao) {
			case 1:
				System.out.print("Placa:");
				placa = leia.nextLine();

				System.out.println("Modelo: ");
				modelo = leia.nextLine();
				
				System.out.println("Proprietário(a): ");
				proprietario = leia.nextLine();

				System.out.println("Ano: ");
				ano = (leia.nextInt());

				codigo++;
				break;

			case 2:
				System.out.println("Código do veículo: ");
				int codBusca = Integer.parseInt(leia.nextLine());
				if (veiculos.containsKey(codBusca)) {
					veiculos.get(codBusca).exibirDados();
				} else {
					System.out.println("Veículo não identificado");
				}
				break;

			case 3:
				for (Map.Entry<Integer, Veiculo> veiculo : veiculos.entrySet()) {
					veiculo.getValue().exibirDados();
				}
				break;
				
			case 4:
				System.out.println("Código do veículo: ");
				codBusca = Integer.parseInt(leia.nextLine());
				if (veiculos.containsKey(codBusca)) {
					Veiculo veiculo = veiculos.get(codBusca);
					
					System.out.print("Informe o novo proprietario do veículo: ");
					String novoProprietario = leia.nextLine();
					veiculo.setProprietario(novoProprietario);
					
				} else {
					System.out.println("Veículo não identificado");
				}
				break;
				
			case 5:
				System.out.println("Código do veículo: ");
				codBusca = Integer.parseInt(leia.nextLine());
				if (veiculos.containsKey(codBusca)) {
					veiculos.remove(codBusca);
					System.out.println("Veículo removido");
				} else {
					System.out.println("Veículo não identificado");
				}
				break;
			}

		} while (opcao != 0);

		System.out.println("Programa encerrado");

	}
}