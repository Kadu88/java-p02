package br.com.carlosbarros.byteBank.controller;

import br.com.carlosbarros.byteBank.exception.ContaOperationsException;
import br.com.carlosbarros.byteBank.model.Conta;

public class CriaConta {

	public static void main(String[] args) {
		try {
			Conta primeiraConta = new Conta();
			primeiraConta.setSaldo(200);
			primeiraConta.depositar(100);
			
			Conta segundaConta = new Conta();
			segundaConta.setSaldo(50);
			segundaConta.depositar(500);
			segundaConta.retirar(400);
			segundaConta.retirar(300);
		} catch (ContaOperationsException coe) {
			System.out.println(coe.getMessage());
		}		
	}
}
