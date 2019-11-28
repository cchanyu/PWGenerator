import java.util.Arrays;
import java.util.Random;

public class PWGen2 {

	public static int PWLen = GUI.getNum();
	public static int PWOpt11 = 0;
	public static int PWOpt22 = 0;
	public static String PWOpt2 = GUI.getOpt1();
	public static String PWOpt1 = GUI.getOpt2();
	public static String[] generated = new String[0];
	public static String Alphabet, Special, Final;
    public static StringBuilder stringBuilder = new StringBuilder();

	// Can be called from other classes to trigger certain classes
	public PWGen2() {
		Information();
	}

	// Takes users input
	public void Information() {
		if (PWOpt1.equalsIgnoreCase("N") || PWOpt1.equalsIgnoreCase("NO")) {
			PWOpt11 = 1;
		}
		if (PWOpt2.equalsIgnoreCase("N") || PWOpt2.equalsIgnoreCase("NO")) {
			PWOpt22 = 1;
		}
		generated = Increase(PWLen);
		generated = Generating(generated, PWLen);
		System.out.print("System: New Password = ");
		Final = Printout(generated);
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
			int dice = rand.nextInt(1000);

			if (PWOpt11 == 1 && PWOpt22 == 1) {
				temp[i] = String.valueOf(randie);
			} else if (PWOpt11 == 1) {
				if (dice < 300) {
					temp[i] = String.valueOf(randie);
				} else if (dice < 400) {
					temp[i] = Special();
				} else {
					temp[i] = String.valueOf(randie);
				}
			} else if (PWOpt22 == 1) {
				if (dice < 300) {
					temp[i] = String.valueOf(randie);
				} else if (dice < 400) {
					temp[i] = Alphabet();
				} else {
					temp[i] = String.valueOf(randie);
				}
			} else {
				if (dice < 250) {
					temp[i] = String.valueOf(randie);
				} else if (dice < 400) {
					temp[i] = Alphabet();
				} else if (dice < 550) {
					temp[i] = Special();
				} else {
					temp[i] = String.valueOf(randie);
				}
			}
		}

		return temp;
	}

	// Displays the newly generated password
	public static String Printout(String[] generated) {
		for (int i = 0; i < generated.length; i++) {
			System.out.print(generated[i]);
			stringBuilder.append(generated[i]);
		}
		return stringBuilder.toString();
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
}
