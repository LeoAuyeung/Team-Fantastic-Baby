//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Tile.java

public class Tile {
	
    private String image;
    private boolean _isPlayerHere;
	
    //constructor 
    public Tile() {
		image = " ";
		_isPlayerHere = false;
	}
	
    //accessor
    public boolean isPlayerHere() {
		return _isPlayerHere;
	}
	
    //mutators
    //switches _isPlayerHere
    public void setIsPlayerHere() {
		_isPlayerHere = !_isPlayerHere;
	}
	
    //changes the image according to _isPlayerHere
    public void setImage() {
		if( isPlayerHere() ) {
			image = "*";
		}
		else {
			image = " ";
		}
	}
	
    //overwritten toString that will display the image
    public String toString() {
		return image;
	}
	
}//ends Tile.java
