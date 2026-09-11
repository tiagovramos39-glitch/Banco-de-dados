package alunos;

public class Aluno {
	private String nome;
	private String curso;
	private double nota;
	
	public Aluno(String nome, String curso, double nota) {
		this.nome = nome;
		this.curso = curso;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public void verificarSituacao() {
		if (nota >= 7.0) {
			System.out.println("Aluno aprovado, vai curtir a vida!");
		} else {
			System.out.println("Reprovou, se lascou!");
		}
	}
	
	public void exibirDados() {
		System.out.println("Nome: " + nome);
		System.out.println("Curso: " + curso);
		System.out.println("Nota: " + nota);
	}
}