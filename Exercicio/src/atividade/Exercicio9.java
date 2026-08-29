package atividade;

public class Exercicio9 {
	public static void main(String[] args) {
		double carlos = 3000, joao = 1000;
		int mes = 0;
		
		
		
		while (carlos > joao) {
			
			carlos = 1.02 * carlos;
			joao = 1.05 * joao;
			mes++;
		}
		System.out.println("Vão levar " + mes + " meses");
		System.out.println("Carlos acumulou: " + carlos);
		System.out.println("João acumulou: " + joao);
		
	}
}
