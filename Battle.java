//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Battle.java

public class Battle {
	
	private static Object[][] battle;
	
	//default constructor for map
    public Battle() {
		battle = new Object[20][20];
		for ( int row = 0; row < map.length ; row++ ) {
			for ( int column = 0; column < map[row].length; column++ ) {
				battle[row][column] = new Object();
			}
		}
		//implement how to display map here
	}
	
	//toString to return String representation of map
    public String toString() {
		String ans = "";
		for ( int row = 0; row < map.length ; row++ ) {
			for ( int column = 0; column < map[row].length; column++ ) {
				ans += map[row][column];
			}
			ans += "\n";
		}
		return ans;
	}
	
}
