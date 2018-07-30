package br.com.carlosbarros.byteBank.model;

import br.com.carlosbarros.byteBank.exception.ContaOperationsException;
import br.com.carlosbarros.byteBank.exception.SaldoInsuficienteException;
import br.com.carlosbarros.byteBank.exception.ValorNegativoException;

public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private String titular;
	
	
	public void depositar(double valor) throws ContaOperationsException {
		System.out.println("\nRealizando a deposito");
		System.out.println("Saldo anterior: R$" + this.saldo);
		System.out.println("Valor depositado: R$" + valor);
		
		if(valor > 0) {
			this.saldo += valor;
			System.out.println("Saldo da conta corrente: R$" + this.saldo);
		} else {
			throw new ValorNegativoException("Não é possível depositar valores negativos, "
					+ "operação não realizada");
		}
	}

	public void retirar(double valor) throws ContaOperationsException {
		System.out.println("\nRealizando a retirada");
		System.out.println("Saldo anterior: R$" + this.saldo);
		System.out.println("Valor retirado: R$" + valor);

		if (this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("Saldo da conta corrente: R$" + this.saldo);
		} else {
			System.out.println();
			throw new SaldoInsuficienteException("Saldo insuficiente, não é possível retirar R$" +
					valor + " de R$"+ this.saldo + ". Operação não realizada");
		}
	}
	
	public void transferir(Conta origem, Conta destino, double valor) {
		
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}	
}
