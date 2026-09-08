package academia;

public class AlunoAcademia {
	String nome;
	int idade;
	double peso, altura;

	public AlunoAcademia(String nome, int idade, double peso, double altura) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public boolean ehMenorDeIdade() {
		return idade < 18;
	}
	
	public double calcularIMC() {
		return peso / (altura * altura);
	}
	
	public void exibirDados() {
		System.out.printf("%s, %d anos, %.2f kg, %.2f m, IMC %.2f, desconto: %s%n",
				nome, idade, peso, altura, calcularIMC(), ehMenorDeIdade() ? "sim" : "não");
	}
}
