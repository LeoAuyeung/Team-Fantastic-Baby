//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Trainer.java

public class Trainer {
	
	private String name;
	private int pokemonLeft;
	private int difficulty = 0;
	private boolean defeated = false;
	
	public Trainer ( String n, int d ) {
		name = n;
		difficulty = d;
	}
	
	public String getName() { return name; }
	public boolean getDefeated() { return defeated; }
	public boolean blackedOut() { return pokemonLeft == 0; }
	
}