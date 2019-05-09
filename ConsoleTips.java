import java.util.Scanner;

/**
 * This program produces a console-based tip calculator for user to interact
 * with
 * 
 * @author Bobby Nguyen
 * @version Feb 9th, 2019
 *
 */
public class ConsoleTips {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String userAnswer = "";

		// to ask which version user wants to calculate tip on
		System.out.println("What portion of bill would you like to tip? (Ex: food, alcohol, total): ");
		String whatVersion = console.next();

		// if user chooses total
		if (whatVersion.equalsIgnoreCase("total")) {

			// prompts user to enter amount
			System.out.println("Please enter the bill amount in 2 decimal places (Ex: 0.00): ");
			double billAmount = console.nextDouble();

			// prompts user to input percentage
			System.out.println("What percentage would you like to tip? (Ex: 10%)");
			double percentageAmt = console.nextDouble();
			percentageAmt = percentageAmt / 100;

			// calculates the tip then displays it
			double tipAmt = TipUtilities.calcTip(billAmount, percentageAmt);
			System.out.println("The tip amount is: $" + tipAmt);

			// prompts user if to round up
			System.out.println("Would you like to round up?");
			String ifRoundUp = console.next();

			// use case when user agreed to round up
			double tipRoundUp = 0.00;
			double percentageAfterTip = 0.00;
			if (ifRoundUp.equalsIgnoreCase("yes")) {
				tipRoundUp = TipUtilities.round(tipAmt, 0.5);
				percentageAfterTip = Double
						.parseDouble(TipUtilities.formatNumber(((tipRoundUp * percentageAmt) / tipAmt) * 100, 2));
				System.out.println("Your tip is now: $" + TipUtilities.formatNumber(tipRoundUp, 2)
						+ " and you have tipped: " + percentageAfterTip + "%");
			}
			//prompts if user wants to leave money on table
			System.out.println("Would you like to leave total on table? ");
			userAnswer = console.next();
			if (userAnswer.equalsIgnoreCase("yes")) {
				double finalTotal = billAmount + tipRoundUp;
				System.out.println(
						"Your total bill to leave on table is: $" + TipUtilities.formatNumber(finalTotal, 2));
			}

		}
		//if users chooses food
		if (whatVersion.equalsIgnoreCase("food")) {

			System.out.println("Please enter the amount billed for food only (Ex: 0.00): ");
			double foodOnlyAmt = console.nextDouble();

			System.out.println("What percentage would you like to tip? (Ex: 10%)");
			double percentageAmt2 = console.nextDouble();
			percentageAmt2 = percentageAmt2 / 100;

			double tipFoodOnlyAmt = TipUtilities.calcTip(foodOnlyAmt, percentageAmt2);
			System.out.println("The tip amount is: $" + tipFoodOnlyAmt);

			System.out.println("Would you like to round up?");
			String ifRoundUp = console.next();

			double tipRoundUp2 = 0.00;
			double percentageAfterTip2 = 0.00;
			if (ifRoundUp.equalsIgnoreCase("yes")) {
				tipRoundUp2 = TipUtilities.round(tipFoodOnlyAmt, 0.10);
				percentageAfterTip2 = Double.parseDouble(
						TipUtilities.formatNumber(((tipRoundUp2 * percentageAmt2) / tipFoodOnlyAmt) * 100, 2));
				System.out.println("Your tip is now: $" + TipUtilities.formatNumber(tipRoundUp2, 2)
						+ " and you have tipped " + percentageAfterTip2 + "%");
			}

			System.out.println("Would you like to leave total on table? ");
			userAnswer = console.next();
			if (userAnswer.equalsIgnoreCase("yes")) {
				System.out.println("Please enter the total bill amount in 2 decimal places (Ex: 0.00): ");
				double totalBillAmount = console.nextDouble();
				System.out.println("Your total bill with tip for food is now: $"
						+ TipUtilities.formatNumber(foodOnlyAmt + tipRoundUp2 + (totalBillAmount - foodOnlyAmt), 2));
			}

		}
	}

}
