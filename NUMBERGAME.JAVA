package numberPrograms;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {

		System.err.println("WELCOME TO  NUMBER GAME__");
		// Here i use infinite for loop because in want to display options multiple
		// times

		for (;;) {
			System.out.println("1.PLAY_GAME " + "  2.EXIT_GAME");
			// Here i take input from user as a choice for switch statement
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				// I call method if user want to play game
				NumberGame.game(1);
				break;
			}

			case 2: {
				// If user want to exit
				System.exit(0);
			}

			}
		}
	}

	public static void game(int a) {

		System.out.println("YOU  HAVE 3 CHANCE TO GUESS THE CORRECT NUMBER BETWEEN 1-6");

		// I use for loop to limit the chances
		for (int i = 1; i <= 3; i++) {
			// Here i use Random Class to generate random number by compiler
			Random random = new Random();
			// Here i pass 7 as parameter because i want to generate random number between
			// 1-6
			int ans = random.nextInt(7);
			// Here we take user input as guess
			Scanner sc = new Scanner(System.in);
			System.out.println("guess the number");
			int guess = sc.nextInt();

			if (ans == guess) {
				System.err.println("YOU_WON..!!! your guess is correct");
				return;
			} else if (guess < ans) {
				System.out.println("your guess is too low");

			} else if (guess > ans) {
				System.out.println("your guess is too high");

			}

		}
		System.out.println("game over");

	}
}