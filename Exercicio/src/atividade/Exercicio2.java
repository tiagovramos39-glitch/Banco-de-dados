package atividade;

import java.util.Scanner;

public class Exercicio2 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
	
		System.out.print("Digite a idade: ");
		int numero = leia.nextInt();
		
		if(numero < 5) {System.out.println("Nenhuma categoria");
		} else if (numero > 5 && numero <= 7) {System.out.println("Categoria: Infantil");
		} else if (numero > 7 && numero <= 10) {System.out.println("Categoria: juvenil");
		} else if (numero > 10 && numero <= 15) {System.out.println("Categoria: adolescente");
		} else if (numero > 15 && numero <= 30) {System.out.println("Categoria: adulto");
		} else if (numero > 30) {System.out.println("Categoria: sênior");}
		
		leia.close();
	}
	
}