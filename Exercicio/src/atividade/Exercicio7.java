package atividade;

import java.util.Scanner;

public class Exercicio7 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		double numero1, numero2;
		int escolha;
		
		System.out.print("Digite um número: ");
		numero1 = leia.nextDouble();
		
		System.out.print("Digite um número: ");
		numero2 = leia.nextDouble();
		
		do {
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Calcular a média dos números");
		System.out.println("2 - Subtrair o menor número do maior");
		System.out.println("3 - Multiplicar os números");
		System.out.println("4 - Dividir o primeiro número pelo segundo");
		escolha = leia.nextInt();
		} while (escolha <1 || escolha > 4);
		
		switch (escolha) {
		
		case 1: System.out.println((numero1 + numero2)/2); break;
		case 2: if (numero1 > numero2) {
			System.out.println(numero1 - numero2); 
		} else {
			System.out.println(numero2 - numero1); 
		} break;
		case 3: System.out.println(numero1*numero2); break;
		case 4: if (numero2 == 0) {
			System.out.println("Número inválido"); 
		} else {System.out.println(numero1/numero2); 
		} break;
	}
	}
}