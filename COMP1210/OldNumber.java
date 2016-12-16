   import java.util.Random;	
	/** 
    *	Creates an object with four random numbers. 
	 *
	 * @author Robert Skelton
	 * @version 2.28.2012
    */

   public class Number {
   //instance variables
      private int firstNumber;
      private int secondNumber;
      private int thirdNumber;
      private int fourthNumber;
      //fields
      int[] digits;
   //constructor
   /**
   * @the constructor
   */
      public Number() {
      
         Random ran = new Random();
         firstNumber = ran.nextInt(10);
         
         while (secondNumber == firstNumber) {
            secondNumber = ran.nextInt(10);
         } 
      	
         while (thirdNumber == firstNumber 
         || thirdNumber == secondNumber) {
            thirdNumber = ran.nextInt(10);
         }
         
         while (fourthNumber == firstNumber 
         || fourthNumber == thirdNumber 
         || fourthNumber == secondNumber) {
            fourthNumber = ran.nextInt(10);
         }
      }
   
   //methods
   //First Number
   /**
   * @return firstNumber returns the first Number
   */
      public int getFirstNum() {
         return firstNumber;
      }
   
   /**
   * @param firstNumberIn inputs the first number
   */
      public void setFirstNum(int firstNumberIn) {
         firstNumber = firstNumberIn;
      }
      
   	//Second Number
   	/**
   	* @return secondNumber returns the second number
      */
      public int getSecondNum() {
         return secondNumber;
      }
   
   /**
   * @param secondNumberIn inputs the second number
   */
      public void setSecondNum(int secondNumberIn) {
         secondNumber = secondNumberIn;
      }
      
   	//Third Number
   	/**
   	* @return thirdNumber returns the third number
      */
      public int getThirdNum() {
         return thirdNumber;
      }
   
   /**
   * @param thirdNumberIn inputs the third number
   */
      public void setThirdNum(int thirdNumberIn) {
         thirdNumber = thirdNumberIn;
      }
      
   	//Fourth Number
   	/**
   	* @return fourthNumber returns the fourth number
      */
      public int getFourthNum() {
         return fourthNumber;
      }
   
   /**
   * @param fourthNumberIn inputs the fourth number
   */
      public void setFourthNum(int fourthNumberIn) {
         fourthNumber = fourthNumberIn;
      }
   	
    
   	//toString method
   	/**
   	* @return the toString output
      */
      public String toString() {
         return firstNumber + " "
            + secondNumber + " "
            + thirdNumber + " "
            + fourthNumber;
      }
   }