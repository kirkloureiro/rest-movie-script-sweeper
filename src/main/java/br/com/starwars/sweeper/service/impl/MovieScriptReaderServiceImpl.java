package br.com.starwars.sweeper.service.impl;

import static br.com.starwars.sweeper.util.JsonParserUtil.parseObjectToJson;
import static br.com.starwars.sweeper.util.RegexMatcherUtil.getCharacterName;
import static br.com.starwars.sweeper.util.RegexMatcherUtil.getSettingsDescription;
import static br.com.starwars.sweeper.util.RegexMatcherUtil.getWordsFromLine;
import static br.com.starwars.sweeper.util.RegexMatcherUtil.isCharacter;
import static br.com.starwars.sweeper.util.RegexMatcherUtil.isSettings;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.starwars.sweeper.adapter.CharacterDtoAdapter;
import br.com.starwars.sweeper.adapter.SettingDtoAdapter;
import br.com.starwars.sweeper.dao.CharacterDao;
import br.com.starwars.sweeper.dao.ScriptDao;
import br.com.starwars.sweeper.dao.SettingDao;
import br.com.starwars.sweeper.dao.WordCountsDao;
import br.com.starwars.sweeper.dto.CharacterDto;
import br.com.starwars.sweeper.dto.Message;
import br.com.starwars.sweeper.dto.SettingDto;
import br.com.starwars.sweeper.exception.AbstractAppException;
import br.com.starwars.sweeper.exception.InfrastructureException;
import br.com.starwars.sweeper.exception.NoResultException;
import br.com.starwars.sweeper.exception.ScriptAlreadyReceivedException;
import br.com.starwars.sweeper.model.entity.Character;
import br.com.starwars.sweeper.model.entity.Script;
import br.com.starwars.sweeper.model.entity.Setting;
import br.com.starwars.sweeper.model.entity.WordCounts;
import br.com.starwars.sweeper.service.MovieScriptReaderService;
import br.com.starwars.sweeper.util.RegexMatcherUtil;

@Service
public class MovieScriptReaderServiceImpl implements MovieScriptReaderService {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CharacterDao characterDao;

	@Autowired
	private ScriptDao scriptDao;

	@Autowired
	private SettingDao settingDao;

	@Autowired
	private WordCountsDao wordCountsDao;

	@Autowired
	private SettingDtoAdapter settingDtoAdapter;

	@Autowired
	private CharacterDtoAdapter characterDtoAdapter;

	@Override
	@Transactional
	public String postMovieScript(final String movieScriptText)
			throws ScriptAlreadyReceivedException, AbstractAppException {

		try {

			assertScriptNotExists();

			Script script = new Script();
			script.setText(movieScriptText);
			script = scriptDao.update(script);

			persistDataFromScript(movieScriptText);

			return parseObjectToJson(new Message("Movie script successfully received"));

		} catch (ScriptAlreadyReceivedException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InfrastructureException("Unexpected Error", e);
		}
	}

	@Override
	@Transactional
	public String getMovieSettings() throws AbstractAppException {

		try {
			List<Setting> resultList = settingDao.findAll();

			List<SettingDto> adaptedList = new ArrayList<>();
			for (Setting setting : resultList) {
				adaptedList.add(settingDtoAdapter.adapt(setting));
			}

			return parseObjectToJson(adaptedList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InfrastructureException("Unexpected Error", e);
		}
	}

	@Override
	@Transactional
	public String getMovieSettingsById(final String settingsId) throws NoResultException, AbstractAppException {

		try {
			Setting setting = settingDao.findEntityById(Long.valueOf(settingsId));

			assertNotNull(setting);

			SettingDto settingAdapted = settingDtoAdapter.adapt(setting);

			return parseObjectToJson(settingAdapted);

		} catch (NoResultException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InfrastructureException("Unexpected Error", e);
		}
	}

	@Override
	@Transactional
	public String getMovieCharacters() throws AbstractAppException {

		try {
			List<Character> resultList = characterDao.findAll();

			List<CharacterDto> adaptedList = new ArrayList<>();
			for (Character character : resultList) {
				adaptedList.add(characterDtoAdapter.adapt(character));
			}

			return parseObjectToJson(adaptedList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InfrastructureException("Unexpected Error", e);
		}
	}

	@Override
	@Transactional
	public String getMovieCharactersById(final String id) throws NoResultException, AbstractAppException {

		try {
			Character character = characterDao.findEntityById(Long.valueOf(id));

			assertNotNull(character);

			CharacterDto characterAdapted = characterDtoAdapter.adapt(character);

			return parseObjectToJson(characterAdapted);

		} catch (NoResultException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InfrastructureException("Unexpected Error", e);
		}
	}

	private <T> void assertNotNull(final T object) throws NoResultException {
		if (object == null) {
			throw new NoResultException(parseObjectToJson(new Message("Not found")));
		}
	}

	private void persistDataFromScript(final String movieScriptText) {

		String[] lines = movieScriptText.split("\\r?\\n", -1);

		Setting currentSetting = null;
		Character currentCharacter = null;

		for (int i = 0; i < lines.length; i++) {
			logger.info("# CURRENT LINE: " + i + " OF " + lines.length);
			String currentLine = lines[i];

			if (isSettings(currentLine)) {

				String settingsDescription = getSettingsDescription(currentLine);
				if (settingsDescription.isEmpty()) {
					continue;
				}

				Setting existentSetting = settingDao.findByName(settingsDescription);
				if (existentSetting != null) {
					currentSetting = existentSetting;
				} else {
					currentSetting = new Setting();
				}
				currentSetting.setName(settingsDescription);
				currentSetting = settingDao.update(currentSetting);
				continue;
			}

			if (isCharacter(currentLine)) {

				String characterName = getCharacterName(currentLine);

				Character existentCharacter = characterDao.findByName(characterName);

				if (existentCharacter != null) {
					currentCharacter = existentCharacter;
				} else {
					currentCharacter = new Character();
				}

				currentCharacter.setName(characterName);

				if (currentCharacter.getSettings() == null) {
					currentCharacter.setSettings(new ArrayList<>());
				}
				if (currentSetting.getCharacters() == null) {
					currentSetting.setCharacters(new ArrayList<>());
				}
				currentCharacter.getSettings().add(currentSetting);
				currentCharacter = characterDao.update(currentCharacter);
				currentSetting.getCharacters().add(currentCharacter);
				currentSetting = settingDao.update(currentSetting);
				continue;
			}

			if (RegexMatcherUtil.isDialog(currentLine) && currentCharacter != null) {

				List<WordCounts> wordsToPersistList = new ArrayList<>();

				for (WordCounts wordCounts : getWordsFromLine(currentLine)) {

					WordCounts existentWord = wordCountsDao.findWordCountByNameWord(wordCounts.getWord(),
							currentCharacter.getId());
					if (existentWord != null) {
						existentWord.setCount(existentWord.getCount().longValue() + 1);
						wordCounts = wordCountsDao.update(existentWord);
					} else {
						wordCounts.setCount(1L);
						wordCounts.setCharacter(currentCharacter);
						wordCounts = wordCountsDao.update(wordCounts);
						wordsToPersistList.add(wordCounts);
					}
				}
				currentCharacter.setWordCounts(wordsToPersistList);
				currentCharacter = characterDao.update(currentCharacter);
				continue;
			}
		}
	}

	private void assertScriptNotExists() throws ScriptAlreadyReceivedException {
		if (scriptDao.isNotEmptyTable()) {
			throw new ScriptAlreadyReceivedException(parseObjectToJson(new Message("Movie script already received")));
		}
	}
}
