package entities;

public class ContaSalario extends Conta {
	
	private Double taxaPorDeposito;
	
    public ContaSalario() {
    }

	public ContaSalario(Integer numero_conta, String nome_usuario, Double saldo, Double taxaPorDeposito) {
		super(numero_conta, nome_usuario, saldo);
		this.taxaPorDeposito = taxaPorDeposito;
	}

	public Double getDesconto_Salario() {
		return taxaPorDeposito;
	}

	public void setDesconto_Salario(Double taxaPorDeposito) {
		this.taxaPorDeposito = taxaPorDeposito;
	}
    
	
	public double depositoS(double valor) { //Método para depósito
		return saldo +=valor - taxaPorDeposito;
	}
	
	@Override
	public double saque(double valor) { //Método para saque
		return saldo -=valor;
	}

    @Override
	public String toString() {
		return "Conta Salario>> TaxaPorDeposito= " + taxaPorDeposito 
				+ "-- Numero conta= " + numero_conta 
				+ "-- Nome= "+ nome_usuario 
				+ "-- Saldo= " + saldo;
	}

		
	
	

}
