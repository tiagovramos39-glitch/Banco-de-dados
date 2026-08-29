package atividade;

import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao;
		double salario, imposto, novoSalario;
		
		
		System.out.println("Digite uma opção:");
		System.out.println("1. Calcular o imposto sobre o salário");
		System.out.println("2. Calcular o novo salário após um aumento");
		System.out.println("3. Mostrar a classificação do salário");
		System.out.println("4. Finalizar o programa");
		opcao = leia.nextInt();
		
		switch (opcao) {
		
			case 1:
			System.out.println("Digite o salário bruto: ");
			salario = leia.nextDouble();
			
			if (salario < 500) {
				imposto = salario*0.05;
				System.out.println("O imposto cobrado será de " + imposto);
			}
			else if (salario >= 500 && salario < 850) {
				imposto = salario *0.1;
				System.out.println("O imposto cobrado será de " + imposto);
			}
			else if (salario > 850) {
				imposto = salario*0.15;
				System.out.println("O imposto cobrado será de " + imposto);
			}
			break;
			
			case 2:  
			System.out.println("Digite o salário bruto: ");
			salario = leia.nextDouble();
			
			if (salario > 1500) {
				novoSalario = salario + 250;
				System.out.println("O novo salário será de " + novoSalario);
			}
			else if (salario > 750 && salario <= 1500) {
				novoSalario = salario + 50;
				System.out.println("O novo salário será de " + novoSalario);
			}
			else if (salario > 450 && salario < 750) {
				novoSalario = salario + 75;
				System.out.println("O novo salário será de " + novoSalario);
			}
			else if (salario < 450) {
				novoSalario = salario + 100;
				System.out.println("O novo salário será de " + novoSalario);
			}
			break;
			
			case 3: 
			System.out.println("Digite o salário bruto: ");
			salario = leia.nextDouble();
			
			if (salario < 700) {
				System.out.println("Mal remunerado");
			}
			else if (salario >= 700) {
				System.out.println("Bem remunerado");
			}
			else {
				System.out.println("Salário inválido");
			}
			break;
			
			case 4:
			System.out.println("Programa encerrado");
			break;
		}
	}
}
