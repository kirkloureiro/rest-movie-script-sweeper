package br.com.starwars.sweeper.dao;

import br.com.starwars.sweeper.model.entity.WordCounts;

public interface WordCountsDao extends GenericDao<WordCounts, Long> {

	public WordCounts findWordCountByNameWord(String word, Long idCharacter);
}
