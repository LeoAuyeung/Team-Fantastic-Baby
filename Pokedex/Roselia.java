//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Roselia.java
package Pokedex;

public class Roselia extends Budew {
	
	//Constructor
    public Roselia() {
		super("Roselia", 16, 36);
		addMove("Petal Dance");
	}
	
	//Constructor for evolutions
	public Roselia( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Petal Dance");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}