package java335_ntu_lab;

import java.util.Arrays;
import java.util.Scanner;

public class ContagionControl {

	public static void main(String[] args) {
		
		System.out.println("Please enter the number of citizens: ");
		Scanner input = new Scanner(System.in); 
		int N = input.nextInt();
		
		int [] id = new int [N]; // Create an array with N elements. "id" is a reference to this array.
		
		System.out.printf("       ID: ");
		for (int i = 0; i < id.length; i++) { // Put numbers from 0 to N-1 into "id" array.
			id[i] = i;
		} 
		System.out.println(Arrays.toString(id));
		
		System.out.printf("%nContactee: ");
		
		/* Copy array:
        1. Create an array contactee[] of same size as id[]. 
        2. Copy elements of id[] to contactee[]. */
		
        int contactee[] = new int[id.length]; 
        System.arraycopy(id, 0, contactee, 0, id.length); // This method copy from a source range to a destination range.
		
        
		/* Shuffle algorithm: naive solution is to choose a random index in the array, 
		   and then swap it from the first element of the array. */
        
		for (int i=0; i < contactee.length; i++) {
			
			// Pick a random index between 0 ~ N-1 range.
			int j = (int) (Math.random() * contactee.length);
			
			// Swap contactee[i] with the element at random index location.
			int tmp = contactee[i];          // Create a temporal value to remember current contactee[i].
				contactee[i] = contactee[j]; // Swap -> ex: when i=0, if j=9; swap their index value
				contactee[j] = tmp;
		}
		System.out.println(Arrays.toString(contactee));
		
		System.out.println("------------------");
		
		System.out.println("Please enter the ID of infected citizen: ");
		Scanner input2 = new Scanner(System.in);
		int infectID = input2.nextInt();
		
		int current_infectID = infectID; // We need to keep updating people who need quarantine in later loop, so we need to initialize.
		
		System.out.println("These citizens need to quarantine for 14 days: ");
		
		// If no contactee, we still need to print infectID, so we use do-while loop.
		
		do {
			System.out.print(current_infectID + " "); 
			
			for (int i=0; i < contactee.length; i++) { // Iterate contactee[].
					if (current_infectID == id[i]) {  // When we find the current_infectID in id[i],  
						current_infectID = contactee[i]; // we can correspond to contactee[i], and let it be the next current_infectID. 
						break;                         // Need to break once we find out a contactee[i], or the for loop will keep iterate i+1.
					}
			}
		} while (infectID != current_infectID); // Stop when the contactee's ID = infectID that we enter.

		input.close();
	}
	
}


