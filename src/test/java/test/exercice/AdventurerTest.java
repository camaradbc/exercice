package test.exercice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import test.exercice.model.Position;
import test.exercice.service.Adventurer;

public class AdventurerTest {

	@Test
	void should_return_7_5() {
		Position p = new Position(6, 9, "OONOOOSSO");
		Position value = Adventurer.play(p);
		assertEquals("(7,5)", value.toString());

	}

	@Test
	void should_return_9_2() {
		Position p = new Position(3, 0, "SSSSEEEEEENN");
		Position value = Adventurer.play(p);
		assertEquals("(9,2)", value.toString());

	}

}
