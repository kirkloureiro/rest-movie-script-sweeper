package br.com.starwars.sweeper.dto;

import java.util.List;

public class CharacterDto {

	private Long id;
	private String name;
	private List<WordCountsDto> wordCounts;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<WordCountsDto> getWordCounts() {
		return wordCounts;
	}

	public void setWordCounts(final List<WordCountsDto> wordCounts) {
		this.wordCounts = wordCounts;
	}
}
