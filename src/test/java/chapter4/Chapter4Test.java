package chapter4;

import chapter4.separatingconcerns.Chapter4;
import chapter4.separatingconcerns.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Chapter4Test {

	@Test
	public void walk() {
		List<Data> data = new ArrayList<>();
		data.add(new Data(1,2));
		data.add(new Data(3,4));
		data.add(new Data(5,6));
		Chapter4 c4 = new Chapter4(data);

		assertEquals(9L, c4.walk((a,b) -> a + b).longValue());
		assertEquals(15L, c4.walk((a,b) -> a * b).longValue());
	}
}