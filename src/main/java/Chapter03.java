import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Chapter03 {
	public static long countGivenCharInString(String string, Character character) {
		return string.chars().filter(c -> c == character).count();
	}

	public static Map<Integer, Long> countNumbers(Integer[] numbers) {
		 return Arrays.stream(numbers).collect(Collectors.groupingBy(Integer::new, counting()));
	}


}
