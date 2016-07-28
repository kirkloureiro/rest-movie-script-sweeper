package br.com.starwars.sweeper.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonParserUtil {

	private JsonParserUtil() {
		super();
	}

	public static <T> String parseObjectToJson(final T type) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(type);
	}

	public static <T> String parseObjectToJson(final List<T> type) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(type);
	}

	public static <T> T parseJsonToObject(final String stringJson, final Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(stringJson, clazz);
	}
}
