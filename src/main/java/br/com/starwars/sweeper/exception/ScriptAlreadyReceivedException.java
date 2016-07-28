package br.com.starwars.sweeper.exception;

public class ScriptAlreadyReceivedException extends AbstractAppException {

	private static final long serialVersionUID = 1L;

	public ScriptAlreadyReceivedException() {
		super();
	}

	public ScriptAlreadyReceivedException(final String message) {
		super(message);
	}

	public ScriptAlreadyReceivedException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ScriptAlreadyReceivedException(final Throwable cause) {
		super(cause);
	}
}
