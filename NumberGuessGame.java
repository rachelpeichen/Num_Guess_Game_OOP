package java335_ntu_lab;

import java.util.Scanner;

public class NumberGuessGame {

	public static void main(String[] args) {
		// 1. Generate a secret number ranging between 0 and 99 (inclusive) and this will be the answer.
		int ans = (int)(Math.random() * 100);
		System.out.printf("Hint: Answer is %d.%n",ans);
		
		// 2. Ask the player to enter a number and read the input from the keyboard.
		System.out.println("Please enter a number: ");
		Scanner input = new Scanner(System.in);
		int guess = 0, min = 0, max = 99, count = 0;
		
		// 3. Check if guess equals to answer, if not, keep asking
		while (guess != ans) {			
			guess  = input.nextInt();
			count += 1;
			
			if (guess < 0 || guess > 99) { // 3.1 Check input guess out of range
				System.out.println("Out of range. Try again? ");
				continue;
			}
			
			if (guess > ans) {
				max = guess - 1; // 3.2 If guess > ans then update range and tell player
				System.out.printf("Your guess is too big.%n The range is (%d, %d).%n", min, max);
				continue;
				
			} else if (guess < ans) {
				min = guess + 1;
				System.out.printf("Your guess is too small.%n The range is (%d, %d).%n", min, max);
				continue;
				
			} else {
				System.out.printf("Bingo! The answer is %d !%n", ans);
			}		
		}
		System.out.printf("You try %d time(s).", count);
		input.close();
	}
}
		