//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pikachu.java
package Pokedex;

public class Pikachu extends Pichu{
	
	//Constructor
    public Pikachu() {
		super("Pikachu", 16, 36);
		addMove("Thunderbolt");
	}
	
	//Constructor for trainers
	public Pikachu( int lvl ) {
		this();
		level = lvl;
	}
	//Constructor for evolutions
	public Pikachu( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Thunderbolt");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}