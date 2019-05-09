import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * This program creates a tip calculator and will be tested using JUnit tests
 * 
 * @author Bobby Nguyen
 * @version Feb 9th, 2019
 *
 */
public class TipUtilities {

	/**
	 * Allows to calculate the tip amount
	 * 
	 * @param baseAmount the bill amount entered
	 * @param percentage the percentage user tip
	 * @throws IllegalArgumentException if baseAmount or percentage is negative
	 * @return the tip amount the result of calculation
	 */
	public static double calcTip(double baseAmount, double percentage) {
		double result1 = 0;
		if ((baseAmount < 0.0) || (percentage < 0.0)) {
			throw new IllegalArgumentException("Can't compute due to negative value.");
		} else {
			result1 = baseAmount * percentage;
		}
		return result1;
	}

	/**
	 * Method to round tip to quarter, dime, or a dollar
	 * 
	 * @param amountToRound the calculated tip amount
	 * @param quantum       the nearest dime, quarter, or half dollar round
	 *                      preference
	 * @return rounded amount tip amount after user specify to round up or down
	 */
	public static double round(double amountToRound, double quantum) {
		double overage = amountToRound % quantum;
		if ((amountToRound < 0) || (quantum < 0)) {
			throw new IllegalArgumentException("Can't round due to negative value.");
		} else {
			if (overage > (quantum / 2)) {
				amountToRound += (quantum - overage);
			} else if (overage < (quantum / 2)) {
				amountToRound -= overage;
			}
		}
		return amountToRound;
	}

	/**
	 * Method to format digits of rounded amount to a specific decimal point
	 * 
	 * @param num           the rounded tip amount
	 * @param decimalDigits the number of decimal digits to format number
	 * @see https://www.baeldung.com/java-round-decimal-number how to round number
	 *      to n decimal digits
	 * @return string result final amount when number is formatted
	 */
	public static String formatNumber(double num, int decimalDigits) {
		if ((num < 0) || (decimalDigits < 0)) {
			throw new IllegalArgumentException("Can't format due to negative value.");
		}
		double scale = Math.pow(10, decimalDigits);
		String result = Double.toString(Math.round(num * scale) / scale);

		// To add 0 to string
		String afterDot = result.substring(result.indexOf("."), result.length() - 1);

		// for the substring after dot, add accordingly to decimal digits amount of 0s
		// if it only has 1 character after dot
		if (afterDot.length() < decimalDigits) {
			for (int i = result.indexOf("."); i < decimalDigits; i++) {
				result += "0";
			}
		}
		if ((result.substring(result.indexOf("."), result.length() - 1).length()) < decimalDigits) {
			for (int i = 1; i < decimalDigits; i++) {
				result += "0";

			}

			
		}
		return result;
	}
}
