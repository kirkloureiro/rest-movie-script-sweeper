package br.com.starwars.sweeper.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "starwarsdb", name = "word_counts", indexes = { @Index(name = "word_index", columnList = "word"),
		@Index(name = "character_id_index", columnList = "character_id") })
public class WordCounts {

	@Id
	@SequenceGenerator(name = "SEQ_WORDS_COUNTS", sequenceName = "SEQ_WORDS_COUNTS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WORDS_COUNTS")
	@Column(name = "id")
	private Long id;

	@Column(name = "word")
	private String word;

	@Column(name = "count")
	private Long count;

	@ManyToOne
	@JoinColumn(name = "character_id", referencedColumnName = "id")
	private Character character;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

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

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(final Character character) {
		this.character = character;
	}

}
