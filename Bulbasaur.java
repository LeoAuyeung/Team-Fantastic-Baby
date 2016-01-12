//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Bulbasaur.java
package Pokedex;

public class Bulbasaur extends Pokemon {
	
	//Constructor
	public Bulbasaur() {
		super("Bulbasaur", 100, 50, 50, 25, 5, "GRASS");
	}
	
	//Constructor with nickname
	public Bulbasaur( String nick ) {
		super(nick, 100, 50, 50, 25, 5, "GRASS");
	}
	
	//Pokedex description
	public String about() {
		return "Bulbasaur can be seen napping in bright sunlight. " + 
		"There is a seed on its back. " + 
		"By soaking up the sun's rays, the seed grows progressively larger.";
	}
	
}
