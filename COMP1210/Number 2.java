   import java.util.Random;
   //import java.util.Arrays;

	 /** 
    * A number class that can create a 9 digit number. 
	 *
	 * @author Robert Skelton
	 * @version 3.9.2012
    */

   public class Number {
   //instance variables
      private int lengthNumber;
      private int[] digits;
      private int indexDigit;
      private int valueDigit;
      private Random ran = new Random();
         
   //constructor
   	 /**
       * @param lengthNumberIn the length of the array
       */
      public Number(int lengthNumberIn) {
         lengthNumber = lengthNumberIn;
         digits = new int[lengthNumber];
         //while(digits.length < lengthNumber) {
         for (int i = 0; i < lengthNumber; i++) {  	
            boolean add = true;
            int temp;
         
            do {
               add = true;
               temp = (int) (ran.nextInt(10));
               for (int j = 0; j < lengthNumber; j++)
               {
                  if (digits[j] == temp) {
                     add = false;
                  }		
               }
            } while(!add);	
            if (add) {
               digits[i] = temp;	  
            } 
         }
      } 
      
   	//methods
   	/**
       * @return lengthNumber returns the length
       */
      public int getNumberDigits() {
         return lengthNumber;
      }
   	
   	 /**
   	 * @param indexDigitIn the digit to change
       * @param valueDigitIn the number to change to
       */
      public void setDigit(int indexDigitIn, int valueDigitIn) {
         digits[indexDigitIn] = valueDigitIn;
      }
      
   	/**
   	 * @param digitIn inputs a digit
       * @return digits[digitIn] returns this new array
       */
      public int getDigit(int digitIn) {
         return digits[digitIn];
      }
   	
   	//toString method
   	/**
       * @return string1 the modified String of an array
   	 */
      public String toString() {
         String string1 = "";
         for (int f = 0; f < getNumberDigits(); f++) {
            string1 = string1 + getDigit(f);
         }
         return string1;
      }
   
   }