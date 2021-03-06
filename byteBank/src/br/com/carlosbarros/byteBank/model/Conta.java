package br.com.carlosbarros.byteBank.model;

import br.com.carlosbarros.byteBank.exception.ContaOperationsException;
import br.com.carlosbarros.byteBank.exception.SaldoInsuficienteException;
import br.com.carlosbarros.byteBank.exception.ValorNegativoException;

public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	
	public static int numeroContaGeral = 0;
	
	public Conta() {
		this(criaCliente("Desconhecido", "222.222.222-22", "Profiss�o desconhecida"));
	}
	
	public Conta(Cliente titular) {
		this(titular, 0.0);
	}

	public Conta(Cliente titular, double saldoInicial) {
		this(titular, saldoInicial, 4092, 0);
	}

	public Conta(Cliente titular, double saldo, int agencia, int numeroConta) {
		this.titular = titular;
		this.saldo = saldo;
		this.agencia = agencia;
		this.numero = numeroConta == 0 ? ++numeroContaGeral : numeroConta;
		System.out.println("\nConta: " + this.titular.getNome() + " criada com sucesso. " +
			"\nCPF = " + titular.getCpf() + " Profiss�o= " + titular.getProfissao() +
			"\nAg�ncia = " + this.agencia + " Numero da Conta = " + this.numero +
				"\n\tSaldo inicial = R$" + this.saldo);

	}
	
	public static Cliente criaCliente(String nome, String cpf, String profissao) {
		return new Cliente(nome, cpf, profissao);
	}
	
	public void depositar(double valor) throws ContaOperationsException {
		System.out.println("\nRealizando a deposito na conta de " + this.titular.getNome());
		System.out.println("Saldo anterior: R$" + this.saldo);
		System.out.println("Valor depositado: R$" + valor);
		
		if(valor > 0) {
			this.saldo += valor;
			exibirSaldo();
		} else {
			throw new ValorNegativoException("N�o � poss�vel depositar valores negativos, "
					+ "opera��o n�o realizada");
		}
	}

	public void retirar(double valorRetirado) throws ContaOperationsException {
		System.out.println("\nRealizando a retirada da conta de " + this.titular.getNome());
		System.out.println("Saldo anterior: R$" + this.saldo);
		System.out.println("Valor retirado: R$" + valorRetirado);

		if (verificaSaldo(valorRetirado) && testarValorNegativo(valorRetirado)) {
			this.saldo -= valorRetirado;
			exibirSaldo();
		} else {
			System.out.println();
			throw new SaldoInsuficienteException("Saldo insuficiente, n�o � poss�vel retirar R$" +
					valorRetirado + " de R$"+ this.saldo + ". Opera��o n�o realizada");
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
			System.out.println("\t(Saldo suficiente para opera��o.)");
			saldoSuficiente = true;
		} else {
			System.out.println("\t(Saldo insuficiente para opera��o.)");
		}
		return saldoSuficiente;		
	}
	
	public void exibirSaldo() {
		if(this.titular != null && !this.titular.getNome().isEmpty()) {
			System.out.println("Conta de " + this.titular.getNome());
		}
		System.out.println("\tSaldo atual = R$" + this.saldo);
	}
	
	public boolean testarValorNegativo(double valorTestado) throws ValorNegativoException {
		boolean isValorOk = false;
		if(valorTestado > 0) {
			isValorOk = true;			
		} else {
			throw new ValorNegativoException("N�o � poss�vel realizar esta opera��o "
					+ "com valor negativo. \nOpera��o n�o realizada");
		}
		return isValorOk;
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
