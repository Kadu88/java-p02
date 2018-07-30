package br.com.carlosbarros.byteBank.model;

import br.com.carlosbarros.byteBank.exception.ContaOperationsException;
import br.com.carlosbarros.byteBank.exception.SaldoInsuficienteException;
import br.com.carlosbarros.byteBank.exception.ValorNegativoException;

public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	
	public Conta() {
		this("Anonymous");
	}
	
	public Conta(String titular) {
		this(titular, 0.0);
	}

	public Conta(String titular, double saldoInicial) {
		this.titular = new Cliente(titular, "119.921.007-21", "Analista de Sistemas");
		this.saldo = saldoInicial;
		System.out.println("\nConta: " + this.titular.getNome() + " criada com sucesso. " +
			"\n\tSaldo inicial = R$" + this.saldo);
	}
	
	public void depositar(double valor) throws ContaOperationsException {
		System.out.println("\nRealizando a deposito na conta de " + this.titular.getNome());
		System.out.println("Saldo anterior: R$" + this.saldo);
		System.out.println("Valor depositado: R$" + valor);
		
		if(valor > 0) {
			this.saldo += valor;
			exibirSaldo();
		} else {
			throw new ValorNegativoException("Não é possível depositar valores negativos, "
					+ "operação não realizada");
		}
	}

	public void retirar(double valorRetirado) throws ContaOperationsException {
		System.out.println("\nRealizando a retirada da conta de " + this.titular.getNome());
		System.out.println("Saldo anterior: R$" + this.saldo);
		System.out.println("Valor retirado: R$" + valorRetirado);

		if (verificaSaldo(valorRetirado)) {
			this.saldo -= valorRetirado;
			exibirSaldo();
		} else {
			System.out.println();
			throw new SaldoInsuficienteException("Saldo insuficiente, não é possível retirar R$" +
					valorRetirado + " de R$"+ this.saldo + ". Operação não realizada");
		}
	}
	
	public void transferir(double valor,Conta destino) throws ContaOperationsException {
		System.out.println("Tentando Transferir R$" + valor + " da conta de " + 
		this.titular.getNome() + " para conta de " + destino.getTitular().getNome());
		if(verificaSaldo(valor)) {
			System.out.println("\nTransferindo R$" + valor + " da conta de " +
			this.titular.getNome() + " para a conta de " + destino.getTitular().getNome());
			this.retirar(valor);
			destino.depositar(valor);
		}
	}
	
	public boolean verificaSaldo(double valorRetirado) {
		boolean saldoSuficiente = false;
		if(this.saldo >= valorRetirado) {
			System.out.println("\t(Saldo suficiente para operação.)");
			saldoSuficiente = true;
		} else {
			System.out.println("\t(Saldo insuficiente para operação.)");
		}
		return saldoSuficiente;		
	}
	
	public void exibirSaldo() {
		if(this.titular != null && !this.titular.getNome().isEmpty()) {
			System.out.println("Conta de " + this.titular.getNome());
		}
		System.out.println("\tSaldo atual = R$" + this.saldo);
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
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}	
}
