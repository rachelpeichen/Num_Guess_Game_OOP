package java335_ntu_lab;

import java.util.Scanner;

public class FastPowerV2 {
	
	public static int Power(int x, int n) {
		if (n == 0) {
			return 1; //Base case
			
		} else if (n % 2 ==0) { // When the power is even, can be divided to two half 
			int m = Power(x, n/2);
			return m * m;
			
		} else {
			int m = Power(x, n/2); // When the power is odd, need multiple base ^ 1
			return m * m * x;
		}
	}

	public static void main(String[] args) {

		System.out.println("Base: ");
		Scanner input = new Scanner(System.in); 
		int x = input.nextInt();
		
		System.out.println("Power: ");
		Scanner input2 = new Scanner(System.in); 
		int n = input2.nextInt();
		
		int result = Power(x,n);
		System.out.printf("Result: %d",result);
		input.close();
		input2.close();
	} 
}
/*
 * 2 ^ 0 = 1
 * 2 ^ 1 = 2 ^ 0 * 2 ^ 0 * 2 ^ 1
 * 2 ^ 2 = 2 ^ 1 * 2 ^ 1
 * 2 ^ 3 = 2 ^ 2 * 2 ^ 1
 * 2 ^ 4 = 2 ^ 2 * 2 ^ 2
 * 2 ^ 5 = 2 ^ 2 * 2 ^ 2 * 2 ^ 1
 */

