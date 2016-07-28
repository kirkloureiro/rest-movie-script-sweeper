package br.com.starwars.sweeper.dao;

import br.com.starwars.sweeper.model.entity.Setting;

public interface SettingDao extends GenericDao<Setting, Long> {

	public Setting findByName(String name);
}
