//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Charmander.java

public class Charmander extends Pokemon {
	
	//Constructor
	public Charmander() {
		super("Charmander", 100, 50, 50, 25, 5, "FIRE");
	}
	
	public Charmander( String nick ) {
		super(nick, 100, 50, 50, 25, 5, "FIRE");
	}
	
	public String about() {
		return "The fire on the tip of its tail is a measure of its life. " +
		"If healthy, its tail burns intensely.";
	}
	
}
