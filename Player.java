//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Player.java

public class Player {
	
    private static String gender, name;
    private static int xCor, yCor, money, pokemonLeft, quest;
    private static String direction;
	
    //Constructor
    public Player ( String g, String n ) {
	gender = g;
	name = n;
	//default values given to player
	setQuest(0);
	setMoney(5000);
	setDirection("RIGHT");
	setX( 0 );
	setY( 0 );
    }		
	
    //Mutators
    public static void setX ( int x ) { xCor = x; }
    public static void setY ( int y ) { yCor = y; }
    public static void setMoney ( int m ) { money = m; }
    public static void setPokemonLeft ( int l ) { pokemonLeft = l; }
    public static void setQuest ( int q ) { quest = q; }
    public static void setDirection ( String d ) { direction = d; }
	
    public static boolean blackedOut() { return pokemonLeft > 0; }
	
    //Accessors
    public static String getGender() { return gender; }
    public static String getName() { return name; }
    public static int getX() { return xCor; }
    public static int getY() { return yCor; }
    public static int getMoney() { return money; }
    public static int getPokemonLeft() { return pokemonLeft; }
    public static int getQuest() { return quest; }
    public static String getDirection() { return direction; }
	
}
