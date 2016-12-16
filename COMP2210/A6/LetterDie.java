   import java.util.Random;

/**
 * LetterDie.java. Models a single six-sided letter die
 * used in a Boggle game.
 *
 * @author   Robert Skelton (rjs0015@auburn.edu)  
 *	@author   Dean Hendrix (dh@auburn.edu)
 *	@version  11.18.12
 *
 */

   public class LetterDie {
   
      private String[] sides;             // the six sides of the die
      private int currentSideUp;          // which side is up?
      private Random rng = new Random();  // use to simulate die toss
   
   /**
    * Create a new die and randomly pick the side that's up.
    */
      public LetterDie(String side1, String side2, String side3,
               String side4, String side5, String side6) {
         sides = new String[] {side1,side2,side3,side4,side5,side6};
         toss();
      }
   
   /**
    * Return the letter that's showing.
    */
      public String getLetter() {
         return sides[currentSideUp];
      }
     
   /**
    * Tosses the die then returns what is racing up
    */ 
      public String getRandomFace() {
         toss();
         return sides[currentSideUp];
      }
   	
   /**
    * Toss the die to make a random letter show.
    */
      public void toss() {
         currentSideUp = rng.nextInt(6);
      }
   }