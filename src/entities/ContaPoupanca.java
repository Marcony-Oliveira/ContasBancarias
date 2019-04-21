package entities;

public class ContaPoupanca extends Conta {
	
	private Double bonusPorDeposito;
	
	public ContaPoupanca() {
	}

	public ContaPoupanca(Integer numero_conta, String nome_usuario, Double saldo, Double bonusPorDeposito) {
		super(numero_conta, nome_usuario, saldo);
		this.bonusPorDeposito = bonusPorDeposito;
	}

	public Double getBonusPorDeposito() {
		return bonusPorDeposito;
	}

	public void setBonusPorDeposito(Double bonusPorDeposito) {
		this.bonusPorDeposito = bonusPorDeposito;
	}
	
	
	public double depositoP(double valor) { //Método para depósito
		return saldo +=valor + bonusPorDeposito;
	}
	
	@Override
	public double saque(double valor) { //Método para saque
		return saldo -=valor;
	}

	@Override
	public String toString() {
		return "Conta Poupanca>> Bonus por deposito= " + bonusPorDeposito 
				+ "-- Numero conta= " + numero_conta
				+ "-- Nome= " + nome_usuario 
				+ "-- Saldo= " + saldo;
	}
	
	

}
