import java.util.Scanner;

public class CryptographyProject {
		

	static Scanner s = new Scanner(System.in); //Scanner will be used for whole program which is why it is static 
	
	public static void choice() {
	
		System.out.println("AtBash(type 'atbash') or CaesarShift(type 'caesar') or rot-13(type 'rot'): ");
		String choice = s.next(); //User chooses AtBash or Caesar 
		String choice2 = s.nextLine();
		//System.out.println("choice = " + choice);
		//System.out.println("choice2 = " + choice2);
		
		choice = choice+choice2;
		

		//CaesarShift method will be used
		if (choice.equals("caesar")) {
			System.out.println("Encrypt(press 'e') or Decrypt(press 'd')"); 
			String choice1 = s.nextLine(); //Choosing encrypt or decrypt 
			if (choice1.equals("e")){
				CaesarShiftE(); //Calls the encrypt method
			}
			
			if (choice1.equals("d")) {
				CaesarShiftD(); //Calls the decrypt method 
			}
			
		}
		
		//AtBash method will be used
		if (choice.equals("atbash"))  {
			AtBash(); //Calls the AtBash method 
		}
		
		if (choice.equals("rot")) {
			System.out.println("Encrypt(press 'e') or Decrypt(press 'd')"); 
			String choice1 = s.nextLine(); //Choosing encrypt or decrypt 
			if (choice1.equals("e")){
				rotE(); //Calls the encrypt method
			}
			
			if (choice1.equals("d")) {
				rotD(); //Calls the decrypt method 
			}
			
		}

	}
	
	//Caesar method(encryption and decryption chosen in method)
	
	//Encrypting method 
	public static void CaesarShiftE() {
	
		String choice = "e";
		
		if (choice.equals("e")) {
			System.out.println("Enter a word/phrase you want to encrypt: "); 
			String word = s.nextLine(); //Word to encrypt 
			
			System.out.println("\nEnter the shift key): "); 
			int shift = s.nextInt(); //Shift key
			
			shift = shift%26; //So that any shift value can be used and work 

			for (int i = 0; i<word.length(); i++) {
				if (word.charAt(i) == 32) { //Prints spaces as is 
					System.out.print(word.charAt(i));
				}
				else if  ((word.charAt(i) >=65 && word.charAt(i) <=90)) { //If the char is uppercase(EC challenge #1)
					if (word.charAt(i) + shift > 90) { //If the char plus shift is greater than 90
						System.out.print((char)(word.charAt(i) + shift - 26));
					}
					else { 
						System.out.print((char)(word.charAt(i) + shift));
					}
				}
				
				
				else if ((word.charAt(i) >=97 && word.charAt(i) <=122)) { //If the char is lowercase 
					if (word.charAt(i) + shift > 122) { //If the char plus shift is greater than 122 
						System.out.print((char)(word.charAt(i) + shift - 26));
					}
					else {
						System.out.print((char)(word.charAt(i) + shift));
					}
				}
				
				//If it isn't a letter the value will be printed the same as it is inputted(EC challenge #2)
				else if (!((word.charAt(i) >=97 && word.charAt(i) <=122) || (word.charAt(i) >=65 && word.charAt(i) <=90))) {
					System.out.print(word.charAt(i));
				}
			}
			
			
		}
		repeat(); //Gives user opportunity to run code again 
	}
	
	
	//Decrypting method 	
	public static void CaesarShiftD() {
			
		String choice = "d";
		
		if (choice.equals("d")) { //If user chose to decrypt 
			System.out.println("Enter a word/phrase you want to decrypt: "); 
			String word = s.nextLine(); //Word that will be decrypted
			
			System.out.println("\nEnter the shift key: "); 
			int shift = s.nextInt(); //Shift key saved here 
			
			shift = shift%26; //So any shift value can be used and will work 
			
			for (int i = 0; i<word.length(); i++) {
				if (word.charAt(i) == 32) { //Spaces will be printed as is 
					System.out.print(word.charAt(i));
				}
				else if ((word.charAt(i) >=65 && word.charAt(i) <=90)) { //If it is uppercase(EC challenge #1)
					if (word.charAt(i) - shift < 65) {
						System.out.print((char)(word.charAt(i) - shift + 26)); //Adding 26 to loop through alphabet 
					}
					else {
						System.out.print((char)(word.charAt(i) - shift));
					}
				}
				
				else if ((word.charAt(i) >=97 && word.charAt(i) <=122)) { //If it is lowercase
					if (word.charAt(i) - shift < 97) {
						System.out.print((char)(word.charAt(i) - shift + 26)); //Adding 26 to loop through alphabet
					}
					else {
						System.out.print((char)(word.charAt(i) - shift));
					}
				}
				
				//If it isn't a letter, shift will not be used on it 
				else if (!((word.charAt(i) - shift >=97 && word.charAt(i) - shift <=122) || (word.charAt(i) - shift >=65 && word.charAt(i) - shift <=90))) {
					System.out.print(word.charAt(i));
				}
			}
		}
		repeat(); //Gives user opportunity to run code again 
	}
		
	
		
	
	

	
	//AtBash method(encryption and decryption chosen in method 
	public static void AtBash() {
		System.out.println("Enter a word/phrase: ");
		String word = s.nextLine(); //Phrase entered 
		
		int key; //Represents the difference between the 'z'/'Z' index and the "diff" value 
		int diff; //Shows the difference between the char and 97(represents 'a')
		
		for (int i = 0; i<word.length(); i++) {
			if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
				diff = word.charAt(i) - 97;
				
				key = 'z' - diff;
				
				System.out.print((char)key); //Prints the value after AtBash cipher used(e.g. a becomes z)
			}
			
			else if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
				diff = word.charAt(i) - 65;
				
				key = 'Z' - diff;
				
				System.out.print((char)key); //Prints value after AtBash cipher 
			}
			
