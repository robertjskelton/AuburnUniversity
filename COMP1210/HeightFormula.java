   import java.util.Scanner;
	 
	 /** 
    * This program calculates a persons height based on their parents.
	 *
	 * @author Robert Skelton
	 * @version 1.22.2012
    */
	 
   public class HeightFormula {
   
   	 /**
       *
       * @param args Command line arguments (not used).
       */
   
      public static void main(String[] args) {
      //Create variables
         int dadHeight, momHeight, gender;
         double offspringHeightLow, offspringHeightHigh;
         Scanner userInput = new Scanner(System.in);
         
      //Dad's Height
         System.out.print("What is your dad's height, in inches: ");
         dadHeight = userInput.nextInt();
      
      //Mom's Height
         System.out.print("What is your mom's height, in inches: ");
         momHeight = userInput.nextInt();
         
      //Find out gender
         System.out.print("What is your gender, 0=male, 1=female: ");
         gender = userInput.nextInt();
         System.out.println("");
         
         if (gender == 1) {
         
            offspringHeightLow = (.948 * dadHeight + momHeight) / 2;
            offspringHeightHigh = (.980 * dadHeight + momHeight) / 2;
            
            System.out.println("The adult height of the girl is: " 
               + offspringHeightLow + " inches ~ " 
               + offspringHeightHigh + " inches."); 
         }
         
         else {
            offspringHeightLow = (dadHeight + 1.11 * momHeight) / 2;
            offspringHeightHigh = (dadHeight + 1.12 * momHeight) / 2;
            System.out.println("The adult height of the boy is: " 
               + offspringHeightLow + " inches ~ " 
               + offspringHeightHigh + " inches.");
         }	
            
       
      }
   }
      
