//Maanas Devulapalli
//3/29/23
//Wordle
//Created a wordle game using for loops and if statements 

import java.util.Scanner;
public class Wordle {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = 0;
		String guess;
		
		String ans = "FORGE";
		
		System.out.println("Welcome to the better WORDLE:)\nYou have 6 tries to guess the word\nGreen means the letter it is under is in the right spot\nYellow means the letter it is under is in the word but in the wrong spot\nWhite means the letter is not in the word\nGOOD LUCK!\n");
		
		while (x<=6) /*will end after 6 tries*/ {
			
		
		
		System.out.println("\nEnter your five letter guess: ");
		guess = s.nextLine().toUpperCase();
		
		if (guess.length() > 5) {
			System.out.println("You have to enter a word with five letters!");
			break;
		}
		
			System.out.println("-----");
	
			for (int i = 0; i<ans.length(); i++) {
				if (guess.equals(ans)) {
				System.out.println("\u001b[32m" + guess + "\u001b[0;1m"); //Using green text
				break;
			}
				if (ans.indexOf(guess.charAt(i)) == i) {
					System.out.print("\u001b[32m" + guess.charAt(i) + "\u001b[0;1m");} //Using green text				}
			
				else if (!((ans.indexOf(guess.charAt(i))) == -1)) {
					System.out.print("\u001b[33m" + guess.charAt(i) + "\u001b[0;1m"); //Using yellow text 
			}
			
				else {
					System.out.print("\u001b[0m" + guess.charAt(i) + "\u001b[0m"); //Using bright white text
			}	
			
		
		}
		
		
		System.out.println();
		
		x++;
		
		if (guess.equals(ans)) {
			System.out.println("CONGRATULATIONS. You guessed the correct word");
			break; //Breaks out of the while loop
		}
		
		if (x == 6 && !(guess.equals(ans))) {
			System.out.println("\nYOU RAN OUT OF GUESSES!\nBetter luck next time");
			break; 
		}
		}
		
	}
}
	

					


	

	

		

			
		
	

