package chapter4.decoration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ColorMapper {
	private final List<Function<Color, Color>> mappers = new ArrayList<>();

	public ColorMapper() {

	}

	public static Color identity(Color color) {
		return color;
	}

	public void addMapper(Function<Color, Color> mapper) {
		this.mappers.add(mapper);
	}

	public Color map(Color color) {
		return mappers.stream().
				reduce((mapper, nextMapper) -> mapper.compose(nextMapper)).
				orElse(ColorMapper::identity).apply(color);
	}
}
