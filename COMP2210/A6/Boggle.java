   import java.util.*;
   import java.io.*;

/**
 * Boggle.java. Implements a Boggle game engine.
 *
 * @author   Robert Skelton (rjs0015@auburn.edu)  
 *	@author   Dean Hendrix (dh@auburn.edu)
 *	@version  11.18.12
 *
 */

   public class Boggle 
   {
   // initializing things
      private BoggleBoard board;
      private BoggleDictionary dictionary;
      int playerPoints;
      int machinePoints;
      ArrayList<String> playerWords;
      ArrayList<String> machineWords;
      String[][] newBoard = null;
   
    /**
    * Initializes the game to use a random board
    * and default dictionary.
    */
      public Boggle()
      {
      }
   
     /**
    * Initializes the game to use the specified board
    * and the specified dictionary.
    */
      public Boggle(BoggleBoard b, BoggleDictionary d) 
      {
         board = b;
         dictionary = d;
      }
   	
   /**
    * Play the game.
    */
      public void play()
      {
      	// start this damn Boogle game
         setupGame();
         System.out.println("/ / / / / / / / / /");
         System.out.println("Let's play Boggle!\n");
         System.out.println("The board: ");
         displayBoard();
         
      	// user turn
         System.out.println("Your turn: ");
         System.out.println("-------------------");
         userTurn();
         
         // machine turn
         System.out.println("-------------------");
         machineTurn();
         
      	// results
         System.out.println("The results: ");
         System.out.println("-------------------");
         reportResults();
         System.out.println("/ / / / / / / / / /");
      }
   
   /**
    * Initializes values.
    */
      public void setupGame()
      {
         board = new BoggleBoard();
         board.setToRandomBoard();
         if(newBoard != null)
            board.setBoard(newBoard);
         
         board.initDictionary(BoggleDictionary.UNIX);
         playerPoints = 0;
         machinePoints = 0;
         machineWords = board.getAllWords();
      }
      
   /**
    * Print the board to standard out.
    */   
      public void displayBoard() 
      {
         System.out.println(board);
      }
   	
    /**
    * Play the user's turn.
    */   
      public void userTurn()
      {
         System.out.println("Find all the words you can, good luck!"
            + "\n" + "Type || to finish.");
         Scanner scan = new Scanner(System.in);
         String line;
         playerWords = new ArrayList();
         while(!(line = scan.nextLine()).equals("||"))
         {
            int points = board.getPoints(line);
            if (board.possibleWord(line))
            {
               System.out.println(line + " is a valid word worth " + points + " points.");
               playerPoints += board.getPoints(line);
               playerWords.add(line);
            }
            else
               System.out.println(line + " is not in this dictionary.");
         }
         System.out.println("Good try, let's watch the computer win.");
      }
   	
   /**
    * Play the machine's turn.
    */
      public void machineTurn()
      {
         System.out.println("Machine turn:");
         for (int i = 0; i < machineWords.size(); i++)
         {
            System.out.println(machineWords.get(i) + " is a valid word worth " + board.getPoints(machineWords.get(i)) + " points.");
            machinePoints += board.getPoints(machineWords.get(i));
         }
      }
   	
   /**
    * Display the game results.
    */	
      public void reportResults()
      {
         System.out.println("RESULTS!");
         System.out.println("User words: " + playerWords);
         System.out.println("Machine words: " + machineWords);
         System.out.println("User points: " + playerPoints);
         System.out.println("Machine points: " + machinePoints);
         if(machinePoints > playerPoints)
            System.out.println("The machine won, as expected.");
         
         else if(machinePoints < playerPoints)
            System.out.println("You won, there must be an error.");
         
         else
            System.out.println("You tied, which pretty much means you win.");
      }
   	
   /**
    * Return a list of valid words identified by the user.
    */   
      public ArrayList<String> getUserWords() 
      {
         return playerWords;
      }
   	 
   /**
    * Return a list of valid words identified by the machine.
    */   
      public ArrayList<String> getMachineWords() 
      {
         return board.getAllWords();
      }
        
   /**
    * Return the score of a list of valid words.
    */   
      public int getScore(String words) 
      {
         return board.getPoints(words);
      }
   		
   /**
    * Play an example game.
    */	
      public static void main (String[] args)
      {
         Boggle boggle = new Boggle();
         if(args.length > 0)
         {
            boggle.newBoard = new String[4][4];
            System.out.println(args[0]);
            int i = 0;
            try
            {
               Scanner s = new Scanner(new File(args[0]));
               while(s.hasNextLine())
               {
                  String line = s.nextLine();
                  boggle.newBoard[i][0] = line.charAt(0) + "";
                  boggle.newBoard[i][1] = line.charAt(1) + "";
                  boggle.newBoard[i][2] = line.charAt(2) + "";
                  boggle.newBoard[i][3] = line.charAt(3) + "";
                  i++;
               }
            }
               catch(Exception e)
               {
                  System.out.println("NOPE");
               }
         }
         boggle.play();
      }	
   }