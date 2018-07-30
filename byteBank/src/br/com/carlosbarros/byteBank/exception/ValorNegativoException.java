package br.com.carlosbarros.byteBank.exception;

public class ValorNegativoException extends ContaOperationsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2945135163618215996L;
	
	public ValorNegativoException() {
		super();
	}
	public ValorNegativoException(String message) {
		super(message);
	}
}
