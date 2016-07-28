package br.com.starwars.sweeper.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.starwars.sweeper.dao.CharacterDao;
import br.com.starwars.sweeper.model.entity.Character;

@Repository
public class CharacterDaoImpl extends AbstractGenericDao<Character, Long> implements CharacterDao {

	@Override
	public Character findByName(final String name) {

		try {
			String query = "SELECT * FROM STARWARSDB.CHARACTER WHERE UPPER(NAME) = :pName ";

			Query queryEntityManager = entityManager.createNativeQuery(query, Character.class);

			queryEntityManager.setParameter("pName", name.toUpperCase());

			Character singleResult = (Character) queryEntityManager.getSingleResult();
			return singleResult;
		} catch (NoResultException e) {
			logger.debug(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
