//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Player.java

public class Player {
	
    private static String gender, name;
    private static int badges, money, mapNum, fromMap, xCor, yCor, pokemonLeft, RxCor, RyCor;
    private static String direction;
	
    //Constructor
    public Player ( String g, String n ) {
		gender = g;
		name = n;
		badges = 0;
		money = 5000;
		//Default map location
		mapNum = 6;
		fromMap = mapNum;
		direction = "RIGHT";
		xCor = 1;
		yCor = 3;
		RxCor = 11;  // Respawn location
		RyCor = 14;
	}		
	
    //Mutators
    public static void setX ( int x ) { xCor = x; }
    public static void setY ( int y ) { yCor = y; }
    public static void setRX ( int x ) { RxCor = x; }
    public static void setRY ( int y ) { RyCor = y; }   
    public static void setMoney ( int m ) { money = m; }
    public static void setPokemonLeft ( int l ) { pokemonLeft = l; }
	public static void setBadges ( int b ) { badges = b; }
    public static void setDirection ( String d ) { direction = d; }
    public static void setMapNum ( int n ) { mapNum = n; }
    public static void setFromMap ( int n ) { fromMap = n; }
    public static boolean blackedOut() { return pokemonLeft <= 0; }
	
    //Accessors
    public static String getGender() { return gender; }
    public static String getName() { return name; }
    public static int getX() { return xCor; }
    public static int getY() { return yCor; }
    public static int getRX() { return RxCor; }
    public static int getRY() { return RyCor; } 
    public static int getMoney() { return money; }
    public static int getPokemonLeft() { return pokemonLeft; }
    public static int getBadges() { return badges; }
    public static int getMapNum() { return mapNum; }
    public static int getFromMap() { return fromMap; }
    public static String getDirection() { return direction; }
	
}
