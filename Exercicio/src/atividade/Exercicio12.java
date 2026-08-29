package atividade;

import java.util.Scanner;

public class Exercicio12 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int[] numeros = new int[5];
		
		for (int i = 0; i < numeros.length; i++) {
		System.out.print("Digite um número: ");
		numeros[i] = leia.nextInt();
		}
		System.out.println("Números cadastrados: ");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	} 
}
