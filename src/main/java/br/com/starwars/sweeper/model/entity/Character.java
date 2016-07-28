package br.com.starwars.sweeper.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "starwarsdb", name = "character")
public class Character {

	@Id
	@SequenceGenerator(name = "SEQ_CHARACTER", sequenceName = "SEQ_CHARACTER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHARACTER")
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "characters")
	private List<Setting> settings;

	@OrderBy("count DESC")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "character")
	private List<WordCounts> wordCounts;

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

	public List<Setting> getSettings() {
		return settings;
	}

	public void setSettings(final List<Setting> settings) {
		this.settings = settings;
	}

	public List<WordCounts> getWordCounts() {
		return wordCounts;
	}

	public void setWordCounts(final List<WordCounts> wordCounts) {
		this.wordCounts = wordCounts;
	}

}
