   import java.util.*;

/**
 * BoggleBoard.java. Models a Boggle board.
 *
 * @author   Robert Skelton (rjs0015@auburn.edu)  
 *	@author   Dean Hendrix (dh@auburn.edu)
 *	@version  11.18.12
 *
 */
 
   public class BoggleBoard
   {
    // sample board   
      public static String[][] SAMPLE_BOARD = {               
         		{"E","E","C","A"},
         		{"A","L","E","P"},
         		{"H","N","B","O"},
         		{"Q","T","T","Y"}
         		};
   
   // initialize things
      private String[][] board;
      private boolean[][] visit = new boolean[10][10];
      private ArrayList<LetterDie> dice; // letter dice used on board
      private ArrayList<String> humanList;
      private ArrayList<String> machineList;
      private ArrayList valid = null;
      private int N = 4; // default board dimesion
      BoggleDictionary dictionary;
   
   /**
    * Create a new 4x4 BoggleBoard with a random
    * letter die arrangement. This should simulate
    * the shuffling of the board that would occur in
    * a physical game.
    */
      public BoggleBoard()
      {
         initStandardDice();
         setToSampleBoard();
      }
     
    /**
    * Sets the board to a random board..
    */ 
      public void setToRandomBoard()
      {
         for(int i = 0; i < N; i++)
         {
            for(int j = 0; j < N; j++)
            {
               board[j][i] = dice.get(j * N + i).getRandomFace();
            }
         }
      }
   
   /**
    * Returns points for a given word, according to Boggle rules.
    */	
      public int getPoints(String str)
      {
         if(str.length() == 0)
            return 0;
            
         if(str.length() == 1)
            return 0;
            
         if(str.length() == 2)
            return 0;
            
         if(str.length() == 3)
            return 1;
            
         if(str.length() == 4)
            return 1;
            
         if(str.length() == 5)
            return 2;
            
         if(str.length() == 6)
            return 3;
            
         if(str.length() == 7)
            return 5;
         else   
            return 11;	
      }
   	
   /**
    * Sets the board to SAMPLE_BOARD.
    */
      public void setToSampleBoard()
      {
         board = SAMPLE_BOARD;
      }
      
   /**
    * Finds all words that the machine will see.
    */
      public void findWords(String in, int x, int y, List<Integer> visit)
      {
         machineList = new ArrayList<String>();
         if (isValidCell(x, y) == false || visit.contains(y * N + x))
            return; 
      	
         String temp = in + getLetter(y, x).toLowerCase();
         if(dictionary.containsAsPrefix(temp))
         {
            String out = in + getLetter(y, x).toLowerCase();
            List<Integer> newVisit = new ArrayList<Integer>(visit);
            newVisit.add(y * N + x);
            if(out.length() > 2)
            {
               if(dictionary.isWord(out))
               {
                  valid.add(out);
               }
            }
         
            findWords(out, x + 1, y + 1, newVisit);
            findWords(out, x - 1, y - 1, newVisit);
            findWords(out, x, y + 1, newVisit);
            findWords(out, x + 1, y - 1, newVisit);
            findWords(out, x - 1, y + 1, newVisit);
            findWords(out, x, y - 1, newVisit);
            findWords(out, x + 1, y, newVisit);
            findWords(out, x - 1, y, newVisit);
         }
      }
   
   /**
    * Checks to see if a guess is in the dictionary. 
    */	
      public boolean possibleWord(String word)
      {
         return valid.contains(word);
      }
   	
   /**
    * Gets all correctly entered words.
    */
      public ArrayList getAllWords()
      {
         this.valid = new ArrayList();
         for(int i = 0; i < N; i++)
         {
            for(int j = 0; j < N; j++)
            {
               this.findWords("", j, i, new ArrayList<Integer>());
            }
         }	
         return valid;
      }
   	
   /**
    * Sets the board to one of your choice.
    */
      public void setBoard(String[][] board)
      {
         board = board;
      }
      
   	 /**
    * Return the (i,j) letter on the board. The top-left
    * of the board is (0,0). If row or col has an illegal
    * value, this method throws an IllegalArgumentException.
    */ 
      public String getLetter (int row, int col)
      {
         return board[row][col];
      }
      
   /**
    * Checks to see if (row, col) exists on the board.
    */
      public boolean isValidCell (int row, int col)
      {
         return ((row >= 0) && (row < size()) && (col >= 0) && (col < size()));
      }
   	
   /**
    * Returns the size, N, of the board.
    */
      public int size()
      {
         return N;
      }
   	
   	 /**
    * Create a new BoggleBoard with a specified
    * letter die arrangement. If the grid is null
    * or if the grid is not square, this method
    * throws an IllegalArgumentException.
    */
      public BoggleBoard(String[][] grid) {
         if (grid == null) 
            throw new NullPointerException();
         if (grid.length != grid[0].length) 
            throw new IllegalArgumentException();
            
         initStandardDice();
         board = grid;
         N = grid.length;
      }
      
   /**
    * Prints out the board used in this game. 
    */
      public void printBoard()
      {
         System.out.println("\n* * * *");
         for (int i = 0; i < N; i++)
         {
            for (int j = 0; j < N; j++)
               System.out.print (board[i][j] + " ");
            System.out.println();
         }
         System.out.println("* * * *\n");
      }
      
   /**
    * Return a String representation of the board.
    */
      private void initStandardDice()
      {
         dice = new ArrayList<LetterDie>();
         dice.add(new LetterDie("F", "O", "R", "I", "X", "B"));
         dice.add(new LetterDie("M", "O", "Q", "A", "B", "J")); // should have QU
         dice.add(new LetterDie("G", "U", "R", "I", "L", "W"));
         dice.add(new LetterDie("S", "E", "T", "U", "P", "L"));
         dice.add(new LetterDie("C", "M", "P", "D", "A", "E"));
         dice.add(new LetterDie("A", "C", "I", "T", "A", "O"));
         dice.add(new LetterDie("S", "L", "C", "R", "A", "E"));
         dice.add(new LetterDie("R", "O", "M", "A", "S", "H"));
         dice.add(new LetterDie("N", "O", "D", "E", "S", "W"));
         dice.add(new LetterDie("H", "E", "F", "I", "Y", "E"));
         dice.add(new LetterDie("O", "N", "U", "D", "T", "K"));
         dice.add(new LetterDie("T", "E", "V", "I", "G", "N"));
         dice.add(new LetterDie("A", "N", "E", "D", "V", "Z"));
         dice.add(new LetterDie("P", "I", "N", "E", "S", "H"));
         dice.add(new LetterDie("A", "B", "I", "L", "Y", "T"));
         dice.add(new LetterDie("G", "K", "Y", "L", "E", "U"));
      }
   	
   /**
    * Creates a new dictionary with a file name only. 
    */
      public void initDictionary(String file)
      {
         dictionary = new BoggleDictionary();
         dictionary.loadWords(file);
      }
      
   /**
    * Return a String representation of the board.
    */	
      public String toString() {
         StringBuilder s = new StringBuilder();
         s.append("* * * *\n");   
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) 
               s.append(board[i][j] + " ");
            s.append("\n");
         }
         s.append("* * * *");
         return s.toString();
      }
   }