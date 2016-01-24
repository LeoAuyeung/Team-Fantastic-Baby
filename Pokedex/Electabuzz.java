//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Electabuzz.java
package Pokedex;

public class Electabuzz extends Elekid {
	
	//Constructor
    public Electabuzz() {
		super("Electabuzz", 30, 45);
		addMove("Thunder Punch");
	}
	
	//Constructor for evolutions
	public Electabuzz( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Thunder Punch");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}