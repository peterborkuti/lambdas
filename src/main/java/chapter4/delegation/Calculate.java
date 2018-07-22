package chapter4.delegation;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Calculates prices for the given goods and prices
 * It uses "web services" to get the number of goods
 */
public class Calculate {
	/**
	 * The web service which gets the number of pieces of the goods
	 * based on their names
	 */
	final Function<String, BigDecimal> getNumOfPiecesFromTheWeb;


	/**
	 * Dependency injection of the web service for easy of testing
	 * @param getNumOfPiecesFromTheWeb
	 */
	public Calculate(Function<String, BigDecimal> getNumOfPiecesFromTheWeb) {
		this.getNumOfPiecesFromTheWeb = getNumOfPiecesFromTheWeb;
	}

	/**
	 * Gets the number of goods from the web and counts the total value based
	 * on the actual price per piece
	 * @param goodName
	 * @param actualPricePerPiece
	 * @return
	 */
	public BigDecimal totalValue(String goodName, int actualPricePerPiece) {
		return getNumOfPiecesFromTheWeb.apply(goodName).multiply(BigDecimal.valueOf(actualPricePerPiece));
	}
}