			else {
				System.out.print(word.charAt(i)); //If it isn't a letter print as is 
			}
			
		}
		
		repeat(); //Gives user opportunity to run code again 
	}
	
	//Encrypting method 
	public static void rotE() {
		String choice = "e";
		
		if (choice.equals("e")) {
			System.out.println("Enter a word/phrase you want to encrypt: "); 
			String word = s.nextLine(); //Word to encrypt 
			
			int shift = 13; //Always 13 for rot 
			
			for (int i = 0; i<word.length(); i++) {
				if (word.charAt(i) == 32) { //Prints spaces as is 
					System.out.print(word.charAt(i));
				}
				else if  ((word.charAt(i) >=65 && word.charAt(i) <=90)) { //If the char is uppercase(EC challenge #1)
					if (word.charAt(i) + shift > 90) { //If the char plus shift is greater than 90
						System.out.print((char)(word.charAt(i) + shift - 26));
					}
					else { 
						System.out.print((char)(word.charAt(i) + shift));
					}
				}
				
				
				else if ((word.charAt(i) >=97 && word.charAt(i) <=122)) { //If the char is lowercase 
					if (word.charAt(i) + shift > 122) { //If the char plus shift is greater than 122 
						System.out.print((char)(word.charAt(i) + shift - 26));
					}
					else {
						System.out.print((char)(word.charAt(i) + shift));
					}
				}
				
				//If it isn't a letter the value will be printed the same as it is inputted(EC challenge #2)
				else if (!((word.charAt(i) >=97 && word.charAt(i) <=122) || (word.charAt(i) >=65 && word.charAt(i) <=90))) {
					System.out.print(word.charAt(i));
				}
			}
			
			
		}
		repeat(); //Gives user opportunity to run code again 
	}
	
	//Decrypting method 	
	public static void rotD() {
		String choice = "d";
		
		if (choice.equals("d")) { 
			System.out.println("Enter a word/phrase you want to decrypt: "); 
			String word = s.nextLine(); //Word that will be decrypted
			
			int shift = 13; //Always 13 for rot 
					
			for (int i = 0; i<word.length(); i++) {
				if (word.charAt(i) == 32) { //Spaces will be printed as is 
					System.out.print(word.charAt(i));
				}
				else if ((word.charAt(i) >=65 && word.charAt(i) <=90)) { //If it is uppercase(EC challenge #1)
					if (word.charAt(i) - shift < 65) {
						System.out.print((char)(word.charAt(i) - shift + 26)); //Adding 26 to loop through alphabet 
					}
					else {
						System.out.print((char)(word.charAt(i) - shift));
					}
				}
				
				else if ((word.charAt(i) >=97 && word.charAt(i) <=122)) { //If it is lowercase
					if (word.charAt(i) - shift < 97) {
						System.out.print((char)(word.charAt(i) - shift + 26)); //Adding 26 to loop through alphabet
					}
					else {
						System.out.print((char)(word.charAt(i) - shift));
					}
				}
				
				//If it isn't a letter, shift will not be used on it 
				else if (!((word.charAt(i) - shift >=97 && word.charAt(i) - shift <=122) || (word.charAt(i) - shift >=65 && word.charAt(i) - shift <=90))) {
					System.out.print(word.charAt(i));
				}
			}
		}
		repeat(); //Gives user opportunity to run code again 
	}
	
	public static void repeat() {
		
		System.out.println("\n\nWould you like to run the code again?('y' for yes and 'n' for no): ");
		String choice = s.next();
		
		if (choice.equals("y")) {
			choice();
		}
		
		else {
			System.out.println("Thanks!");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		choice();//Runs choice method in main method
				 //Choice method is what calls all the cipher methods so it is all that needs to be called 
		
		
}
}
