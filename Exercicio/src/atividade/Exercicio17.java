package atividade;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio17 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		ArrayList<String> convidado = new ArrayList<>();
		int opcao;
		
		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1) Adicionar convidado");
			System.out.println("2) Alterar convidado");
			System.out.println("3) Remover convidado");
			System.out.println("4) Procurar convidado");
			System.out.println("5) Exibir convidados");
			System.out.println("6) Encerrar");
			opcao = Integer.parseInt(leia.nextLine());
			
			switch (opcao) {
			case 1:
				System.out.println("Insira o nome do convidado");
				convidado.add(leia.nextLine());
				break;
			case 2: 
				System.out.println("Posição: ");
				int p = Integer.parseInt(leia.nextLine());
				if (p >= 0 && p < convidado.size()) {
					System.out.println("Novo nome: ");
					convidado.set(p, leia.nextLine());
				} else {
					System.out.println("Posição inválida");
					break;
					}
			case 3:
				System.out.println("Nome: ");
				String remover = leia.nextLine();
				if (convidado.contains(remover)) {
					convidado.remove(remover);
				} else {
					System.out.println("Não encontrado");
				}
			case 4:
				System.out.println("Nome: ");
				int indice = convidado.indexOf(leia.nextLine());
				System.out.println(indice < 0 ? "Não encontrado." : "Posição " + indice);
				break;
			case 5:
				for(String nome: convidado)
					System.out.println(nome);
				break;
			case 6:
				System.out.println("Até um outro dia");
				break;
			}
		} while(opcao != 6);
	
			
	}

}
