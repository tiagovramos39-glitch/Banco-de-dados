package contas;

public class ContaEspecial extends ContaBancaria{
	double limiteCredito;
	public ContaEspecial(String numeroConta, String nomeCliente, double saldo) {
		super(numeroConta, nomeCliente, saldo);
		this.limiteCredito = limiteCredito;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	@Override
	public double sacar(double valor) {
		if (valor > 0 && valor < getSaldo() + limiteCredito) {
			setSaldo(getSaldo() - valor);
			return getSaldo();
		} else {
			return getSaldo();
		}
	}
}