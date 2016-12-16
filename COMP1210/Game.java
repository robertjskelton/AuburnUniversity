   /** 
    * Game class to guess a number. 
	 *
	 * @author Robert Skelton
	 * @version 3.9.2012
    */
   
   
   public class Game {
   
   //instance variables
      private Number n;
      private boolean gameOver = false;
   
   //constructor
   /**
   	 * @param nIn enters n
       */
      public Game(Number nIn) {
         n = nIn;
      
      }
   
   //methods
   /**
   	 * @return nothing
       */
      public String start() {
         return "Enter a number consisting of " + n.getNumberDigits()
            + " different digits "
            + "with no spaces or enter \"key\""
            + " or \"end\" anytime to see key"
            + " and end the game.";
      }
      
   	/**
   	 * @param userGuessIn inputs users guess
       * @return String result
       */
      public String play(String userGuessIn) {
         int a = userGuessIn.length();
         int[] actualNumber = new int[a];
         String number = "";
         String returner = "";
         int numCorrect = 0;
         int numOutOfOrder = 0;
        
         for (int f = 0; f < n.getNumberDigits(); f++) {
            number = number + n.getDigit(f);
         }
      
         do { 
            if (a == n.getNumberDigits()) {
               gameOver = false;
               for (int i = 0; i < n.getNumberDigits(); i++) {
                  String answer = n.toString();
                  char guessNumber = userGuessIn.charAt(i);
                  for (int k = 0; k < n.getNumberDigits(); k++) {
                     if (guessNumber == answer.charAt(k)) {
                        if (i == k) {
                           numCorrect++;
                        }
                        else {
                           numOutOfOrder++;
                        }
                     
                     }
                  	
                  }
                  
               }
               if (numCorrect == n.getNumberDigits()) {
                  gameOver = true;
                  return "Congratulations! Smart kid!"
                        + " Your answer is correct.";
               } 
               else {
                  gameOver = false;
                  return "Correct number, Correct "
                     + "position: " + numCorrect
                     + "\nCorrect number, Wrong position: "
                     + numOutOfOrder;
               }
            }
            
            else if (userGuessIn.equals("key")) {
               gameOver = true; 
               return "The key: " + number; 
            }
            else if (userGuessIn.equals("end")) {
               gameOver = true; 
               return "The key: " + number; 
            }
            
            else if (a != n.getNumberDigits()) {
               gameOver = false;
               return "Your guess should have "
                  + n.getNumberDigits() + " digits.";
            }
         
         } while (gameOver);
       
         return "sddf";
      }
      
   	/**
   	 * @return boolean if its game over
       */
      public boolean isGameOver() {
         return gameOver;
      }
      
   	/**
   	 * @return String end string
       */
      public String end() {
         return "Thanks for playing.\n";
      }
      
   	/**
   	 * @param i placeholder
       * @return boolean true or false
       */
      public boolean inArray(int i)
      {
         for (int j = 0; j < n.getNumberDigits(); j++) {
            if (i == n.getDigit(j)) {
               return true;
            }
         }
         return false;
         
      }
   }