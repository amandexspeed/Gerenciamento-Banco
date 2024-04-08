package Utilitarios;

public class Excecao extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3991055320733077064L;

	public Excecao(String message) {
		super(message);
	}

	public Excecao(Throwable cause) {
		super(cause);
	}

	public Excecao(String message, Throwable cause) {
		super(message, cause);
	}

	public Excecao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}