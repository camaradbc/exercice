package test.exercice;

import test.exercice.exception.BadPathException;
import test.exercice.model.Position;
import test.exercice.service.Adventurer;

public class Main {
	public static void main(String[] args) {

		int x = 6;
		int y = 9;
		String chaine = "OONOOOSSO";
		new Position(x,y,chaine);
		Position result;
		try {
			result = Adventurer.play(new Position(x,y,chaine));
			System.out.println(result);
		} catch (BadPathException e) {
			e.printStackTrace();
		}
		
	}
}
