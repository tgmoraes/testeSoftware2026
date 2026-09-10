package br.edu.ifsc;

public class CarroException extends RuntimeException{
	private final String mensagem;
	public CarroException (String msg) {
		this.mensagem = msg;
	}
	@Override
	public String getMessage() {
		return this.mensagem;
	}
}
