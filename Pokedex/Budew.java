//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Budew.java
package Pokedex;

public class Budew extends Pokemon {
	
	//Constructor
	public Budew() {
		super("Budew", 5, 16, "GRASS");
		addMove("Seed Bomb");
		addMove("Magical Leaf");
	}
	
	//Constructor for trainers
	public Budew( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Budew( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "GRASS");
		addMove("Seed Bomb");
		addMove("Magical Leaf");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}