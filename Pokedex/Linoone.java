//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Linoone.java
package Pokedex;

public class Linoone extends Zigzagoon {
	
	//Constructor
    public Linoone() {
		super("Linoone", 20, 101);
		addMove("Take Down");
	}
	
	//Constructor for evolutions
	public Linoone( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Take Down");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}