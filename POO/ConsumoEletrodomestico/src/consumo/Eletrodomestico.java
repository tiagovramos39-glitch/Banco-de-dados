package consumo;

public class Eletrodomestico {
	String nome;
	double potenciaWatts, horasPorDia;
	
	public Eletrodomestico(String nome, double potenciaWatts, double horasPorDia) {
		this.nome = nome;
		this.potenciaWatts = potenciaWatts;
		this.horasPorDia = horasPorDia;
	}

	public Eletrodomestico() {
		this.nome = "";
		this.potenciaWatts = 0;
		this.horasPorDia = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPotenciaWatts() {
		return potenciaWatts;
	}

	public void setPotenciaWatts(double potenciaWatts) {
		this.potenciaWatts = potenciaWatts;
	}

	public double getHorasPorDia() {
		return horasPorDia;
	}

	public void setHorasPorDia(double horasPorDia) {
		this.horasPorDia = horasPorDia;
	}
	
	public double consumoDiarioWh() {
		return potenciaWatts * horasPorDia;
	}
	
	public double consumoMensalWh() {
		return consumoDiarioWh() * 30;
	}
	
	public double consumoAnualWh() {
		return consumoMensalWh() * 12;
	}
	
	public double gastoMensal(double precoKwh) {
		return consumoMensalWh() / 1000 * precoKwh;
	}
	
	public void exibirRelatorio(double precoKwh) {
		System.out.printf("%s - %.0f W - %.1f h/dia%nDiario: %.0f Wh%nMensal: %.0f Wh (%.0f kWh)%nAnual: %.0f Wh (%.0f Kwh)%nTarifa: R$%.2f%nCusto: R$%.2f%n",
				nome, potenciaWatts, horasPorDia, consumoDiarioWh(), consumoMensalWh(), consumoMensalWh()/1000, consumoAnualWh(), consumoAnualWh()/ 1000, precoKwh, gastoMensal(precoKwh));
	}
	
	
	
	
}
