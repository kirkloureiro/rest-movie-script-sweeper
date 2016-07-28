package br.com.starwars.sweeper.adapter;

public interface GenericAdapter<FROM, TO> {

	public TO adapt(FROM type);
}
