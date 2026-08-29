package atividade;

import java.util.Scanner;

public class Exercicio8 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		double numero;
		
		System.out.println("Digite um número aí: ");
		numero = leia.nextDouble();
		while (numero > 0)  {
		
		
		System.out.println("Número: " + numero);
		System.out.println("Quadrado do núemro: " + numero*numero);
		System.out.println("Cubo do número: " + numero*numero*numero);
		System.out.println("Raíz quadrada do número: " + Math.sqrt(numero));
		System.out.println("Digite um número aí: ");
		numero = leia.nextDouble();
		} ;
		leia.close();
		
	}
}

