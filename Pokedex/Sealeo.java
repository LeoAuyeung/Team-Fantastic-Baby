//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Sealeo.java
package Pokedex;

public class Sealeo extends Spheal {
	
	//Constructor
    public Sealeo() {
		super("Sealeo", 32, 44);
		addMove("Ice Beam");
	}
	
	//Constructor for trainers
	public Sealeo( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Sealeo( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Ice Beam");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}