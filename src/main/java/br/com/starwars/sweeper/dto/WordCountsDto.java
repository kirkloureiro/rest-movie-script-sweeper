package br.com.starwars.sweeper.dto;

public class WordCountsDto {

	private String word;
	private Long count;

	public String getWord() {
		return word;
	}

	public void setWord(final String word) {
		this.word = word;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(final Long count) {
		this.count = count;
	}
}
