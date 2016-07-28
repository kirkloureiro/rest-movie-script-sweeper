package br.com.starwars.sweeper.exception;

public abstract class AbstractAppException extends Exception {

	private static final long serialVersionUID = -1455721334075521906L;

	public AbstractAppException() {
		super();
	}

	public AbstractAppException(final String message) {
		super(message);
	}

	public AbstractAppException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AbstractAppException(final Throwable cause) {
		super(cause);
	}
}
