//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Regigigas.java
package Pokedex;

public class Regigigas extends Pokemon {
	
	//Constructor
	public Regigigas() {
		super("Regigigas", 60, 101, "NORMAL");
		addMove("Round");
		addMove("Dizzy Punch");
		addMove("Crush Grip");
		addMove("Giga Impact");
	}
	
	//Constructor for trainers
	public Regigigas( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Regigigas";
	}
	
}