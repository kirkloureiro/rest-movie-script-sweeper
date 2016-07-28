package br.com.starwars.sweeper.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.starwars.sweeper.dao.WordCountsDao;
import br.com.starwars.sweeper.model.entity.WordCounts;

@Repository
public class WordCountsDaoImpl extends AbstractGenericDao<WordCounts, Long> implements WordCountsDao {

	@Override
	public WordCounts findWordCountByNameWord(final String word, final Long idCharacter) {

		try {
			String query = "SELECT * FROM STARWARSDB.WORD_COUNTS WHERE UPPER(WORD) = :pWord and CHARACTER_ID = :pCharacterId";

			Query queryEntityManager = entityManager.createNativeQuery(query, WordCounts.class);

			queryEntityManager.setParameter("pWord", word.toUpperCase());
			queryEntityManager.setParameter("pCharacterId", idCharacter);

			WordCounts singleResult = (WordCounts) queryEntityManager.getSingleResult();
			return singleResult;
		} catch (NoResultException e) {
			logger.debug(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
