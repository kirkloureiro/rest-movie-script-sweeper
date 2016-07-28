package br.com.starwars.sweeper.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "starwarsdb", name = "setting")
public class Setting {

	@Id
	@SequenceGenerator(name = "SEQ_SETTING", sequenceName = "SEQ_SETTING", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SETTING")
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(schema = "starwarsdb", name = "settings_has_characters", joinColumns = {
			@JoinColumn(name = "setting_id") }, inverseJoinColumns = { @JoinColumn(name = "character_id") })
	private List<Character> characters;

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

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(final List<Character> characters) {
		this.characters = characters;
	}

}
