//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Raichu.java
package Pokedex;

public class Raichu extends Pikachu {
	
	//Constructor
    public Raichu() {
		super("Raichu", 36, 101);
		addMove("Volt Tackle");
	}
	
	//Constructor for evolutions
	public Raichu( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Volt Tackle");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}