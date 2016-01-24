//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Mew.java
package Pokedex;

public class Mew extends Pokemon {
	
	//Constructor
	public Mew() {
		super("Mew", 45, 101, "NORMAL");
		addMove("Pound");
		addMove("Secret Power");
		addMove("Mega Punch");
		addMove("Hyper Beam");
	}
	
	//Constructor for trainers
	public Mew( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Mew";
	}
	
}