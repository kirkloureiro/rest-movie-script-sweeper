package br.com.starwars.sweeper.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.starwars.sweeper.dao.SettingDao;
import br.com.starwars.sweeper.model.entity.Setting;

@Repository
public class SettingDaoImpl extends AbstractGenericDao<Setting, Long> implements SettingDao {

	@Override
	public Setting findByName(final String name) {

		try {
			String query = "SELECT * FROM STARWARSDB.SETTING WHERE UPPER(NAME) = :pName ";

			Query queryEntityManager = entityManager.createNativeQuery(query, Setting.class);

			queryEntityManager.setParameter("pName", name.toUpperCase());

			Setting singleResult = (Setting) queryEntityManager.getSingleResult();
			return singleResult;
		} catch (NoResultException e) {
			logger.debug(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
