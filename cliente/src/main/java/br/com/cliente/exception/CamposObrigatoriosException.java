package br.com.cliente.exception;

public class CamposObrigatoriosException extends Exception {

	private static final long serialVersionUID = 1L;

	public CamposObrigatoriosException(String message) {
		super(message);
	}
}
