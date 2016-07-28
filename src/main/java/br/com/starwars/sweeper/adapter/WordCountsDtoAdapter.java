package br.com.starwars.sweeper.adapter;

import br.com.starwars.sweeper.dto.WordCountsDto;
import br.com.starwars.sweeper.model.entity.WordCounts;

@Adapter
public class WordCountsDtoAdapter implements GenericAdapter<WordCounts, WordCountsDto> {

	@Override
	public WordCountsDto adapt(final WordCounts type) {

		if (type != null) {

			WordCountsDto wordCountsDto = new WordCountsDto();

			wordCountsDto.setWord(type.getWord());
			wordCountsDto.setCount(type.getCount());

			return wordCountsDto;
		}
		return null;
	}
}
