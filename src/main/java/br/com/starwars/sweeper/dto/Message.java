package br.com.starwars.sweeper.dto;

public class Message {

	private String message;

	public Message() {
		super();
	}

	public Message(final String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}
}
