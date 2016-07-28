package br.com.starwars.sweeper.exception;

public class InfrastructureException extends AbstractAppException {

	private static final long serialVersionUID = 6602150394538151356L;

	public InfrastructureException() {
		super();
	}

	public InfrastructureException(final String message) {
		super(message);
	}

	public InfrastructureException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InfrastructureException(final Throwable cause) {
		super(cause);
	}
}
