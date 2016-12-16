   import java.util.Scanner;

   /** 
    * Prints your name, age, and finds a maximum heart rate. 
	 *
	 * @author Robert Skelton
	 * @version 1.22.2012
    */
	 
   public class AgeStatistics {
   
   	 /**
       *
       * @param args Command line arguments (not used).
       */
   
      public static void main(String[] args) {
      
      //Create variables
         String name;
         int ageInYears;
         int gender = 0; //1=female 
         double maxHeartRate = 0;
         Scanner userInput = new Scanner(System.in);
      
      //Get the name
         System.out.print("Enter your name: ");
         name = userInput.nextLine();
         
      //Get the age
         System.out.print("Enter your age in years:  ");
         ageInYears = userInput.nextInt();
         
      //Get the gender   
         System.out.print("Enter your gender (1 for female, 0 for male): ");
         gender = userInput.nextInt();
      
            
      //Convert age
         System.out.println("\t Your age in minutes is "  
            + 525600 * ageInYears + " minutes.");
         System.out.println("\t Your age in centuries is "  
            + (double) ageInYears / 100 + " centuries.");
            
      //Display max heart rate
         if (gender == 1) {
            maxHeartRate = 209 - (.7 * ageInYears);
         }
         else {
            maxHeartRate = 214 - (.8 * ageInYears);
         }
         System.out.println("Your max heart rate is " + maxHeartRate
            + " beats per minute.");
      
      
      
      
      
      		
      
      
      }
   
   }
