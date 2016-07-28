package br.com.starwars.sweeper.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.starwars.sweeper.dto.CharacterDto;
import br.com.starwars.sweeper.dto.WordCountsDto;
import br.com.starwars.sweeper.model.entity.Character;
import br.com.starwars.sweeper.model.entity.WordCounts;

@Adapter
public class CharacterDtoAdapter implements GenericAdapter<Character, CharacterDto> {

	@Autowired
	private WordCountsDtoAdapter wordCountsDtoAdapter;

	@Override
	public CharacterDto adapt(final Character type) {

		if (type != null) {

			CharacterDto characterDto = new CharacterDto();

			characterDto.setId(type.getId());
			characterDto.setName(type.getName());

			if (type.getWordCounts() != null) {
				List<WordCountsDto> wordsDto = new ArrayList<>();
				for (WordCounts wordCounts : type.getWordCounts()) {
					wordsDto.add(wordCountsDtoAdapter.adapt(wordCounts));
				}
				characterDto.setWordCounts(wordsDto);
			}
			return characterDto;
		}
		return null;
	}
}
