package application;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import entities.Conta;
import entities.ContaPoupanca;
import entities.ContaSalario;

public class Program {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		List<Conta> conta = new ArrayList<>();

		System.out.println("Quantas contas quer cadastrar:");
		int qt = read.nextInt();

		for (int i = 1; i <= qt; i++) {
			System.out.println("Qual seu tipo de conta?: (1)Conta normal (2)Conta Sal�rio (3)Conta Poupan�a");
			int escolha = read.nextInt();

			if (escolha == 1) {
				System.out.println("Digite os dados do usu�rio da conta:");
				System.out.print("N�mero da conta:");
				int numero_Usuario = read.nextInt();
				System.out.print("Nome usu�rio");
				String nome_Usuario = read.next();
				// N�o li o saldo pois o usu�rio n�o pode mudar o saldo livremente
				conta.add(new Conta(numero_Usuario, nome_Usuario, 0.0));
			} else if (escolha == 2) {
				System.out.println("Digite os dados do usu�rio da conta:");
				System.out.print("N�mero da conta:");
				int numero_Usuario = read.nextInt();
				System.out.print("Nome usu�rio");
				String nome_Usuario = read.next();
				// N�o li o saldo pois o usu�rio n�o pode mudar o saldo livremente
				conta.add(new ContaSalario(numero_Usuario, nome_Usuario, 0.0, 5.00));
			} else if (escolha == 3) {
				System.out.println("Digite os dados do usu�rio da conta:");
				System.out.print("N�mero da conta:");
				int numero_Usuario = read.nextInt();
				System.out.print("Nome usu�rio");
				String nome_Usuario = read.next();
				// N�o li o saldo pois o usu�rio n�o pode mudar o saldo livremente
				conta.add(new ContaPoupanca(numero_Usuario, nome_Usuario, 0.0, 10.00));
			}
		}

		System.out.println("=========================================\n\n");

		for (Conta x : conta) {
			System.out.println(x + "\n"); // Imprime os dados da conta antes dos dep�sitos
		}

		System.out.println("Digite o n�mero da conta que deseja fazer uma opera��o:");
		int n_conta = read.nextInt();
		Conta pesquisa_Conta = conta.stream().filter(x -> x.getNumero_conta() == n_conta).findFirst().orElse(null);

		if (pesquisa_Conta == null) {
			System.out.println("N�mero de conta n�o encontrado!");
		} else {
			System.out.println("Qual seu tipo de conta?: (1)Conta normal (2)Conta Sal�rio (3)Conta Poupan�a");
			int escolha = read.nextInt();
			System.out.println("Digite qual opera��o quer fazer: (1)dep�sito (2) saque");
			int op = read.nextInt();
			if (op == 1) {
				if (escolha == 1) {
					System.out.println("Digite o valor do dep�sito:");
					double valor = read.nextDouble();
					pesquisa_Conta.deposito(valor);
				} else if (escolha == 2) {

					System.out.println("Digite o valor do dep�sito:");
					double valor1 = read.nextDouble();
					((ContaSalario) pesquisa_Conta)
							.depositoS(valor1); /*
												 * Coloquei um casting para acessar o m�todo da classe Conta Poupan�a
												 */
				} else if (escolha == 3) {
					System.out.println("Digite o valor do dep�sito:");
					double valor2 = read.nextDouble();
					((ContaPoupanca) pesquisa_Conta)
							.depositoP(valor2);/*
												 * Coloquei um casting para acessar o m�todo da classe Conta Poupan�a
												 */
				}
			} else {
				System.out.println("Digite o valor do saque:");
				double valor = read.nextDouble();
				pesquisa_Conta.saque(valor);

			}
		}
		
		System.out.println("Digite o valor do saque:");
		double valor = read.nextDouble();
		pesquisa_Conta.saque(valor);

		System.out.println("=========================================\n\n");

		for (Conta x : conta) {
			System.out.println(x + "\n"); // Imprime os dados da depois do dep�sito
		}

		read.close();

	}

}
