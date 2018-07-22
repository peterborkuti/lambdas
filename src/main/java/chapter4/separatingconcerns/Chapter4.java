package chapter4.separatingconcerns;

import java.util.List;
import java.util.function.BiFunction;

public class Chapter4 {
	private final List<Data> data;

	public Chapter4(List<Data> data) {
		this.data = data;

	}

	public Integer walk(final BiFunction<Integer, Integer, Integer> func) {
		return data.stream().map(d -> d.a).reduce((a,b)->func.apply(a,b)).orElse(0);
	}
}
