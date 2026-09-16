package contas;

public class Principal {

	public static void main(String[] args) {
		ContaPoupanca c1 = new ContaPoupanca("175127", "Vante", 200.98);
		ContaEspecial c2 = new ContaEspecial("087372", "Arthur", 1456.53);
		
		c1.exibirDados();
		System.out.println("Valor total na conta após o depósito: " + c1.depositar(300));
		System.out.println("Valor total na conta após o saque: " + c1.sacar(60));
		c1.calcularNovoSaldo(10.0);
		System.out.println();
		c2.exibirDados();
		System.out.println("Valor total na conta após o depósito: " + c2.depositar(70));
		System.out.println("Valor total na conta após o saque: " + c2.sacar(180));
	}
}