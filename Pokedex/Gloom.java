//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Gloom.java
package Pokedex;

public class Gloom extends Oddish {
	
	//Constructor
    public Gloom() {
		super("Gloom", 21, 36);
		addMove("Petal Dance");
	}
	
	//Constructor for evolutions
	public Gloom( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Petal Dance");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}