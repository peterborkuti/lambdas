package chapter4.delegation;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.Function;

import static org.junit.Assert.*;

public class CalculateTest {

	/**
	 * Let's mock the web service (without tons of libraries)
	 *
	 */
	public static BigDecimal getNumberOfGoods(String name) {
		return new BigDecimal("10");
	}

	@Test
	public void totalValue() {
		Calculate cal = new Calculate(CalculateTest::getNumberOfGoods);
		BigDecimal expected = new BigDecimal("10").multiply(new BigDecimal("3"));

		assertEquals(expected, cal.totalValue("Volvo", 3));
	}
}