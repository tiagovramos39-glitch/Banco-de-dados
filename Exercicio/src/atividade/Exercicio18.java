package atividade;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio18 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		ArrayList<String> alunos = new ArrayList<>();
		ArrayList<String> notas = new ArrayList<>();
		int opcao;
		
		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1) Cadastrar aluno");
			System.out.println("2) Listar alunos");
			System.out.println("3) Procurar aluno");
			System.out.println("4) Alterar nota");
			System.out.println("5) Remover aluno");
			System.out.println("6) Exibir média da turma");
			System.out.println("7) Exibir maior e menor nota");
			System.out.println("8) Exibir situação dos alunos");
			System.out.println("9) Encerrar");
			opcao = Integer.parseInt(leia.nextLine());
			
			switch (opcao) {
			case 1:
				System.out.println("Insira o nome do convidado");
				alunos.add(leia.nextLine());
				break;
			case 2: 
				for(String nome: alunos)
					System.out.println(nome);
				break;
			case 3:
				System.out.println("Nome: ");
				int indice = alunos.indexOf(leia.nextLine());
				System.out.println(indice < 0 ? "Não encontrado." : "Posição " + indice);
				break;
				
			case 4:
				System.out.println("Posição: ");
				int p = Integer.parseInt(leia.nextLine());
				if (p >= 0 && p < notas.size()) {
					System.out.println("Novo nome: ");
					notas.set(p, leia.nextLine());
				} else {
					System.out.println("Posição inválida");
					break;
					}
			case 5:
				System.out.println("Nome: ");
				String remover = leia.nextLine();
				if (alunos.contains(remover)) {
					alunos.remove(remover);
				} else {
					System.out.println("Não encontrado");
				}
				break;
			case 6:
				System.out.println("Média da turma: ");
			case 9:
				System.out.println("Até um outro dia");
				break;
			}
		} while(opcao != 9);
	}
}
