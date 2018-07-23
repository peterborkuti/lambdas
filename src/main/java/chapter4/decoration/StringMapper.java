package chapter4.decoration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringMapper {
	private Function<String, String> mapper = String::toString;

	public String mapper(String s) {
		return mapper.apply(s);
	}

	public void addMapper(Function<String, String> mapper) {
		this.mapper = mapper.compose(this.mapper);
	}
}
