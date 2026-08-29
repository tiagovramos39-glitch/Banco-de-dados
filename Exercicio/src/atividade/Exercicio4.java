package atividade;

import java.util.Scanner;

public class Exercicio4 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int numero, auto = 2;
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(auto + " x " + i + " = " + auto*i);}
		
		do {
		System.out.print("Digite um número para ver a tabuada: ");
		numero = leia.nextInt(); 
		} while (numero <0);
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + " x " + i + " = " + numero*i);
			
			leia.close();
		}
		
	}
}