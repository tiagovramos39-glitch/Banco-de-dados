package atividade;

import java.util.Scanner;

public class Exercicio13 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		double ac = 0, media;
		double[] notas = new double[4];
		
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Digite um número: ");
			notas[i] = leia.nextDouble();
			ac = ac + notas[i];
		}
		System.out.println("Notas cadastradas: ");
		
		for (int i = 0; i < notas.length; i++) {
		System.out.println(notas[i]);
		}
		media = ac/notas.length;
		System.out.println("Média: " + media);
	}
}
