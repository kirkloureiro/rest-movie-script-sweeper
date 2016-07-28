package br.com.starwars.sweeper.dao;

import br.com.starwars.sweeper.model.entity.Script;

public interface ScriptDao extends GenericDao<Script, Long> {

	public boolean isNotEmptyTable();
}
