package entities;



public class Conta {
	
	protected Integer numero_conta;
	protected String nome_usuario;
	protected Double saldo;
	
	public Conta() { //Construtor padrão
	}

	public Conta(Integer numero_conta, String nome_usuario, Double saldo) { //Construtor
		super();
		this.numero_conta = numero_conta;
		this.nome_usuario = nome_usuario;
		this.saldo = saldo;
	}

	public Integer getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(Integer numero_conta) {
		this.numero_conta = numero_conta;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public double deposito(double valor) { //Método para depósito
		return saldo +=valor;
	}
	
	public double saque(double valor) { //Método para saque
		return saldo -=valor;
	}

	@Override
	public String toString() {
		return "Conta Normal >> Nº conta= " + numero_conta 
				+ "-- Nome= " + nome_usuario 
				+ "-- Saldo= " + saldo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
