package atividade;

import java.util.Scanner;

public class Exercicio3 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		double base, altura;
		
		do {
		System.out.println("Digite a base do triângulo: ");
		base = leia.nextDouble();
		
		System.out.println("Digite a altura do triângulo: ");
		altura = leia.nextDouble();
		} while (base < 0 || altura < 0);
			
		System.out.printf("A área do triângulo é de: %.2f%n ", (base * altura)/2);
		
		
		leia.close();
		
	}

}
