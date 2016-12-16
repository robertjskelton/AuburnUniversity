   import java.util.Scanner;	
   import java.util.ArrayList;
	
	/** 
    *	Driver program to guess numbers. 
	 *
	 * @author Robert Skelton
	 * @version 2.28.2012
    */
 
 
   public class NumberGuessingApp {
   /**
   * @param scan inputs the scanner
   *	
   */
      public static void compareNums(Scanner scan) {
         Number h = new Number();
         int numCorrect;
         int numOutOfOrder;
        
         String input = scan.nextLine();
         input = input.toLowerCase();
         while (input.equals("y")) {
            System.out.println("New Game Starting ... ");
            int guessNumber = 1;
            System.out.print("\nGuess #" + guessNumber + ": ");
            String guess = scan.nextLine();
            
            do {
               numCorrect = 0;
               numOutOfOrder = 0;
               ArrayList keyList = new ArrayList <Number>();
               keyList.add(h.getFirstNum());
               keyList.add(h.getSecondNum());
               keyList.add(h.getThirdNum());
               keyList.add(h.getFourthNum());
               ArrayList guessList = new ArrayList();
               guessList.add(guess);
               if (guess.equals("key")) {
                  System.out.println("The Key: " + h);
                  System.out.println("");
                  break;
               }
               
               else if (guess.equals("end")) {
                  System.out.println("The Key: " + h);
                  System.out.println("");
                  break;
               }
               
               else {
                  Scanner scanGuess = new Scanner(guess);
                  int guess1 = scanGuess.nextInt();
                  int guess2 = scanGuess.nextInt();
                  int guess3 = scanGuess.nextInt();
                  int guess4 = scanGuess.nextInt();
                  guessList.add(guess1);
                  guessList.add(guess2);
                  guessList.add(guess3);
                  guessList.add(guess4);
                  for (int i = 0; i < 4; i++) {
                     for (int j = 0; j < 4; j++) {
                        if (keyList.get(i) == guessList.get(j)) {
                           if (i == j) {
                              numCorrect++;
                           }
                           else {
                              numOutOfOrder++;
                           }
                        }
                     
                     }
                  }
                  System.out.println("Correct number, Correct position: " 
                     + numCorrect);
                  System.out.println("Correct number, Wrong position: " 
                     + numOutOfOrder);
                  guessNumber++;
                  System.out.print("\nGuess #" + guessNumber + ": ");
                  guess = scan.nextLine();
               }
               
            } while ((numCorrect != 4));
            
            if (numCorrect == 4) {
               System.out.println("Congratultions! Smart kid!"
                  + " Your answer is correct!");
            }
         	
            System.out.print("Try again?(Y/N): ");
            input = scan.nextLine();
            input = input.toLowerCase();
         }
         
         while (input.equals("n")) {
            System.out.println("Thanks for playing.");
            break;
         }
      	
      }
   
        
         
      
      
   
   /**
   * @param args Unused command line
   */
      public static void main(String[] args) {
      //variables
         
         Scanner scan = new Scanner(System.in);
         ArrayList numberList = new ArrayList < Number >();
      
      //output
         System.out.println("Welcome to COMP 1210 Number Guessing Game");
         System.out.println("\nInput four different numbers between 0 and 0"
            + " separated by one space, \nor input \"key\" or \"end\" at"
            + " any time to see key and end the game.");
         System.out.print("\nStart new game?(Y/N): ");
         compareNums(scan);
               
      }
   }