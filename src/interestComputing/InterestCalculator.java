package interestComputing;

import java.io.*;
import java.text.*;
import java.util.*;

public class InterestCalculator {

	// calculating simple interest.
	public static double simpleInterestCalculator(double principal, double interestRate, double duration) {
		double totalInterest = principal * interestRate * duration;
		return principal + totalInterest;

	}

	// calculating compounding interest.
	public static double compoundInterestCalculator(double principal, double interestRate, double duration) {
		double totalInterest = principal * Math.pow((1 + interestRate), duration) - principal;
		return principal + totalInterest;

	}

	// function is for printing output.
	public static void printOutput(double principal, double interestRate, int duration, double totalAmountSI,
			double totalAmountCI) {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println();

		System.out.println("Result:- ");
		System.out.println();
		System.out.println("Principal                           : " + "                           "
				+ String.format("%.2f", principal));
		System.out.println("Rate of interest                    : " + "                           "
				+ String.format("%.2f", interestRate) + "%");
		System.out.println("Today’s Date                        : " + "                           " + ft.format(dNow));
		System.out.println("Amount at maturity                  : " + "                           "
				+ String.format("%.4f", totalAmountSI));
		System.out.println("Amount at maturity (compounding)    : " + "                           "
				+ String.format("%.4f", totalAmountCI));

	}

	public static void main(String[] args) {
		try {

			// FileReader object to read config file which contains amount, interest rate,
			// duration.
			FileReader reader = new FileReader("config");
			Properties properties = new Properties();

			properties.load(reader);

			// fetching values from the config file and assigning to the variable
			double principal = Double.parseDouble(properties.getProperty("amount"));
			double interestRate = Double.parseDouble(properties.getProperty("interestRate"));
			int duration = Integer.parseInt(properties.getProperty("years"));

			// Create a onboarding class object.
			// onboardingScreen method is for printing the onboarding messages.
			Onboarding onboarding = new Onboarding();
			onboarding.onboardingScreen(principal, interestRate, duration);

			// pass the required parameter to function for calculating SI and CI.
			double totalAmountSI = simpleInterestCalculator(principal, interestRate / 100, duration);
			double totalAmountCI = compoundInterestCalculator(principal, interestRate / 100, duration);

			// here passing the required parameter and function will print the output.
			printOutput(principal, interestRate, duration, totalAmountSI, totalAmountCI);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
