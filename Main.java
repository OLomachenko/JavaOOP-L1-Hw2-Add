package mobileCompany;

//import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Network network = new Network();
		long myNumber = 0;

		for (;;) {
			System.out.println("Please enter your phone number (12-digit format):");
			String line = sc.nextLine();
			System.out.println();
			if (line.length() == 12 && isNumber(line)) {
				myNumber = Long.valueOf(line);
				break;
			} else {
				System.out.println("Wrong entry! Mobile number must be a 12-digit number!");
			}
			System.out.println();
		}

		for (;;) {
			System.out.println("Do you want to register this number in the network? (yes/no)");
			String question = sc.nextLine();
			System.out.println();
			if (question.equals("yes")) {
				network.registration(myNumber);
				break;
			} else if (question.equals("no")) {
				System.out.println("You cannot make calls with unregistered phone." + System.lineSeparator()
						+ "But you may register it later");
				System.out.println();
				break;
			} else {
				System.out.println("Sorry, I didn't understand you. Please enter yes or no");
			}
		}

		for (;;) {
			System.out.println("Please tell me, what do you want to do next?");
			System.out.println("register, call or quit?");
			String nextAction = sc.nextLine();
			System.out.println();

			if (nextAction.equals("quit")) {
				System.out.println("Have a nice day! Bye");
				break;

			} else if (nextAction.equals("register")) {
				for (;;) {
					System.out.println("Please enter number you want to register:");
					String input = sc.nextLine();
					System.out.println();
					if (input.length() == 12 && isNumber(input)) {
						long newNumber = Long.valueOf(input);
						network.registration(newNumber);
						break;
//					System.out.println(Arrays.toString(network.getdataBase()));
					} else {
						System.out.println("Wrong entry! Mobile number must be a 12-digit number!");
					}
				}

			} else if (nextAction.equals("call")) {
				for (;;) {
					System.out.println("Input number to call:");
					String input = sc.nextLine();
					System.out.println();

					if (input.length() == 12 && isNumber(input)) {
						long inputNumber = Long.valueOf(input);
						Phone newNumber = new Phone(inputNumber);

						if (network.checkNumber(inputNumber)) {
							if (network.checkNumber(myNumber)) {
								newNumber.incomingCall(myNumber);
								break;
							} else {
								System.out.println("Your number " + myNumber + " is not registered in network company");
								System.out.println();
								break;
							}
						} else {
							System.out.println("Number " + inputNumber + " is not registered in network company");
							System.out.println();
							break;
						}
					} else {
						System.out.println("Wrong entry! Mobile number must be a 12-digit number!");
						System.out.println();
						continue;
					}
				}

			} else {
				System.out.println("Sorry, I didn't understand you!");
			}
		}
	}

	private static boolean isNumber(String str) {
		if (str == null || str.isEmpty())
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}
}
