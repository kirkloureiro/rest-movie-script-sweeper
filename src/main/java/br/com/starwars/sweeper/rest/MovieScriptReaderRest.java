package br.com.starwars.sweeper.rest;

import javax.ws.rs.core.Response;

/**
 * 
 * @author Bruno Santos
 *
 */
public interface MovieScriptReaderRest {

	/***
	 * Receives the movie script in the text format text/plain; charset=utf8. If
	 * a movie script was already received before, it should respond with an
	 * error.
	 * 
	 * @param movieScriptText
	 * @return <code>Response</code>
	 */
	public Response postMovieScript(String movieScriptText);

	/**
	 * Returns information about all the movie settings. The response includes
	 * the name of the settings, the list of characters that appeared in each
	 * setting, and the ten top dialogue word counts for each character,
	 * considering dialogues in all settings, in descending order by count.
	 * 
	 * @return <code>Response</code>
	 */
	public Response getMovieSettings();

	/**
	 * Returns information about the movie setting with the given id, if one
	 * exists. The response includes the name, the list of characters that
	 * appeared in the setting, and the ten top dialogue word counts for each
	 * character, considering dialogues in all settings, in descending order by
	 * count.
	 * 
	 * @param settingsId
	 * @return <code>Response</code>
	 */
	public Response getMovieSettingsById(String settingsId);

	/**
	 * Returns information about all the movie characters. The response includes
	 * the name of the characters and the ten top dialogue word counts for each
	 * character, in descending order by count.
	 * 
	 * @return <code>Response</code>
	 */
	public Response getMovieCharacters();

	/**
	 * Returns information about the movie character with the given id, if one
	 * exists. The response includes the name and the ten top dialogue word
	 * counts for the character.
	 * 
	 * @param id
	 * @return <code>Response</code>
	 */
	public Response getMovieCharactersById(String id);
}
