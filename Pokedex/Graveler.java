//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Graveler.java
package Pokedex;

public class Graveler extends Geodude {
	
	//Constructor
    public Graveler() {
		super("Graveler", 25, 44);
		addMove("Rock Blast");
	}
	
	//Constructor for evolutions
	public Graveler( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Rock Blast");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}