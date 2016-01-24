//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Arcanine.java
package Pokedex;

public class Arcanine extends Growlithe {
	
	//Constructor
    public Arcanine() {
		super("Arcanine", 16, 36);
		addMove("Flamethrower");
	}
	
	//Constructor for trainers
	public Arcanine( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Arcanine( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Flamethrower");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}