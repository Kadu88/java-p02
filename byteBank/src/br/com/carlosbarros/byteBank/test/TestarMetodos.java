package br.com.carlosbarros.byteBank.test;

import br.com.carlosbarros.byteBank.exception.ContaOperationsException;
import br.com.carlosbarros.byteBank.model.Cliente;
import br.com.carlosbarros.byteBank.model.Conta;;

public class TestarMetodos extends TestarGenerico {

	public static void main(String[] args) {
		
		try {
			testarConta();
			testarTransferencia();
			
		} catch (ContaOperationsException coe) {
			tratarException(coe);
		}
	}
	
	private static void testarConta() throws ContaOperationsException {
		Conta conta = new Conta();
		conta.depositar(100.00);
		conta.depositar(50.00);
		conta.retirar(20.00);
	}
	
	private static void testarTransferencia() throws ContaOperationsException {
		Cliente cliente_01 = new Cliente("Marcela");
		Cliente cliente_02 = new Cliente("Jorge");
		
		Conta conta_01 = new Conta(cliente_01, 1000.00);		
		Conta conta_02 = new Conta(cliente_02, 300.00);
		conta_01.transferir(500.00, conta_02);
	}
	
}
