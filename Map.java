//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Map.java

public class Map {
	
    private static Tile[][] map = new Tile[20][20];
    private static String name;
	
    //default constructor for map
    public Map(int n) {
	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile("Floor");
	    }
	}
	if( n == 1) {
	    map1();
	}
	else if( n == 2) {
	    map2();
	}
	else if( n == 3) {
	    map3();
	}
	else if( n == 4) {
	    map4();
	}
	else if( n == 5) {
	    map5();
	}
	else if( n == 6 ) {
	    map6();
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

    public static String getName() {
	return name;
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
    // creates a line of selected type of tile 
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
    } // ends line()

    // precon r is a row numb, t1 and t2 are types of tile, c1 and c2 are concentrations respectively
    // c1, c2 are ints between 0 ~ 100 inclusive
    public static void sprinkle( int r, String t1, int c1, String t2, int c2 ) {
	for( int c = 0; c < map.length; c++ ) {	    	
	    if( (int)( Math.random()*100) < c1 ) {
		set(r, c, new Tile(t1));
	    }
	    else if( (int)(Math.random()*100) < c2 ) {
		set(r, c, new Tile(t2));
	    }
	    else {
		set(r, c, new Tile("Floor"));
	    }
	}          
    }

    //===========================MAP COLLECTION==================================

    public static void map1() {                 //ASH VILLAGE=================================
	name = "ASH VILLAGE";

	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile( "line" );
	    }
	}
	line( 4, 0, 4, 10, "Floor" );
	line( 5, 0, 5, 10, "Floor" );
	line( 6, 9, 16, 9, "Floor" );
	line( 6, 10, 16, 10, "Floor" );
	line( 7, 11, 7, 18, "Floor" );
	line( 8, 11, 8, 18, "Floor" );	
	line( 15, 11, 15, 19, "Floor" );
	line( 16, 11, 16, 19, "Floor" );
	
	set(0,0, new Tile("/"));
	set(0,1, new Tile("-"));
	set(0,2, new Tile("\\"));
	set(1,0, new Tile("|"));
	set(1,1, new Tile("Floor"));      //house 1-1NW
	set(1,2, new Tile("|"));
	set(2,0, new Tile("|"));
	set(2,1, new Tile("[]"));
	set(2,2, new Tile("|"));
	set(3,1, new Tile("Floor"));

	set(3,16, new Tile("/"));
	set(3,17, new Tile("-"));
	set(3,18, new Tile("\\"));
	set(4,16, new Tile("|"));
	set(4,17, new Tile("Floor"));     //house 1-2 NE
	set(4,18, new Tile("|"));
	set(5,16, new Tile("|"));
	set(5,17, new Tile("[]"));
	set(5,18, new Tile("|"));
	set(6,17, new Tile("Floor"));

	set(6,3, new Tile("/"));
	set(6,4, new Tile("-"));
	set(6,5, new Tile("\\"));
	set(7,3, new Tile("|"));
	set(7,4, new Tile("Floor"));   //house1-3W
	set(7,5, new Tile("|"));
	set(8,3, new Tile("|"));
	set(8,4, new Tile("[]"));
	set(8,5, new Tile("|"));

	set(9,13, new Tile("/"));
	set(9,14, new Tile("-"));
	set(9,15, new Tile("\\"));
	set(10,13, new Tile("|"));
	set(10,14, new Tile("Floor"));    // house 1-4E
	set(10,15, new Tile("|"));
	set(11,13, new Tile("|"));
	set(11,14, new Tile("[]"));
	set(11,15, new Tile("|"));	
	
	set( 16, 19, new Tile("ForwardPortal") );
	set( 11, 5, new Tile("Tree") );
	set( 3, 15, new Tile("Tree") );
	
	if( Player.getFromMap() == 2 ) {
	    Player.setY( 16 );
	    Player.setX( 19 );
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();
    }// ends map1()

    public static void map2() {            //ROUTE 1 ==========================================
	name = "ROUTE 1";

	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile( "Grass" );
	    }
	}
	line( 15, 0, 15, 13, "Floor" );                    
	line( 16, 0, 16, 13, "Floor" );
	line( 0, 14, 16, 14, "Floor" );
	line( 0, 15, 16, 15, "Floor" );
	line( 4, 3, 14, 3, "Floor" );
	line( 4, 4, 14, 4, "Floor" );
	
	set(5,0, new Tile("/"));                    // House
	set(5,1, new Tile("-"));
	set(5,2, new Tile("\\"));
	set(6,0, new Tile("|"));
	set(6,1, new Tile("Floor"));   //house 2-1W
	set(6,2, new Tile("|"));
	set(7,0, new Tile("|"));
	set(7,1, new Tile("[]"));
	set(7,2, new Tile("|"));

	set(3,5, new Tile("/"));
	set(3,6, new Tile("-"));
	set(3,7, new Tile("\\"));
	set(4,5, new Tile("|"));
	set(4,6, new Tile("Floor"));   //house 2-2N
	set(4,7, new Tile("|"));
	set(5,5, new Tile("|"));
	set(5,6, new Tile("[]"));
	set(5,7, new Tile("|"));	
	
	set(12,9, new Tile("/"));                    // Pokecenter
	set(12,10, new Tile("-"));
	set(12,11, new Tile("-"));
	set(12,12, new Tile("-"));
	set(12,13, new Tile("\\"));
	set(13,9, new Tile("|"));
	set(13,10, new Tile("_"));
	set(13,11, new Tile("_"));    
	set(13,12, new Tile("_"));
	set(13,13, new Tile("|"));
	set(14,9, new Tile("|"));
	set(14,10, new Tile("_"));
	set(14,11, new Tile("PKCenter"));
	set(14,12, new Tile("_"));
	set(14,13, new Tile("|"));
	Player.setRY( 14 );
	Player.setRX( 11 );
	
	set(16,0, new Tile("BackPortal"));
	set(0,15, new Tile("ForwardPortal"));
	set(2,3, new Tile("Tree"));
	set(10,7, new Tile("Tree"));
	set(17,16, new Tile("Tree"));
	
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
    }// ends map2()

    public static void map3() {                // ROUTE 2 =====================================
	name = "ROUTE 2";

	sprinkle(0, "Rock", 70, "Grass", 5);
	sprinkle(1, "Rock", 70, "Grass", 5);	
	sprinkle(2, "Rock", 70, "Grass", 5);
	sprinkle(3, "Rock", 70, "Grass", 10);	
	sprinkle(4, "Rock", 70, "Grass", 10);
	sprinkle(5, "Rock", 65, "Grass", 15);
	sprinkle(6, "Rock", 60, "Grass", 20);
	sprinkle(7, "Rock", 50, "Grass", 30);	
	sprinkle(8, "Rock", 50, "Grass", 40);
	sprinkle(9, "Rock", 50, "Grass", 40);
	sprinkle(10, "Rock", 40, "Grass", 50);	
	sprinkle(11, "Rock", 40, "Grass", 50);
	sprinkle(12, "Rock", 30, "Grass", 50);
	sprinkle(13, "Rock", 20, "Grass", 60);	
	sprinkle(14, "Rock", 15, "Grass", 65);
	sprinkle(15, "Rock", 10, "Grass", 70);
	sprinkle(16, "Rock", 10, "Grass", 70);
	sprinkle(17, "Rock", 5, "Grass", 80);
	sprinkle(18, "Rock", 0, "Grass", 90);
	sprinkle(19, "Rock", 0, "Grass", 100);

	line( 4, 14, 19, 14, "Floor" );                    
	line( 4, 15, 19, 15, "Floor" );
	line( 4, 8, 4, 13, "Floor" );
	line( 5, 8, 5, 13, "Floor" );
	line( 6, 8, 17, 8, "Floor" );
	line( 6, 9, 17, 9, "Floor" );
    	line( 16, 1, 16, 7, "Floor" );
	line( 17, 1, 17, 7, "Floor" );
	line( 1, 1, 15, 1, "Floor" );
	line( 1, 2, 15, 2, "Floor" );
	
	set(9,5, new Tile("/\\"));                  // Tower
	set(10,4, new Tile("/"));
	set(10,5, new Tile("-"));              
	set(10,6, new Tile("\\"));
	set(11,4, new Tile("|"));
	set(11,5, new Tile("_"));
	set(11,6, new Tile("|"));	
	set(12,4, new Tile("|"));
	set(12,5, new Tile("_"));
	set(12,6, new Tile("|"));
	set(13,4, new Tile("|"));
	set(13,5, new Tile("_"));
	set(13,6, new Tile("|"));
	set(14,3, new Tile("[]"));
	set(14,4, new Tile("|"));
	set(14,5, new Tile("_"));
	set(14,6, new Tile("|"));
	set(14,7, new Tile("[]"));
	set(15,4, new Tile("[]"));
	set(15,5, new Tile("[]"));
	set(15,6, new Tile("[]"));

	set(0,0, new Tile("[]"));                 //Stone Entrance
	set(0,1, new Tile("Floor"));
	set(0,3, new Tile("Floor"));
	set(0,4, new Tile("[]"));
	set(0,5, new Tile("[]"));
	set(0,6, new Tile("[]"));
	set(0,7, new Tile("[]"));
	set(1,0, new Tile("[]"));
	set(1,3, new Tile("[]"));		
	set(1,4, new Tile("[]"));
	set(1,5, new Tile("[]"));
	set(1,6, new Tile("[]"));
	set(2,0, new Tile("[]"));		
	set(2,3, new Tile("[]"));
	set(2,4, new Tile("[]"));
	set(2,5, new Tile("[]"));
	set(3,0, new Tile("[]"));
	set(3,3, new Tile("[]"));

	set(0,2, new Tile("ForwardPortal"));
	set(19,15, new Tile("BackPortal"));
	
	if( Player.getFromMap() == 2 ) {
	    Player.setY(19);
	    Player.setX(15);
	    Player.setFromMap( Player.getMapNum() );
	}
	else if( Player.getFromMap() == 4 ) {
	    Player.setY(0);
	    Player.setX(2);
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();	
    }// ends map3()

    public static void map4() {  // ROCK TUNNEL ============================================
	name = "ROCK TUNNEL";

	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile("Cave");
	    }
	}

	set(19,2,new Tile("BackPortal"));
	set(0,14,new Tile("ForwardPortal") );
	
	if( Player.getFromMap() == 3 ) {
	    Player.setY(19);
	    Player.setX(2);
	    Player.setFromMap( Player.getMapNum() );
	}
	else if( Player.getFromMap() == 5 ) {
	    Player.setY(0);
	    Player.setX(14);
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();	    
    }// ends map4()

    public static void map5() { // ROCKY ROAD ================================================
	name = "ROCKY ROAD"; 

	sprinkle(19, "Rock", 30, "Grass", 100);
	sprinkle(18, "Rock", 30, "Grass", 100);	
	sprinkle(17, "Rock", 30, "Grass", 100);
	sprinkle(16, "Rock", 30, "Grass", 100);	
	sprinkle(15, "Rock", 30, "Grass", 100);
	sprinkle(14, "Rock", 30, "Grass", 100);
	sprinkle(13, "Rock", 30, "Grass", 100);
	sprinkle(12, "Rock", 30, "Grass", 100);	
	sprinkle(11, "Rock", 30, "Grass", 100);
	sprinkle(10, "Rock", 30, "Grass", 100);
	sprinkle(9, "Rock", 30, "Grass", 100);	
	sprinkle(8, "Rock", 30, "Grass", 100);
	sprinkle(7, "Rock", 30, "Grass", 100);
	sprinkle(6, "Rock", 30, "Grass", 100);	
	sprinkle(5, "Rock", 30, "Grass", 100);
	sprinkle(4, "Rock", 30, "Grass", 100);
	sprinkle(3, "Rock", 30, "Grass", 100);
	sprinkle(2, "Rock", 30, "Grass", 100);
	sprinkle(1, "Rock", 30, "Grass", 100);
	sprinkle(0, "Rock", 30, "Grass", 100);


	line( 13, 13, 19, 13, "Floor" );
	line( 13, 14, 19, 14, "Floor" );
	line( 12, 3, 12, 14, "Floor" );
	line( 11, 3, 11, 14, "Floor" );
	line( 0, 3, 10, 3, "Floor" );
	line( 0, 4, 10, 4, "Floor" );	
	line( 2, 5, 2, 12, "Floor" );
	line( 3, 5, 3, 12, "Floor" );
	line( 4, 12, 8, 12, "Floor" );
	line( 8, 13, 8, 16, "Floor" );
	line( 1, 16, 7, 16, "Floor" );

	set(19,9, new Tile("[]"));
	set(19,10, new Tile("[]"));
	set(19,11, new Tile("[]"));
	set(19,12, new Tile("[]"));	
	set(19,13, new Tile("Floor"));
	set(19,15, new Tile("Floor"));
	set(19,16, new Tile("[]"));
	set(19,17, new Tile("[]"));
	set(19,18, new Tile("[]"));
	set(18,10, new Tile("[]"));
	set(18,11, new Tile("[]"));
	set(18,12, new Tile("[]"));		
	set(18,15, new Tile("[]"));
	set(18,16, new Tile("[]"));
	set(18,17, new Tile("[]"));
	set(17,11, new Tile("[]"));		
	set(17,12, new Tile("[]"));
	set(17,15, new Tile("[]"));
	set(17,16, new Tile("[]"));
	set(16,12, new Tile("[]"));
	set(16,15, new Tile("[]"));

	set(0,7, new Tile("[]"));
	set(0,9, new Tile("[]"));
	set(0,12, new Tile("[]"));
	set(0,14, new Tile("[]"));
	set(0,18, new Tile("[]"));
	set(0,19, new Tile("[]"));		
	set(1,9, new Tile("[]"));
	set(1,10, new Tile("[]"));
	set(1,12, new Tile("[]"));
	set(1,13, new Tile("[]"));		
	set(1,15, new Tile("[]"));
	set(1,17, new Tile("[]"));
	set(1,19, new Tile("[]"));
	set(2,10, new Tile("[]"));
	set(2,11, new Tile("[]"));
	set(2,12, new Tile("[]"));
	set(2,14, new Tile("[]"));
	set(2,15, new Tile("[]"));
	set(2,17, new Tile("[]"));		
	set(2,18, new Tile("[]"));
	set(3,13, new Tile("[]"));
	set(3,14, new Tile("[]"));
	set(3,15, new Tile("[]"));		
	set(3,17, new Tile("[]"));
	set(3,18, new Tile("[]"));
	set(3,19, new Tile("[]"));
	set(4,8, new Tile("[]"));
	set(4,9, new Tile("[]"));
	set(4,10, new Tile("[]"));
	set(4,11, new Tile("[]"));
	set(4,13, new Tile("[]"));
	set(4,15, new Tile("[]"));		
	set(4,19, new Tile("[]"));
	set(5,9, new Tile("[]"));
	set(5,10, new Tile("[]"));
	set(5,11, new Tile("[]"));		
	set(5,13, new Tile("[]"));
	set(5,15, new Tile("[]"));
	set(5,17, new Tile("[]"));
	set(5,18, new Tile("[]"));
	set(5,19, new Tile("[]"));
	set(6,10, new Tile("[]"));
	set(6,11, new Tile("[]"));
	set(6,13, new Tile("[]"));
	set(6,15, new Tile("[]"));		
	set(6,17, new Tile("[]"));
	set(6,18, new Tile("[]"));
	set(6,19, new Tile("[]"));
	set(7,11, new Tile("[]"));		
	set(7,13, new Tile("[]"));
	set(7,14, new Tile("[]"));
	set(7,15, new Tile("[]"));
	set(7,17, new Tile("[]"));
	set(7,18, new Tile("[]"));
	set(8,11, new Tile("[]"));
	set(8,17, new Tile("[]"));
	set(9,12, new Tile("[]"));
	set(9,13, new Tile("[]"));		
	set(9,14, new Tile("[]"));
	set(9,15, new Tile("[]"));
	set(9,16, new Tile("[]"));
	set(10,14, new Tile("[]"));
	set(0,16, new Tile("Trainer1"));
	set(1,16, new Tile("TrainerZone"));

	set(19,14, new Tile("BackPortal"));
	set(0,4, new Tile("ForwardPortal"));
	
	if( Player.getFromMap() == 4 ) {
	    Player.setY(19);
	    Player.setX(14);
	    Player.setFromMap( Player.getMapNum() );
	}
	else if( Player.getFromMap() == 6 ) {
	    Player.setY(0);
	    Player.setX(4);
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();	    
    }// ends map5()

    public static void map6() { //COLOSSUS CITY ==========================================
	name = "COLOSSUS CITY";
	
	for ( int row = 0; row < map.length ; row++ ) {
	    for ( int column = 0; column < map[row].length; column++ ) {
		map[row][column] = new Tile( "Grass" );
	    }
	}
	sprinkle(0, "Tree", 30, "Grass", 100);
	sprinkle(1, "Tree", 30, "Grass", 100);
	sprinkle(19, "Rock", 30, "Grass", 100);
	sprinkle(18, "Rock", 10, "Grass", 100);	

	line( 13, 3, 19, 3, "Floor");
	line( 13, 4, 19, 4, "Floor" );
	line( 13, 5, 13, 16, "Floor" );
	line( 14, 5, 14, 16, "Floor" );
	line( 2, 15, 12, 15, "Floor" );
	line( 2, 16, 12, 16, "Floor" );
	line( 7, 3, 7, 14, "Floor" );
	line( 8, 3, 8, 14, "Floor" );
	line( 2, 5, 2, 14, "Floor" );
	line( 3, 5, 3, 14, "Floor" );
	line( 0, 3, 3, 3, "Floor" );
	line( 0, 4, 3, 4, "Floor" );

	set(10,10, new Tile("/"));                    // Pokecenter
	set(10,11, new Tile("-"));
	set(10,12, new Tile("-"));
	set(10,13, new Tile("-"));
	set(10,14, new Tile("\\"));
	set(11,10, new Tile("|"));
	set(11,11, new Tile("_"));
	set(11,12, new Tile("_"));    
	set(11,13, new Tile("_"));
	set(11,14, new Tile("|"));
	set(12,10, new Tile("|"));
	set(12,11, new Tile("_"));
	set(12,12, new Tile("PKCenter"));
	set(12,13, new Tile("_"));
	set(12,14, new Tile("|"));
	Player.setRY( 12 );
	Player.setRX( 12 );

	set(4,10, new Tile("/"));                    // Pokemart
	set(4,11, new Tile("-"));
	set(4,12, new Tile("-"));
	set(4,13, new Tile("-"));
	set(4,14, new Tile("\\"));
	set(5,10, new Tile("|"));
	set(5,11, new Tile("_"));
	set(5,12, new Tile("_"));    
	set(5,13, new Tile("_"));
	set(5,14, new Tile("|"));
	set(6,10, new Tile("|"));
	set(6,11, new Tile("_"));
	set(6,12, new Tile("PKMart"));
	set(6,13, new Tile("_"));
	set(6,14, new Tile("|"));

	set(15,5, new Tile("/"));                    // House
	set(15,6, new Tile("-"));
	set(15,7, new Tile("\\"));
	set(16,5, new Tile("|"));
	set(16,6, new Tile("Floor"));   //house 6-1SW
	set(16,7, new Tile("|"));
	set(17,5, new Tile("|"));
	set(17,6, new Tile("[]"));
	set(17,7, new Tile("|"));

	set(15,9, new Tile("/"));                    
	set(15,10, new Tile("-"));
	set(15,11, new Tile("\\"));
	set(16,9, new Tile("|"));
	set(16,10, new Tile("Floor"));  //house 6-2S
	set(16,11, new Tile("|"));
	set(17,9, new Tile("|"));
	set(17,10, new Tile("[]"));
	set(17,11, new Tile("|"));

	set(15,13, new Tile("/"));                   
	set(15,14, new Tile("-"));
	set(15,15, new Tile("\\"));
	set(16,13, new Tile("|"));
	set(16,14, new Tile("Floor"));   //house 6-3SE
	set(16,15, new Tile("|"));
	set(17,13, new Tile("|"));
	set(17,14, new Tile("[]"));
	set(17,15, new Tile("|"));

	set(4,5, new Tile("/"));                   
	set(4,6, new Tile("-"));
	set(4,7, new Tile("\\"));
	set(5,5, new Tile("|"));
	set(5,6, new Tile("Floor"));      //house 6-4NW
	set(5,7, new Tile("|"));
	set(6,5, new Tile("|"));
	set(6,6, new Tile("[]"));
	set(6,7, new Tile("|"));

        set(9,4, new Tile("/"));               // large house
	set(9,5, new Tile("-"));
	set(9,6, new Tile("-"));
	set(9,7, new Tile("-"));
	set(9,8, new Tile("\\"));
	set(10,4, new Tile("|"));
	set(10,5, new Tile("_"));
	set(10,6, new Tile("_"));    
	set(10,7, new Tile("_"));
	set(10,8, new Tile("|"));
	set(11,4, new Tile("|"));
	set(11,5, new Tile("_"));
	set(11,6, new Tile("_"));    
	set(11,7, new Tile("_"));
	set(11,8, new Tile("|"));
	set(12,4, new Tile("|"));
	set(12,5, new Tile("_"));
	set(12,6, new Tile("[]"));
	set(12,7, new Tile("_"));
	set(12,8, new Tile("|"));

	set(0,4, new Tile("ForwardPortal"));
	set(19,4, new Tile("BackPortal"));
	
	if( Player.getFromMap() == 5 ) {
	    Player.setY(19);
	    Player.setX(4);
	    Player.setFromMap( Player.getMapNum() );
	}
	else if( Player.getFromMap() == 7 ) {
	    Player.setY(0);
	    Player.setX(4);
	    Player.setFromMap( Player.getMapNum() );
	}
	map[Player.getY()][Player.getX()].movePlayer();
    }// ends map6()

    public static void map7() {
	
	
    }//ends map7()
    
}//ends Map.java

