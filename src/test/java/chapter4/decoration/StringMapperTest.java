package chapter4.decoration;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.*;

public class StringMapperTest {

	private String mapperAtoB(String s) {
		return s.replaceAll("a", "b");
	}

	private String mapperAtoB2(String s) {
		return s.replaceAll("A", "B");
	}

	private String mapperAllCaps(String s) {
		return s.toUpperCase();
	}

	@Test
	public void mapper() {
		StringMapper sm = new StringMapper();
		sm.addMapper(this::mapperAllCaps);
		sm.addMapper(this::mapperAtoB2);
		assertEquals("BBC", sm.mapper("abc"));
	}

	@Test
	public void mapper2() {
		StringMapper sm = new StringMapper();
		sm.addMapper(String::toLowerCase);
		sm.addMapper(this::mapperAtoB);
		sm.addMapper(String::toUpperCase);
		assertEquals("BBC", sm.mapper("ABC"));
	}
}