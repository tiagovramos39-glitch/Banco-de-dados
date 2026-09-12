package mercado;

public class Principal {

	public static void main(String[] args) {
		Lampada l1 = new Lampada("Phillips", 16, 20, 11.13);
		Lampada l2 = new Lampada("Positivo", 32, 12, 18.9);
		
		l2.desligar();
		l2.ligar();
		l1.desligar();
		l1.ligar();
		l1.desligar();
		l1.mostrarEstado();
		l2.mostrarEstado();
		
	}
}