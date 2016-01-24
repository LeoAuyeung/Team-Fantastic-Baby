//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Kyogre.java
package Pokedex;

public class Kyogre extends Pokemon {
	
	//Constructor
	public Kyogre() {
		super("Kyogre", 45, 101, "WATER");
		addMove("Water Pulse");
		addMove("Aqua Tail");
		addMove("Brine");
		addMove("Origin Pulse");
	}
	
	//Constructor for trainers
	public Kyogre( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Kyogre";
	}
	
}