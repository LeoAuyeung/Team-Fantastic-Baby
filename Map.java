//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Map.java

public class Map {
	
    private static Tile[][] map = new Tile[20][20];
	
    //default constructor for map
    public Map(int n) {
	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile();
	    }
	}
	if( n == 1) {
	    map1();
	}
	else if( n == 2) {
	    map2();
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
	set(1,0, new Tile("|"));
	set(1,1, new Tile("House"));
	set(1,2, new Tile("|"));
	set(2,0, new Tile("|"));
	set(2,1, new Tile("_"));
	set(2,2, new Tile("|"));
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
	if( Player.getFromMap() == 2 ) {
	    Player.setY( 16 );
	    Player.setX( 19 );
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();
    }

    public static void map2() {
	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile( "Grass" );
	    }
	}
	line( 15, 0, 15, 13, "R" );
	line( 16, 0, 16, 13, "R" );
	line( 0, 14, 16, 14, "R" );
	line( 0, 15, 16, 15, "R" );
	set(5,0, new Tile("/"));
	set(5,1, new Tile("-"));
	set(5,2, new Tile("\\"));
	set(6,0, new Tile("|"));
	set(6,1, new Tile("House"));
	set(6,2, new Tile("|"));
	set(7,0, new Tile("|"));
	set(7,1, new Tile("_"));
	set(7,2, new Tile("|"));
	
	set(12,9, new Tile("/"));
	set(12,10, new Tile("-"));
	set(12,11, new Tile("-"));
	set(12,12, new Tile("-"));
	set(12,13, new Tile("\\"));
	set(13,9, new Tile("|"));
	set(13,10, new Tile("Pokecenter"));
	set(13,11, new Tile());    
	set(13,12, new Tile());
	set(13,13, new Tile("|"));
	set(14,9, new Tile("|"));
	set(14,10, new Tile("_"));
	set(14,11, new Tile("PKCenter"));
	set(14,12, new Tile("_"));
	set(14,13, new Tile("|"));
	set(16,0, new Tile("BackPortal"));
	set(0,15, new Tile("ForwardPortal"));
	if( Player.getFromMap() == 1 ) {
	    Player.setY(16);
	    Player.setX(0);
	    Player.setFromMap( Player.getMapNum() );
	}
	else if( Player.getFromMap() == 3 ) {
	    Player.setY(0);
	    Player.setX(15);
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();	
    }
	
	
}//ends Map.java

