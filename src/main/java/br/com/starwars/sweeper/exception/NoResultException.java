package br.com.starwars.sweeper.exception;

public class NoResultException extends AbstractAppException {

	private static final long serialVersionUID = 7858028468072807743L;

	public NoResultException() {
		super();
	}

	public NoResultException(final String message) {
		super(message);
	}

	public NoResultException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NoResultException(final Throwable cause) {
		super(cause);
	}
}
