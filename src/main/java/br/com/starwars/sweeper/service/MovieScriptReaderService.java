package br.com.starwars.sweeper.service;

import br.com.starwars.sweeper.exception.AbstractAppException;
import br.com.starwars.sweeper.exception.NoResultException;
import br.com.starwars.sweeper.exception.ScriptAlreadyReceivedException;

/**
 * Service Inteface for the class <code>MovieScriptReaderServiceImpl</code>
 * 
 * @author Bruno
 */
public interface MovieScriptReaderService {

	/**
	 * Receives the movie script in the text format text/plain; charset=utf8 and
	 * persists.
	 * 
	 * @param movieScriptText
	 * @return
	 * @throws ScriptAlreadyReceivedException
	 * @throws AbstractAppException
	 */
	public String postMovieScript(String movieScriptText) throws ScriptAlreadyReceivedException, AbstractAppException;

	/**
	 * Returns information about all the movie settings. The response includes
	 * the name of the settings, the list of characters that appeared in each
	 * setting, and the ten top dialogue word counts for each character,
	 * considering dialogues in all settings, in descending order by count.
	 * 
	 * @return
	 * @throws AbstractAppException
	 */
	public String getMovieSettings() throws AbstractAppException;

	/**
	 * Returns information about the movie setting with the given id, if one
	 * exists. The response includes the name, the list of characters that
	 * appeared in the setting, and the ten top dialogue word counts for each
	 * character, considering dialogues in all settings, in descending order by
	 * count.
	 * 
	 * @param settingsId
	 * @return
	 * @throws NoResultException
	 * @throws AbstractAppException
	 */
	public String getMovieSettingsById(String settingsId) throws NoResultException, AbstractAppException;

	/**
	 * Returns information about all the movie characters. The response includes
	 * the name of the characters and the ten top dialogue word counts for each
	 * character, in descending order by count.
	 * 
	 * @return
	 * @throws AbstractAppException
	 */
	public String getMovieCharacters() throws AbstractAppException;

	/**
	 * Returns information about the movie character with the given id, if one
	 * exists. The response includes the name and the ten top dialogue word
	 * counts for the character.
	 * 
	 * @param id
	 * @return
	 * @throws NoResultException
	 * @throws AbstractAppException
	 */
	public String getMovieCharactersById(String id) throws NoResultException, AbstractAppException;
}
