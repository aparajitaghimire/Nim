import java.util.Scanner; 
import java.lang.Math;

public class Nim {

/**
 * Check user input. 
 * pre: none.
 * post: true returned if entry is valid, false returned otherwise.
 */
 public static boolean isValidEntry(int allStones, int userStones) {
 	if (userStones > allStones) {
 		return(false);
 	} else if (userStones > 3 || userStones <= 0) {
 		return(false);
 	} 
 		return(true);	
 }

/**
 * Ask user for input, check if input is valid, calculate total stones.
 * pre: totalStones > 0
 * post: total number of stones remaining returned. 
 */
 public static int userMove(int totalStones) {
 	boolean valid;
 	int userInput;
 	Scanner input = new Scanner(System.in);	 	
 	
 	System.out.print("There are " + totalStones + " stones. How many would you like? ");
 	userInput = input.nextInt();
 	valid = isValidEntry(totalStones, userInput); 		
 	
 	while (valid == false) {
 		System.out.print("Invalid entry, try again. There are " + totalStones + " stones. How many would you like? ");
 		userInput = input.nextInt();
 		valid = isValidEntry(totalStones, userInput);
 	}	 	
 		totalStones = totalStones - userInput;
 		return(totalStones);
 }
 
 /**
  * Determine a random number between 1 and 3.
  * pre: none
  * post: a random number between 1 and 3 is returned.
  */
 public static int drawStones(int allStones) {
 	int computerStones;
 	
 	computerStones = (int)(3 * Math.random() + 1);
 	
 	while (computerStones > allStones) {
 		computerStones = (int)(3 * Math.random() + 1);
 	}
 		return(computerStones);
 }
 
 /**
  * Calculate number of stones remaining after computer's turn.
  * pre: totalStones > 0
  * post: number of stones remaining is returned.
  */
  public static int computerMove(int totalStones) {
  	int computerStones;
  	
  	computerStones = drawStones(totalStones);
  	totalStones = totalStones - computerStones; 
  	return(totalStones);	
  }

public static void main(String[] args) {
	int stones; 
	int computerStonesTaken;
	int stonesAfterComputer;
	boolean over = false;

	stones = (int)(16 * Math.random() + 15);

	while (over != true) {
		stones = userMove(stones);
		
		if (stones == 0) {
			over = true;
			System.out.println("The computer beats the player!");
		}
		
		stonesAfterComputer = computerMove(stones); 
		computerStonesTaken = stones - stonesAfterComputer; 

		System.out.println("There are " + stones + " stones. The computer takes " + computerStonesTaken + " stones."); 
		stones = stonesAfterComputer;
		
		if (stones == 0) {
			over = true;
			System.out.println("The player beats the computer!");	
		}    		
	}
}
}
