package br.com.starwars.sweeper.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "starwarsdb", name = "script")
public class Script {

	@Id
	@SequenceGenerator(name = "SEQ_SCRIPT", sequenceName = "SEQ_SCRIPT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCRIPT")
	@Column(name = "id")
	private Long id;

	@Lob
	@Column(name = "text")
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}
}
