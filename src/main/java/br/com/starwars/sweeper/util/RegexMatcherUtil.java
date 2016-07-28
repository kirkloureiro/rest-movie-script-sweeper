package br.com.starwars.sweeper.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.starwars.sweeper.model.entity.WordCounts;

public final class RegexMatcherUtil {

	private RegexMatcherUtil() {
		super();
	}

	public static boolean isSettings(final String line) {
		return line.matches("^(EXT. |INT. |INT./EXT. ).*$");
	}

	public static String getSettingsDescription(final String line) {

		Pattern pattern = Pattern.compile("EXT. (.*?) - ");

		if (line.contains(" - ")) {

			if (line.startsWith("INT. ")) {
				pattern = Pattern.compile("INT. (.*?) - ");
			} else if (line.startsWith("INT./EXT. ")) {
				pattern = Pattern.compile("INT./EXT. (.*?) - ");
			}

		} else {

			pattern = Pattern.compile("EXT. (.*?)");

			if (line.startsWith("INT. ")) {
				pattern = Pattern.compile("INT. (.*?)");
			} else if (line.startsWith("INT./EXT. ")) {
				pattern = Pattern.compile("INT./EXT. (.*?)");
			}
		}

		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return line;
	}

	public static boolean isCharacter(final String line) {
		return line.matches("\\s{22}[a-zA-Z0-9]*$");
	}

	public static String getCharacterName(final String line) {
		return line.trim();
	}

	public static boolean isDialog(final String line) {
		return line.matches("\\s{10}[a-zA-Z0-9\\s\\?\\.\\'\\!]*$") && !isCharacter(line);
	}

	public static List<WordCounts> getWordsFromLine(final String line) {

		String lineReplaced = line.replace(".", "").replace(",", "");

		String[] words = lineReplaced.split("\\s");

		List<WordCounts> wordsList = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (word != null && !word.isEmpty()) {
				WordCounts wordCounts = new WordCounts();
				wordCounts.setWord(word);
				wordsList.add(wordCounts);
			}
		}

		return wordsList;
	}
}
