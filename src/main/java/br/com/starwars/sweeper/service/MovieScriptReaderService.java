package br.com.starwars.sweeper.service;

import br.com.starwars.sweeper.exception.AbstractAppException;
import br.com.starwars.sweeper.exception.NoResultException;
import br.com.starwars.sweeper.exception.ScriptAlreadyReceivedException;

public interface MovieScriptReaderService {

	public String postMovieScript(String movieScriptText) throws ScriptAlreadyReceivedException, AbstractAppException;

	public String getMovieSettings() throws AbstractAppException;

	public String getMovieSettingsById(String settingsId) throws NoResultException, AbstractAppException;

	public String getMovieCharacters() throws AbstractAppException;

	public String getMovieCharactersById(String id) throws NoResultException, AbstractAppException;
}
