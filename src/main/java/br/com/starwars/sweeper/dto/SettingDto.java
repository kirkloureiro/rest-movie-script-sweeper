package br.com.starwars.sweeper.dto;

import java.util.List;

public class SettingDto {

	private Long id;
	private String name;
	private List<CharacterDto> characters;

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

	public List<CharacterDto> getCharacters() {
		return characters;
	}

	public void setCharacters(final List<CharacterDto> characters) {
		this.characters = characters;
	}
}
