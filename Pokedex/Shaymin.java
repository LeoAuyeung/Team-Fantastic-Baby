//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Shaymin.java
package Pokedex;

public class Shaymin extends Pokemon {
	
	//Constructor
	public Shaymin() {
		super("Shaymin", 40, 101, "GRASS");
		addMove("Seed Bomb");
		addMove("Magical Leaf");
		addMove("Energy Ball");
		addMove("Seed Flare");
	}
	
	//Constructor for trainers
	public Shaymin( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Shaymin";
	}
	
}