//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Map.java

public class Map {
	
    private static Tile[][] map;
	
    //default constructor for map
    public Map() {
		//can alter size later
		map = new Tile[20][20];
		for ( int row = 0; row < map.length ; row++ ) {
			for ( int column = 0; column < map[row].length; column++ ) {
				map[row][column] = new Tile( "grass" );
			}
		}
		map[Player.getY()][Player.getX()].setIsPlayerHere(); //player's original position
		map[Player.getY()][Player.getX()].setImage();
	}
	
    //returns the size of the map
    public static int size() {
		return map.length;
	}
    
    //returns Tile at specified row & column   
    public static Tile get( int row, int column ) {
		return map[row][column];
	}
	
    //overwrite item at specified row and column with newData, returns old value
    public static Tile set( int row, int column, Tile newData ) {
		Tile temp = get(row,column);
		map[row][column] = newData;
		return temp;
	}
	
    //toString to return String representation of map
    public String toString() {
		String retVal = "";
		for ( int row = 0; row < map.length ; row++ ) {
			for ( int column = 0; column < map[row].length; column++ ) {
				retVal += map[row][column];
			}
			retVal += "\n";
		}
		return retVal;
	}
}//ends Map.java

