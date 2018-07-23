package chapter4.decoration;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ColorMapperTest {

	@Test
	public void identity() {
		Color color = new Color(1, false);
		assertEquals(color, ColorMapper.identity(color));
	}

	@Test
	public void mapDefaultMapperIdentity() {
		ColorMapper cm = new ColorMapper();
		Color color = new Color(1, false);
		assertEquals(color, cm.map(color));
	}

	@Test
	public void mapCustomMapper() {
		ColorMapper cm = new ColorMapper();
		Color inputColor = new Color(1,1,1,1);
		Color expectedColor = new Color(2 - 1,3 - 1,4 - 1,1);
		cm.addMapper(c -> new Color(c.getRed() - 1, c.getGreen() - 1, c.getBlue() - 1, c.getAlpha()));
		cm.addMapper(c -> new Color(c.getRed() * 2, c.getGreen() * 3, c.getBlue() * 4, c.getAlpha()));
		assertEquals(expectedColor, cm.map(inputColor));
	}
}