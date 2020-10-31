package com.openclassrooms;

public class TP1 {

	public static void main(String[] args) {
		
		//Generates a random number.
		
		java.util.Random rng = new java.util.Random();

        //"mysteryNb": Stores a randomly generated number between 1 and 100 included.           

		Integer mysteryNb = rng.nextInt(101)+1;
			
		System.out.println("Trouvez le nombre mystère. Choisissez un nombre entre 1 et 100:");
		
		//Retrieves the number selected by the user.       

		java.util.Scanner scanner = new java.util.Scanner(System.in);

        //"userGuess" : Stores the number given by the user.   
		
		Integer userGuess = Integer.decode(scanner.nextLine());
	
		while (mysteryNb != userGuess) {
			
			if (userGuess < mysteryNb) {
				
				System.out.println("Trop petit. Choisissez un nombre plus grand:");
				
			} else if (userGuess > mysteryNb) {
				
				System.out.println("Trop grand. Choisissez un nombre plus petit:");
				
			}
					
			userGuess = Integer.decode(scanner.nextLine());
			
		};
		
		System.out.println("Bien joué! Le nombre mystère est bien " + mysteryNb + ".");
	
	}

}
