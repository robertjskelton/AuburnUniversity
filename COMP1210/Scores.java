/** 
    *	Number operations class.
	 *
	 * @author Robert Skelton
	 * @version 3.4.2012
    */


   public class Scores {
   //instance variables
      private static int[] numbers;
   
   //constructor
      public Scores(int[] numbersIn) {
         numbers = numbersIn;
      }
       
   	 //methods
   	 //NOT WORKING
      public int[] findEvens() {
         int numberEvens = 0;
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
               numberEvens++;
            }
         }
         int count = 0;
         int[] evens = new int[numberEvens];
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
               evens[count] = numbers[i];
               count++;
            }
         }
         return evens;
      }
      
      public int[] findOdds() {
         int numberOdds = 0;
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
               numberOdds++;
            }
         }
         int count = 0;
         int[] odds = new int[numberOdds];
         for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
               odds[count] = numbers[i];
               count++;
            }
         }
         return odds;
      }
      
      public double calculateAverage() {
         int sum = 0;
         for (int i = 0; i< numbers.length; i++) {
            sum += numbers[i];
         }
         return (double)sum/numbers.length;
      }
      
   	//toReverseStrings
      public String toReverseString() {
         String output = "";
         for (int i = numbers.length - 1; i >= 0; i--) {
            output += numbers[i] + "\t";
         }
         return output;
      }
      
   	//toString
      public String toString() {
         String output = "";
         for (int i = 0; i < numbers.length; i++) {
            output += numbers[i] + "\t";
         }
         return output;
      }
   
   }