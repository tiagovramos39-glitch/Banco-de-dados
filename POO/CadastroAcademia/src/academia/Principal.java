package academia;

public class Principal {

	public static void main(String[] args) {
		AlunoAcademia aluno1 = new AlunoAcademia("Ana", 17, 60, 1.65);
		AlunoAcademia aluno2 = new AlunoAcademia("Bruno", 25, 80, 1.80);
		
		
		aluno1.exibirDados();
		aluno2.exibirDados();
		
		aluno2.setPeso(78);
		
		System.out.printf("Novo IMC de Bruno: %.2f", aluno2.calcularIMC());
	}

}
