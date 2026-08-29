package atividade;

import java.util.Scanner;

public class ExercicioIf {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite um número inteiro: ");
		int numero = leia.nextInt();
		
		if (numero > 20) System.out.println(numero + " é maior que 20.");
		else System.out.println(numero + " não é maior que 20");
		
		System.out.println ("O número " + numero + (numero > 20 ? " é maior que ": " é menor que ") + 20);
		String resultado = numero > 20 ? "É maior que" : numero == 20 ? "É igual " : "É menor";
		System.out.println ("O número é " + numero + resultado + "20");
		
		leia.close();
		
	}
}