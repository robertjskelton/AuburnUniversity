	 /** 
    *	This is the class to find out about a desired number. 
	 *
	 * @author Robert Skelton
	 * @version 2.19.2012
    */
 
   public class NumberOperations {
   //instance variables
      private int number;
   
       /**
       * @param numberIn inputs a number
       */
   //constructor
      public NumberOperations(int numberIn) {
         number = numberIn;
      }
      
   	//methods
       /**
       * @return number returns the number
       */
      public int getValue() {
         return number;
      }
      
       /**
       * @return output Returns the output.
       */
      public String oddsUnder() {
         String output = "";
         int i = 0;
         while (i < number) {
            if (i % 2 != 0) {
               output += i + "\t";
            }
            i++;
         }
         return output;
      }
   	
       /**
       * @return output Returns the powers two under
       */
      public String powersTwoUnder() { 
         String output = "";
         int powers = 1;
         while (powers < number) {
            output += powers + "\t";
            powers = powers * 2;
         }
         return output;
      }
   
       /**
       * @param compareNumber number you compare
   	 * @return int
       */
      public int isGreater(int compareNumber) {
         if (number > compareNumber) {
            return 1;
         } 
         else if (number < compareNumber) {
            return -1;
         }
         else {
            return 0;
         }
      }
      
       /**
       * @return number
       */
      public String toString() {
         return number + "";
      }
   }
   
   
