package br.com.carlosbarros.byteBank.test;

import br.com.carlosbarros.byteBank.exception.ContaOperationsException;
import br.com.carlosbarros.byteBank.model.Conta;;

public class TestaMetodos extends TestarGenerico {

	public static void main(String[] args) {
		
		try {
			testarConta();
			
		} catch (ContaOperationsException coe) {
			tratarException(coe);
		}
	}
	
	private static void testarConta() throws ContaOperationsException {
		Conta conta = new Conta();
		conta.depositar(100.00);
		conta.depositar(50.00);
	}
	
}
