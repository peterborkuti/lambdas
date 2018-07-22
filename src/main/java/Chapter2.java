import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Collectiona
 */
public class Chapter2 {
	public static <T> void print(T[] array, PrintStream out) {
		Arrays.stream(array).forEach(out::print);
	}

	public static String[] toUppercase(String[] array) {
		return Arrays.stream(array).map(String::toUpperCase).toArray(String[]::new);
	}

	public static String[] getElementsStartWithLetter(String[] array, Character letter) {
		return Arrays.stream(array).filter(e -> e.startsWith(letter.toString())).toArray(String[]::new);
	}

	public static Predicate<String> startsWithN = string -> string.startsWith("N");

	public static Predicate<String> startsWithLetter(final String letter) {return string -> string.startsWith(letter);};

	public static Predicate<String> startsWithN2 = Chapter2.startsWithLetter("N");

	public static Function<String, Predicate<String>> startsWithLetter2 = letter ->
		string -> string.startsWith(letter);

	public static Function<String, Predicate<String>> startsWithLetter3 =
		new Function<String, Predicate<String>>() {
			@Override
			public Predicate<String> apply(String letter) {
				return string -> string.startsWith(letter);
			}
	};

	public static String getTheFirstElementStartsWith(String[] elements, String letter) {
		return Arrays.stream(elements).filter(startsWithLetter(letter)).findFirst().orElse("Not found");
	}

	public static long numberOfCharacters(String[] elements) {
		return Arrays.stream(elements).filter(Objects::nonNull).mapToInt(String::length).sum();
	}

	public static String getLongest(String a, String b) {
		if (a == null && b == null) {
			return "";
		}

		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		return (a.length() > b.length()) ? a : b;
	}

	public static String getLongest(String[] elements) {
		return Arrays.stream(elements).reduce("", Chapter2::getLongest);
	}

}
