import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class PWGen {

	public int PWLen = 0;
	public static int PWOpt11 = 0;
	public static int PWOpt22 = 0;
	public String PWOpt2 = null;
	public String PWOpt1 = null;
	public String[] generated = new String[0];
	public String Alphabet, Special;
	public Scanner sc;
	public Scanner sc2;
	public Scanner sc3;

	// Can be called from other classes to trigger certain classes
	public PWGen() {
		Information();
	}

	// Takes users input
	public void Information() {
		sc = new Scanner(System.in);
		System.out.print("System: Please set the new password length (1-20): ");
		PWLen = sc.nextInt();

		sc2 = new Scanner(System.in);
		System.out.print("System: Do you want Alphabets (Y/N): ");
		PWOpt1 = sc2.nextLine();
		if (PWOpt1.equalsIgnoreCase("N") || PWOpt1.equalsIgnoreCase("NO")) {
			PWOpt11 = 1;
		}

		sc3 = new Scanner(System.in);
		System.out.print("System: Do you want Special Chars (Y/N): ");
		PWOpt2 = sc3.nextLine();
		if (PWOpt2.equalsIgnoreCase("N") || PWOpt2.equalsIgnoreCase("NO")) {
			PWOpt22 = 1;
		}

		generated = Increase(PWLen);
		generated = Generating(generated, PWLen);
		System.out.print("System: New Password = ");
		Printout(generated);
	}

	// Based on users input, it updates the array size
	public static String[] Increase(int index) {
		String[] temp = new String[index];
		return temp;
	}

	// Generates password
	public static String[] Generating(String[] temp, int index) {
		Random rand = new Random();

		for (int i = 0; i < index; i++) {
			int randie = rand.nextInt(9);
			int dice = rand.nextInt(3);

			if (PWOpt11 == 1 && PWOpt22 == 1) {
				temp[i] = String.valueOf(randie);
			} else if (PWOpt11 == 1) {
				if (dice == 0) {
					temp[i] = String.valueOf(randie);
				} else if (dice == 1) {
					temp[i] = Special();
				} else {
					temp[i] = String.valueOf(randie);
				}
			} else if (PWOpt22 == 1) {
				if (dice == 0) {
					temp[i] = String.valueOf(randie);
				} else if (dice == 1) {
					temp[i] = Alphabet();
				} else {
					temp[i] = String.valueOf(randie);
				}
			} else {
				if (dice == 0) {
					temp[i] = String.valueOf(randie);
				} else if (dice == 1) {
					temp[i] = Alphabet();
				} else if (dice == 2) {
					temp[i] = Special();
				} else {
					temp[i] = String.valueOf(randie);
				}
			}
		}

		return temp;
	}

	// Displays the newly generated password
	public static void Printout(String[] generated) {
		for (int i = 0; i < generated.length; i++) {
			System.out.print(generated[i]);
		}
	}

	// Randomly selects an alphabet and sends back either in Capitalized or not
	public static String Alphabet() {
		Random rand = new Random();
		String chosen;
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int dice = rand.nextInt(2);

		char letter = abc.charAt(rand.nextInt(abc.length()));

		if (dice == 0) {
			chosen = String.valueOf(letter);
			chosen = chosen.toLowerCase();
		} else {
			chosen = String.valueOf(letter);
			chosen = chosen.toUpperCase();
		}

		return chosen;
	}

	// Randomly selects a special letter and returns the chosen
	public static String Special() {
		Random rand = new Random();
		String chosen;
		String special = "!@#$%^&*()";

		char spl = special.charAt(rand.nextInt(special.length()));
		chosen = String.valueOf(spl);
		return chosen;
	}

	// Starts the program from here
	public static void main(String[] args) {
		PWGen Start = new PWGen();
	}
}
