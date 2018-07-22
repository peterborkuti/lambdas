package chapter4;

import chapter4.separatingconcerns.Data;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataTest {
	@Test
	public void construct() {
		Data d = new Data(1, 2);
		assertEquals(1, d.a);
		assertEquals(2, d.b);
	}

}