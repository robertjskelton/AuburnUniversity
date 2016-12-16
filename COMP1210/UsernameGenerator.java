   import java.util.Scanner;
   import java.util.Random;
	
	 /** 
    *	This is a username generator program.
	 *
	 * @author Robert Skelton
	 * @version 1.29.2012
    */
	 
   public class UsernameGenerator {
    	 /**
       *
       * @param args Command line arguments (not used).
       */
   
      public static void main(String[] args)
      {
      //Initialize variables
         Scanner userInput = new Scanner(System.in);
         String firstName = "";
         String lastName = "";
         String username = "";
         
      	//Create the random number between 100 and 999
         Random generator = new Random();
         int random;
         random = generator.nextInt(900) + 100;
      	
      //Get first name, find out letters for username
         System.out.println("What is your first name: ");
         firstName = userInput.nextLine();
         String firstName1 = firstName.substring(0, 1);
         int length;
         String firstName3;
         length = firstName.length();
         if (length >= 3) {
            firstName3 = firstName.substring(2, 3); 
         }
         else  if (length == 2) {
            firstName3 = firstName.substring(1, 2);
            //firstName.charAt(firstName.length()-1);
            //x.charAt(x.length()-1);
         }
         else {
            firstName3 = firstName1;
         }
      	 
      //Get last name, find out letters for username
         System.out.println("What is your last name: ");
         lastName = userInput.nextLine();
         String lastName1 = lastName.substring(0, 1);
         
      //Create username, make it all lowercase
         username = firstName1 + firstName3 + lastName1 + random;
         username = username.toLowerCase();
      
      //Initialize password
         System.out.println("Enter your password: ");
         String password = userInput.nextLine();
       
      //Confirm the password
         System.out.println("Re-enter your password: ");
         String passwordConfirm = userInput.nextLine();
      
      //Final output
         if (password.equals(passwordConfirm)) {
            System.out.println("\r\nWelcome " + firstName + " " + lastName
               + "!");
            System.out.println("Your username is " + username);
            System.out.println("Your password is " + password);
         }
         
         else {
            System.out.println("\rFailed to set up the new user's login"
               + " information.");
         }
      } 
   }