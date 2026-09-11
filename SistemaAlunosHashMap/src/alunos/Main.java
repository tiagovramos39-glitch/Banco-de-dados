package alunos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		String nome, curso;
		int opcao, codigo = 1;
		double nota;
		HashMap<Integer, Aluno> alunos = new HashMap<>();

		do {
			System.out.println("Escolha uma opção: \n" + "1) Cadastrar aluno\n" + "2) Pesquisar aluno\n"
					+ "3) Listar alunos\n" + "4) Alterar nota\n" + "5) Remover aluno\n" + "0) Encerrar");

			opcao = Integer.parseInt(leia.nextLine());
			switch (opcao) {
			case 1:
				System.out.print("Nome:");
				nome = leia.nextLine();

				System.out.println("Curso: ");
				curso = leia.nextLine();

				System.out.println("Nota: ");
				nota = Double.parseDouble(leia.nextLine());

				alunos.put(codigo, new Aluno(nome, curso, nota));
				codigo++;
				break;

			case 2:
				System.out.println("Código do aluno: ");
				int codBusca = Integer.parseInt(leia.nextLine());
				if (alunos.containsKey(codBusca)) {
					alunos.get(codBusca).exibirDados();
				} else {
					System.out.println("Aluno não identificado");
				}
				break;

			case 3:
				for (Map.Entry<Integer, Aluno> aluno : alunos.entrySet()) {
					aluno.getValue().exibirDados();
					aluno.getValue().verificarSituacao();
				}
				break;
				
			case 4:
				System.out.println("Código do aluno: ");
				codBusca = Integer.parseInt(leia.nextLine());
				if (alunos.containsKey(codBusca)) {
					Aluno aluno = alunos.get(codBusca);
					
					System.out.print("Informe a nova nota do aluno: ");
					aluno.setNota(Double.parseDouble(leia.nextLine()));
					alunos.put(codBusca, aluno);
					
				} else {
					System.out.println("Aluno não identificado");
				}
				break;
				
			case 5:
				System.out.println("Código do aluno: ");
				codBusca = Integer.parseInt(leia.nextLine());
				if (alunos.containsKey(codBusca)) {
					alunos.remove(codBusca);
					System.out.println("Aluno removido");
				} else {
					System.out.println("Aluno não identificado");
				}
				break;
			}

		} while (opcao != 0);

		System.out.println("Programa encerrado");
	}
}