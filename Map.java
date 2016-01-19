//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Map.java

public class Map {
	
    private static Tile[][] map = new Tile[20][20];
	
    //default constructor for map
    public Map(int n) {
	if( n == 1) {
	    map1();
	}
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

    // precon = r1 < r2 or c1 < c2
    public static void line( int r1, int c1, int r2, int c2, String s ) {
	if( r1 == r2 ) { // horizontal line
	    for( int column = c1; column <= c2; column++ ) {
		set( r1, column, new Tile(s) );
	    }
	}
	else if( c1 == c2 ) {
	    for( int row = r1; row <= r2; row++ ) {
		set( row, c1, new Tile(s) );
	    }
	}
    }
	

    //===========================MAP COLLECTION==================================

    public static void map1() {
	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile( "Grass" );
	    }
	}
	set(0,0, new Tile("/"));
	set(0,1, new Tile("-"));
	set(0,2, new Tile("\\"));
	set(1,0, new Tile("Wall"));
	set(1,1, new Tile("Wall"));
	set(1,2, new Tile("Wall"));
	set(2,0, new Tile("Wall"));
	set(2,1, new Tile("Wall"));
	set(2,2, new Tile("Wall"));
	set(3,1, new Tile("R"));
	line( 4, 0, 4, 10, "R" );
	line( 5, 0, 5, 10, "R" );
	line( 6, 9, 16, 9, "R" );
	line( 6, 10, 16, 10, "R" );
	line( 15, 11, 15, 19, "R" );
	line( 16, 11, 16, 19, "R" );
	set( 16, 19, new Tile("ForwardPortal") );
	set( 11, 5, new Tile("Tree") );
	set( 3, 15, new Tile("Tree") );
	Player.setY( 3 );
	Player.setX( 1 );
	map[Player.getY()][Player.getX()].movePlayer();
    }
	
	
}//ends Map.java

