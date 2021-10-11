package interestComputing;

public class Onboarding {

	/*
	 * This class contains onboardingScreen method. Which is calling from main
	 * method of interestCalculator, This method is for printing the onboarding
	 * messages. It will print initial messages to user like What's a purpose of App
	 * and Welcome greeting.
	 * 
	 */

	public void onboardingScreen(double principal, double interestRate, int duration) {

		System.out.println("Welcome to Interest Computation..");
		System.out.println();

		System.out.println(
				"Note:- You can change the principal amount, interest Rate and duration" + " from config file.");
		System.out.println("       Do not change references, just change values and re-run the App.");
		System.out.println("");

		String amountInterstMessage = String.format(
				"Your total Invested Amount is %.2f with an " + "Anual Rate of %.2f per year.", principal,
				interestRate);

		System.out.println(amountInterstMessage);
		System.out.println();

		System.out.println("What it does");

		String simpleInterestMessage = String.format(
				"1. It will calculate the balance of the " + "account exactly  %d years later. (Simple Interest)",
				duration);

		System.out.println(simpleInterestMessage);

		String compoundInterestMessage = String
				.format("2. It will calculate the balance of the " + "account exactly %d years later, assuming "
						+ "interest is paid annually and reinvested. (Compound Interest)", duration);

		System.out.println(compoundInterestMessage);

	}
}
