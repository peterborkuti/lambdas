import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class Chapter03Test {

	@Test
	public void countGivenCharInString() {
		assertEquals(0, Chapter03.countGivenCharInString("aabccc", 'x'));
		assertEquals(3, Chapter03.countGivenCharInString("aabccc", 'c'));
		assertEquals(0, Chapter03.countGivenCharInString("", 'x'));
	}

	@Test
	public void countNumbers() {
		Integer[] nums = new Integer[]{0,0,0,1,2,2,3,4,3,3,3,3,4,5,4,4,5};
		Map<Integer, Long> counts = Chapter03.countNumbers(nums);

		Integer[] keys = counts.keySet().toArray(new Integer[0]);
		assertArrayEquals(new Integer[]{0,1,2,3,4,5}, keys);

		Long[] values = counts.values().toArray(new Long[0]);
		assertArrayEquals(new Long[]{3L,1L,2L,5L,4L,2L}, values);

	}
}