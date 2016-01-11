//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Map.java

public class Map {
	
	//barely worked on this
	private Object[][] map;
	
	//default constructor for map
	public Map() {
		map = new Object [10] [20];
	}
	
	//returns Object at specified row & column   
    private Object get( int row, int column ) {
		return map[row][column];
	}
	
	//overwrite item at specified row and column with newData, returns old value
	private Object set( int row, int column, Object newData ) {
		Object temp = get(row,column);
		map[row][column] = newData;
		return temp;
	}
	
	//toString to return String representation of map
	public String toString() {
		String ans = "";
		for ( int row = 0; row < map.length ; row++ ) {
			for ( int column = 0; column < map[row].length; column++ ) {
				ans += matrix[row][column];
			}
			ans += "\n";
		}
		return ans;
	}
	
}
