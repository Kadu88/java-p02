package br.com.carlosbarros.byteBank.exception;

public class SaldoInsuficienteException extends ContaOperationsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9183580656450836340L;

	public SaldoInsuficienteException() {
		super();
	}
	public SaldoInsuficienteException(String message) {
		super(message);
	}
}
