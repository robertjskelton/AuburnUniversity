   import java.util.Scanner;
	 
	 /** 
    *	This program is a message converter.
	 * It will convert messages to a variety of other string.
	 *
	 * @author Robert Skelton
	 * @version 1.29.2012
    */
	 
	 
   public class MessageConverter {
    /**
       *
       * @param args Command line arguments (not used).
       */
   
      public static void main(String[] args)
      {
         String message;
         String result = "";
         int outputType;
      
         Scanner userInput = new Scanner(System.in);
         System.out.print("Enter a message and press enter:\r\n\t> ");
         message = userInput.nextLine();
         System.out.println("\r\nOutput types: "
            + "\r\n\t1: As is"
            + "\r\n\t2: lower case"
            + "\r\n\t3: UPPER CASE"
            + "\r\n\t4: v_w_ls r_pl_c_d"
            + "\r\nEnter your choice: ");
         outputType = Integer.parseInt(userInput.nextLine());
         if (outputType == 1) { //as is
            result = message;
         }
         else if (outputType == 2) { //lower case
            result = message.toLowerCase();
         }
         else if (outputType == 3) { //UPPER CASE
            result = message.toUpperCase();
         }
         else if (outputType == 4) { //V_w_ls r_pl_c_d
            result = message.replace("a", "_");
            result = result.replace("e", "_");
            result = result.replace("i", "_");
            result = result.replace("o", "_");
            result = result.replace("u", "_");
         }
         else { //invalid input
            result = "Error: invalid choice input.";
         }
         
         System.out.println("\r\n" + result);
      }
   
   }