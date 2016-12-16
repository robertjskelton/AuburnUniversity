   import java.util.Scanner;

/** 
    * Main method to guess a number.
	 *
	 * @author Robert Skelton
	 * @version 3.9.2012
    */


   public class EnhancedNumberGuessingApp {
   /**
   	 * @param args Unused command line
       */
      public static void main(String[] args) {
      //instance variables
         Scanner scan = new Scanner(System.in);
         int n;
         String userGuess; 
         String newGame;
      //output
         System.out.println("Welcome to COMP 1210 Enhanced"
            + " Number Guessing Game.\n");
         System.out.println("The enhanced game allows you"
            + " to enter the number of digits for the computer's"
            + " number.\nIncreasing the number of digits makes the"
            + " game more difficult to win.");
         System.out.print("\nStart a new game?(Y/N): ");
         newGame = scan.nextLine();
         int guessNumber = 1;
         do {
            newGame = newGame.toLowerCase();
            do {
               System.out.print("Enter number of digits (1 to 9): ");
               n = scan.nextInt();
               
            } while (n < 1 || n > 9); 
            
            Number nums = new Number(n);
            Game game = new Game(nums);
            
            System.out.println("\nEnter a number consisting of " 
               + n + " different digits "
               + "with no spaces\nor enter \"key\""
               + " or \"end\" anytime to see key"
               + " and end the game.");
              
            do {
               System.out.print("\nGuess #" + guessNumber + ": ");
               userGuess = scan.next();
               System.out.println(game.play(userGuess));
               
               guessNumber++;
               
               
            } while(!game.isGameOver());
            
            System.out.print("\nStart new game?(Y/N): ");
            newGame = scan.next();
            newGame = newGame.toLowerCase();
         } while (newGame.equals("y"));
       
      
         if (newGame.equals("n")) {
            System.out.println("\nThanks for playing.");
         }
      
      
      }
   
   }