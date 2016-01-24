//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Trainer.java

import java.util.ArrayList;

public class Trainer {
	
	private String name;
	private Pokemon[] _Pkmn;
	private int pokemonLeft, totalPokemon;
	private int difficulty = 1;
	
	//Constructor
	public Trainer ( String n, int d, String type ) {
		name = n;
		difficulty = d;
		_Pkmn = new Pokemon[difficulty];
		totalPokemon = difficulty;
		pokemonLeft = totalPokemon;
		givePokemon(difficulty, type);
	}
	
	//Mutators
	public void setPokemonLeft( int i ) { pokemonLeft = i; }
	
	//Accessors
	public String getName() { return name; }
	public int getDifficulty() { return difficulty; }
	public int getPokemonLeft() { return pokemonLeft; }
	public int getTotalPokemon() { return totalPokemon; }
	public boolean blackedOut() { return pokemonLeft == 0; }
	public Pokemon getPokemon( int n ) { return _Pkmn[n]; }
	
	//Populating a trainer's inventory with Pokemon
	public void givePokemon( int diff, String type ) {
		for (int i = 0; i < difficulty, i++) { _Pkmn[i] = give(diff, type); }
	}
	
	public Pokemon give( int diff, String type ) {
		Pokemon pkmn;
		//Level = (Difficulty * 10) - random lvl between 0-5
		int lvl = diff * 10 - (int)(Math.random() * 5);
		//Normal
		if ( type.equals("NORMAL") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 6);
			if ( random == 0 ) { pkmn = new Rattata (lvl); }
			else if ( random == 1 ) { pkmn = new Raticate (lvl); }
			else if ( random == 2 ) { pkmn = new Jigglypuff (lvl); }
			else if ( random == 3 ) { pkmn = new Wigglytuff (lvl); }
			else if ( random == 4 ) { pkmn = new Zigzagoon (lvl); }
			else if ( random == 5 ) { pkmn = new Linoone (lvl); }
		}
		//Fire
		else if ( type.equals("FIRE") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 6);
			if ( random == 0 ) { pkmn = new Vulpix (lvl); }
			else if ( random == 1 ) { pkmn = new Ninetales (lvl); }
			else if ( random == 2 ) { pkmn = new Growlithe (lvl); }
			else if ( random == 3 ) { pkmn = new Arcanine (lvl); }
			else if ( random == 4 ) { pkmn = new Ponyta (lvl); }
			else if ( random == 5 ) { pkmn = new Rapidash (lvl); }
		}
		//Water
		else if ( type.equals("WATER") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 6);
			if ( random == 0 ) { pkmn = new Psyduck (lvl); }
			else if ( random == 1 ) { pkmn = new Golduck (lvl); }
			else if ( random == 2 ) { pkmn = new Magikarp (lvl); }
			else if ( random == 3 ) { pkmn = new Gyarados (lvl); }
			else if ( random == 4 ) { pkmn = new Carvanha (lvl); }
			else if ( random == 5 ) { pkmn = new Sharpedo (lvl); }
		}
		//Electric
		else if ( type.equals("ELECTRIC") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 9);
			if ( random == 0 ) { pkmn = new Pichu (lvl); }
			else if ( random == 1 ) { pkmn = new Pikachu (lvl); }
			else if ( random == 2 ) { pkmn = new Raichu (lvl); }
			else if ( random == 3 ) { pkmn = new Magnemite (lvl); }
			else if ( random == 4 ) { pkmn = new Magneton (lvl); }
			else if ( random == 5 ) { pkmn = new Magnezone (lvl); }
			else if ( random == 6 ) { pkmn = new Elekid (lvl); }
			else if ( random == 7 ) { pkmn = new Electabuzz (lvl); }
			else if ( random == 8 ) { pkmn = new Electivire (lvl); }
		}
		//Grass
		else if ( type.equals("GRASS") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 6);
			if ( random == 0 ) { pkmn = new Oddish (lvl); }
			else if ( random == 1 ) { pkmn = new Gloom (lvl); }
			else if ( random == 2 ) { pkmn = new Vileplume (lvl); }
			else if ( random == 3 ) { pkmn = new Budew (lvl); }
			else if ( random == 4 ) { pkmn = new Roselia (lvl); }
			else if ( random == 5 ) { pkmn = new Roserade (lvl); }
		}
		//Ice
		else if ( type.equals("FIGHTING") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 5);
			if ( random == 0 ) { pkmn = new Snorunt (lvl); }
			else if ( random == 1 ) { pkmn = new Glalie (lvl); }
			else if ( random == 2 ) { pkmn = new Spheal (lvl); }
			else if ( random == 3 ) { pkmn = new Sealeo (lvl); }
			else if ( random == 4 ) { pkmn = new Walrein (lvl); }
		}
		//Fighting
		else if ( type.equals("FIGHTING") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 5);
			if ( random == 0 ) { pkmn = new Machop (lvl); }
			else if ( random == 1 ) { pkmn = new Machamp (lvl); }
			else if ( random == 2 ) { pkmn = new Machoke (lvl); }
			else if ( random == 3 ) { pkmn = new Riolu (lvl); }
			else if ( random == 4 ) { pkmn = new Lucario (lvl); }
		}
		//Flying
		else if ( type.equals("FLYING") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 5);
			if ( random == 0 ) { pkmn = new Spearow (lvl); }
			else if ( random == 1 ) { pkmn = new Fearow (lvl); }
			else if ( random == 2 ) { pkmn = new Zubat (lvl); }
			else if ( random == 3 ) { pkmn = new Golbat (lvl); }
			else if ( random == 4 ) { pkmn = new Crobat (lvl); }
		}
		//Rock
		else if ( type.equals("ROCK") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 3);
			if ( random == 0 ) { pkmn = new Geodude (lvl); }
			else if ( random == 1 ) { pkmn = new Graveler (lvl); }
			else if ( random == 2 ) { pkmn = new Golem (lvl); }
		}
		//Dark
		else if ( type.equals("DARK") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 4);
			if ( random == 0 ) { pkmn = new Houndour (lvl); }
			else if ( random == 1 ) { pkmn = new Houndoom (lvl); }
			else if ( random == 2 ) { pkmn = new Poochyena (lvl); }
			else if ( random == 3 ) { pkmn = new Mightyena (lvl); }
		}
		//Steel
		else if ( type.equals("STEEL") ) {
			//Random = # of pokemon of given type in game (not including starters/legendaries)
			int random = (int)(Math.random() * 6);
			if ( random == 0 ) { pkmn = new Aron (lvl); }
			else if ( random == 1 ) { pkmn = new Lairon (lvl); }
			else if ( random == 2 ) { pkmn = new Aggron (lvl); }
			else if ( random == 3 ) { pkmn = new Beldum (lvl); }
			else if ( random == 4 ) { pkmn = new Metang (lvl); }
			else if ( random == 5 ) { pkmn = new Metagross (lvl); }
		}
	
}