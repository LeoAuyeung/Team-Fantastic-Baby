//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

public class Game {

	public String promptGender() {
		String gen = "";
		System.out.println("Please input your gender (m/f): ");
		gen = Keyboard.readString();
		return gen;
	}

	public String promptName() {
		String name = "";
		System.out.println("Please input your name: ");
		name = Keyboard.readString();
		return name;
	}

	public void play() {
		//startup prompt; only prompts user once
		System.out.println("Welcome to Pokemon!");
		String g = promptGender();
		String n = promptName();
		Player bob = new Player(g, n);
		Map test = new Map();
		
		System.out.println( bob.getName() );
	}

	public static void main (String[] args) {
		Game pkmn = new Game();
		pkmn.play();
	}

}
		
