package br.com.carlosbarros.byteBank.exception;

public abstract class ContaOperationsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2531454459511612987L;
	private String message;
	
	public ContaOperationsException() {
	}
	
	public ContaOperationsException(String message) {
		this.setMessage(message);
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = "\n" + message + "\n";
	}
}