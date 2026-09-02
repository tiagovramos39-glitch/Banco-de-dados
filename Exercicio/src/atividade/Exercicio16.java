package atividade;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio16 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		String opcao;
		
		ArrayList<String> tarefas = new ArrayList<>();
		
		do {
			System.out.println("Cadastre uma tarefa");
			tarefas.add(leia.nextLine());	
			
			System.out.println("Deseja cadastrar uma tarefa?");
			opcao = leia.nextLine();
			
		} while (opcao.equalsIgnoreCase("s"));
		
		System.out.println(tarefas);
	}
}