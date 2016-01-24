//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Metagross.java
package Pokedex;

public class Metagross extends Metang {
	
	//Constructor
    public Metagross() {
		super("Metagross", 45, 101, 0);
		addMove("Metal Burst");
	}
	
	//Constructor for evolutions
	public Metagross( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Metal Burst");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}