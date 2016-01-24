//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Gyarados.java
package Pokedex;

public class Gyarados extends Magikarp {
	
	//Constructor
    public Gyarados() {
		super("Gyarados", 20, 101);
		addMove("Aqua Tail");
	}
	
	//Constructor for evolutions
	public Gyarados( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Aqua Tail");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}