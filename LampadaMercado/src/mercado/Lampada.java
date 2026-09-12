package mercado;

public class Lampada {
	
	private String marca;
	private int potencia, quantidade;
	private double preco;
	private boolean estaLigada;
	
	public Lampada() {
		
	}
	
	public Lampada(String marca, int potencia, int quantidade, double preco) {
		this.marca = marca;
		this.potencia = potencia;
		this.quantidade = quantidade;
		this.preco = preco;
		this.estaLigada = estaLigada;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void ligar() {
		estaLigada = true;
		System.out.println("A lâmpada " + marca + " ligou");
		System.out.println();
	}
	public void desligar() {
		estaLigada = false;
		System.out.println("A lâmpada " + marca + " desligou");
		System.out.println();
	}
	public void mostrarEstado() {
		System.out.println("Marca: " + marca);
		System.out.println("Potência: " + potencia);
		System.out.println("Quantidade: " + quantidade);
		System.out.println("Preço: R$" + preco);
		System.out.println((estaLigada ? "A lâmpada está ligada." : "A lâmpada está desligada"));
		System.out.println();
	}
	
	//{if (estaLigada == true) {
		//System.out.println("A lâmpada está ligada.");
	//} else {
		//System.out.println("A lâmpada está desligada");}

}