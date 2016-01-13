//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Player.java

public class Player {
	
	private final String gender, name;
	private int xCor, yCor, money, pokemonLeft, quest;
	private String direction;
	
	//Constructor
	public Player ( String g, String n ) {
		gender = g;
		name = n;
		//default values given to player
		setQuest(0);
		setMoney(5000);
		setDirection("RIGHT");
	}		
	
	//Mutators
	public void setX ( int x ) { xCor = x; }
	public void setY ( int y ) { yCor = y; }
	public void setMoney ( int m ) { money = m; }
	public void setPokemonLeft ( int l ) { pokemonLeft = l; }
	public void setQuest ( int q ) { quest = q; }
	public void setDirection ( String d ) { direction = d; }
	
	public boolean blackedOut() { return pokemonLeft > 0; }
	
	//Accessors
	public String getGender() { return gender; }
	public String getName() { return name; }
	public int getX() { return xCor; }
	public int getY() { return yCor; }
	public int getMoney() { return money; }
	public int getPokemonLeft() { return pokemonLeft; }
	public int getQuest() { return quest; }
	public String getDirection() { return direction; }
	
}
