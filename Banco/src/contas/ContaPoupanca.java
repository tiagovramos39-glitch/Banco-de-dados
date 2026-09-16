package contas;

public class ContaPoupanca extends ContaBancaria{
	int diaRendimento;
	public ContaPoupanca(String numeroConta, String nomeCliente, double saldo) {
		super(numeroConta, nomeCliente, saldo);
		this.diaRendimento = diaRendimento;
	}
	public int getDiaRendimento() {
		return diaRendimento;
	}
	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	
	public double calcularNovoSaldo(double taxaRendimento) {
		setSaldo(getSaldo() + (getSaldo() * (taxaRendimento/100)));
		return getSaldo();
	}
	
}