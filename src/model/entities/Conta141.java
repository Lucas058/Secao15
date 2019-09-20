package model.entities;

import model.exceptions.DomainExceptions;

public class Conta141 {

	private int numero;
	private String nome;
	private double saldo;
	private double limiteSaque;

	public Conta141(int numero, String nome, double saldo, double limiteSaque) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public double doposito(double quantidade) {
		return saldo += quantidade;
	}

	public double saque(double quantidade) {
		if (quantidade > limiteSaque) {
			throw new DomainExceptions("Quantia excedeu o limite de saque!");
		}
		if (quantidade > saldo) {
			throw new DomainExceptions("Saldo insuficiente.");
		}
		return saldo -= quantidade;
	}

	public String toString() {
		return String.format("%.2f", saldo);
	}
}
