package atividade;

import java.util.Scanner;

public class Exercicio14 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		double[] temperaturas = new double[7];

		
		for (int i = 0; i < temperaturas.length; i++) {
			System.out.print("Digite um número: ");
			temperaturas[i] = leia.nextDouble();
		}
		double maior = temperaturas[0], menor = temperaturas[0];
		
		
		for (int i = 0; i < temperaturas.length; i++) {
			System.out.println(temperaturas[i]);
			if (maior < temperaturas[i]) maior = temperaturas[i];
			if (menor > temperaturas[i]) menor = temperaturas[i];
		}
		System.out.println("Maior temperatura: " + maior);
		System.out.println("Menor temperatura: " + menor);
	}
}
