//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Registeel.java
package Pokedex;

public class Registeel extends Pokemon {
	
	//Constructor
	public Registeel() {
		super("Registeel", 35, 101, "STEEL");
		addMove("Metal Claw");
		addMove("Iron Head");
		addMove("Flash Cannon");
		addMove("Gyro Ball");
	}
	
	//Constructor for trainers
	public Registeel( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Registeel";
	}
	
}