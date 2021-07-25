package one.innovation.digital.api.execption;

public class EntidadeEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeEmUsoException(String message) {
		super(message);
	}

}
