import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Chapter2Test {

	@Test
	public void print() {
		//TODO test it with mocking PrintStream !
	}

	@Test
	public void toUppercase() {
		String[] s = new String[]{"a", "éáűőúöüóí"};
		assertArrayEquals(new String[]{"A", "ÉÁŰŐÚÖÜÓÍ"}, Chapter2.toUppercase(s));
	}

	@Test
	public void getElementsStartWithLetter() {
		String[] s = new String[]{"Eve", "Dave", "Peter", "Sara", "Daniel"};
		assertArrayEquals(new String[]{"Dave", "Daniel"}, Chapter2.getElementsStartWithLetter(s, 'D'));
		assertEquals(0, Chapter2.getElementsStartWithLetter(s, 'X').length);
		assertEquals(0, Chapter2.getElementsStartWithLetter(new String[0], 'X').length);
	}

	@Test
	public void startsWithN() {
		assertFalse(Chapter2.startsWithN.test("Xena"));
		assertTrue(Chapter2.startsWithN.test("Nemo"));
		assertTrue(Chapter2.startsWithN2.test("Nemo"));
		assertTrue(Chapter2.startsWithLetter("N").test("Nemo"));
	}

	@Test
	public void startsWithLetter2() {
		assertTrue(Chapter2.startsWithLetter2.apply("N").test("Nemo"));
		assertFalse(Chapter2.startsWithLetter2.apply("X").test("Nemo"));
	}

	@Test
	public void getTheFirstElementStartsWith() {
		assertEquals("Nemo", Chapter2.getTheFirstElementStartsWith(new String[]{"Adele", "Nemo", "Xenia"}, "N"));
	}

	@Test
	public void numberOfCharacters() {
		assertEquals(0, Chapter2.numberOfCharacters(new String[0]));
		assertEquals(5, Chapter2.numberOfCharacters(new String[]{"abc", "", "12"}));
		assertEquals(5, Chapter2.numberOfCharacters(new String[]{"abc", null, "12"}));
	}

	@Test
	public void getLongest() {
		assertEquals("a", Chapter2.getLongest("", "a"));
		assertEquals("ae", Chapter2.getLongest("ae", "a"));
	}

	@Test
	public void getLongest1() {
		assertEquals("", Chapter2.getLongest(new String[0]));
		assertEquals("", Chapter2.getLongest(new String[]{null}));
		assertEquals("abcd", Chapter2.getLongest(new String[]{"a", "abcd", "ab"}));
	}
}