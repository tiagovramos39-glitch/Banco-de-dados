package contas;

public class ContaBancaria {
	private String numeroConta, nomeCliente;
	private double saldo;
	
	public ContaBancaria (String numeroConta, String nomeCliente, double saldo) {
		this.numeroConta = numeroConta;
		this.nomeCliente = nomeCliente;
		if (saldo >= 0) {
			this.saldo = saldo;
		} else {
			System.out.println("Valor indefinido");
		}
		
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeClinte() {
		return nomeCliente;
	}

	public void setNomeClinte(String nomeClinte) {
		this.nomeCliente = nomeClinte;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		if (saldo >= 0) {
			this.saldo = saldo;
		}else {
			System.out.println("Valor indefinido");
		}
	}
	public double depositar(double valor) {
		if (valor > 0) {
			return saldo = valor + saldo;
		} else {
			return saldo;
		}
	}
	
	public double sacar(double valor) {
		if (valor > 0 && valor < saldo) {
			return saldo = saldo - valor;
		} else {
			return saldo;
		}
	}
	
	
	public void exibirDados(){
		System.out.println("Numero da conta: " + numeroConta);
		System.out.println("Nome do cliente: " + nomeCliente);
		System.out.println("Saldo: " + saldo);
		System.out.println();
	}
}