//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Regirock.java
package Pokedex;

public class Regirock extends Pokemon {
	
	//Constructor
	public Regirock() {
		super("Regirock", 35, 101, "ROCK");
		addMove("Rock Throw");
		addMove("Rock Tomb");
		addMove("Stone Edge");
		addMove("Ancient Power");
	}
	
	//Constructor for trainers
	public Regirock( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Regirock";
	}
	
}