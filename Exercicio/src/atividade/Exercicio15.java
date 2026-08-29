package atividade;

import java.util.Scanner;

public class Exercicio15 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int par = 0, impar = 0;
		int[] vetor = new int[8];
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.print("Digite um número: ");
			vetor[i] = leia.nextInt();
		}
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i]%2 == 0) {
				par++;
			System.out.println("Numero " + vetor[i] + " par");
		} else {
				impar++;
			System.out.println("Numero " + vetor[i] + " impar");
			}
		}
		System.out.println("Quantidade de pares: " + par);
		System.out.println("Quantidade de ímpares: " + impar);
	}
}
