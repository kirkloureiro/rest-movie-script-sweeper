package br.com.starwars.sweeper.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.starwars.sweeper.dto.CharacterDto;
import br.com.starwars.sweeper.dto.SettingDto;
import br.com.starwars.sweeper.model.entity.Character;
import br.com.starwars.sweeper.model.entity.Setting;

@Adapter
public class SettingDtoAdapter implements GenericAdapter<Setting, SettingDto> {

	@Autowired
	private CharacterDtoAdapter characterDtoAdapter;

	@Override
	public SettingDto adapt(final Setting type) {

		if (type != null) {

			SettingDto settingDto = new SettingDto();

			settingDto.setId(type.getId());
			settingDto.setName(type.getName());

			if (type.getCharacters() != null) {
				List<CharacterDto> charactersDtoList = new ArrayList<>();
				for (Character character : type.getCharacters()) {
					charactersDtoList.add(characterDtoAdapter.adapt(character));
				}
				settingDto.setCharacters(charactersDtoList);
			}
			return settingDto;
		}
		return null;
	}
}
