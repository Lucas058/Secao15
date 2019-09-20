package aplicacao;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta141;
import model.exceptions.DomainExceptions;

public class Programa141 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
		System.out.println("Dados da conta:");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		String nome = sc.next();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		
		Conta141 conta = new Conta141(numero, nome, saldo, limiteSaque);
		
		System.out.println();
		System.out.print("Quantidade para saque: ");
		double quantidade = sc.nextDouble();
		conta.saque(quantidade);
		
		System.out.println("Saldo: " + conta);
		}
		catch(DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}

}
