package br.com.starwars.sweeper.dao;

import br.com.starwars.sweeper.model.entity.Character;

public interface CharacterDao extends GenericDao<Character, Long> {

	public Character findByName(String name);
}
