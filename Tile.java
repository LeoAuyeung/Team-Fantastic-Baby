//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Tile.java

public class Tile {
	
    private String type;
    private String image;
    private boolean _isPlayerHere;
    private final String[] obstacles = { "_","MewRight", "MewLeft", "Trainer", "Tree", "Rock","\\", "|", "/", "-", "/\\", "[]" };
	
    //constructor
    public Tile() {
	this.type = "";
	setImage();
	_isPlayerHere = false;
    }
    
    public Tile( String type ) {
	this.type = type;
        setImage();
	_isPlayerHere = false;
    }
    
    //accessor
    public boolean isPlayerHere() {
	return _isPlayerHere;
    }

    public String getType() {
	return type;
    }
    
    //mutators
    //switches _isPlayerHere
    public void setIsPlayerHere() {
	_isPlayerHere = !_isPlayerHere;
    }

    //changes the image according to _isPlayerHere
    public void setImage() {
	if( isPlayerHere() ) {
	    image = " * ";
	}
	else {
	    if( type.equals( "Grass" ) ) {
		image = "^^^";
	    }
	    else if( type.equals( "Tree" ) ) {
		image = " T ";
	    }
	    else if( type.equals( "Rock" ) ) {
		image = "oOo";
	    }
	    else if( type.equals( "Trainer" ) ) {
		image = "(!)";
	    }
	    else if( type.equals( "TrainerZone" )) {
		image = "   ";
	    }
	    else if( type.equals( "MewRight" )) {
		image = "V\\/";
	    }
	    else if( type.equals( "MewLeft" )) {
		image = "\\/V";
	    }
	    else if( type.equals( "LegendaryZone" )) {
		image = "   ";
	    }
	    else if( type.equals( "/\\" ) ) {
		image = "/ \\";
	    }
	    else if( type.equals( "[]" )) {
		image = "[ ]";
	    }
	    else if( type.equals( "/" ) ) {
		image = " /-";
	    }
	    else if( type.equals( "-" ) ) {
		image = "---";		
	    }
	    else if( type.equals( "_" ) ) {
		image = "___";
	    }
	    else if( type.equals( "\\" ) ) {
		image = "-\\ ";
	    }
	    else if( type.equals( "|" ) ) {
		image = " | ";
	    }
	    else if( type.equals( "PKMart" ) ) {
		image = "<M>";
	    }
	    else if( type.equals( "BackPortal" ) || type.equals( "ForwardPortal") ) {
		image = "[_]";
	    }
	    else if( type.equals( "Cave" ) ) {
		image = "   ";
	    }	    
	    else if( type.equals( "PKCenter" ) ) {
		image = "<C>";
	    }	   
	    else if( type.equals( "=" ) ) {
		image = "===";
	    }
	    else if( type.equals( "||" )) {
		image = "|||";
	    }
	    else if( type.equals("Floor") ) {
		image = "   ";
	    }
	    else {
		image = "";
	    }	    
	}
    }    	    

    public void setImage( String s ) {
	image = s;
    }
    
    public Boolean isObstacle() {
	for( int i = 0; i < obstacles.length; i++ ) {
	    if( type.equals( obstacles[i] ) ) {
		return true;
	    }
	}
	return false;
    }
    
    public void reset() {
	_isPlayerHere = false;
	setImage();
    }

    public void movePlayer() {
	_isPlayerHere = true;
	setImage();
    }
    
    //overwritten toString that will display the image
    public String toString() {
	return image;
    }
	
}//ends Tile.java

