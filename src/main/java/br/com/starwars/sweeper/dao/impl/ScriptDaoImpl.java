package br.com.starwars.sweeper.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.starwars.sweeper.dao.ScriptDao;
import br.com.starwars.sweeper.model.entity.Script;

@Repository
public class ScriptDaoImpl extends AbstractGenericDao<Script, Long> implements ScriptDao {

	@Override
	public boolean isNotEmptyTable() {
		Number count = (Number) entityManager.createNativeQuery("SELECT count(*) FROM STARWARSDB.SCRIPT")
				.getSingleResult();
		return count.longValue() > 0;
	}
}
