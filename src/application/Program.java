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
			System.out.println("Qual seu tipo de conta?: (1)Conta normal (2)Conta Salário (3)Conta Poupança");
			int escolha = read.nextInt();

			if (escolha == 1) {
				System.out.println("Digite os dados do usuário da conta:");
				System.out.print("Número da conta:");
				int numero_Usuario = read.nextInt();
				System.out.print("Nome usuário");
				String nome_Usuario = read.next();
				// Não li o saldo pois o usuário não pode mudar o saldo livremente
				conta.add(new Conta(numero_Usuario, nome_Usuario, 0.0));
			} else if (escolha == 2) {
				System.out.println("Digite os dados do usuário da conta:");
				System.out.print("Número da conta:");
				int numero_Usuario = read.nextInt();
				System.out.print("Nome usuário");
				String nome_Usuario = read.next();
				// Não li o saldo pois o usuário não pode mudar o saldo livremente
				conta.add(new ContaSalario(numero_Usuario, nome_Usuario, 0.0, 5.00));
			} else if (escolha == 3) {
				System.out.println("Digite os dados do usuário da conta:");
				System.out.print("Número da conta:");
				int numero_Usuario = read.nextInt();
				System.out.print("Nome usuário");
				String nome_Usuario = read.next();
				// Não li o saldo pois o usuário não pode mudar o saldo livremente
				conta.add(new ContaPoupanca(numero_Usuario, nome_Usuario, 0.0, 10.00));
			}
		}

		System.out.println("=========================================\n\n");

		for (Conta x : conta) {
			System.out.println(x + "\n"); // Imprime os dados da conta antes dos depósitos
		}

		System.out.println("Digite o número da conta que deseja fazer uma operação:");
		int n_conta = read.nextInt();
		Conta pesquisa_Conta = conta.stream().filter(x -> x.getNumero_conta() == n_conta).findFirst().orElse(null);

		if (pesquisa_Conta == null) {
			System.out.println("Número de conta não encontrado!");
		} else {
			System.out.println("Qual seu tipo de conta?: (1)Conta normal (2)Conta Salário (3)Conta Poupança");
			int escolha = read.nextInt();
			System.out.println("Digite qual operação quer fazer: (1)depósito (2) saque");
			int op = read.nextInt();
			if (op == 1) {
				if (escolha == 1) {
					System.out.println("Digite o valor do depósito:");
					double valor = read.nextDouble();
					pesquisa_Conta.deposito(valor);
				} else if (escolha == 2) {

					System.out.println("Digite o valor do depósito:");
					double valor1 = read.nextDouble();
					((ContaSalario) pesquisa_Conta)
							.depositoS(valor1); /*
												 * Coloquei um casting para acessar o método da classe Conta Poupança
												 */
				} else if (escolha == 3) {
					System.out.println("Digite o valor do depósito:");
					double valor2 = read.nextDouble();
					((ContaPoupanca) pesquisa_Conta)
							.depositoP(valor2);/*
												 * Coloquei um casting para acessar o método da classe Conta Poupança
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
			System.out.println(x + "\n"); // Imprime os dados da depois do depósito
		}

		read.close();

	}

}
