   import java.util.Scanner; 
   import java.text.DecimalFormat;	
 	
	 /** 
    *	This is the main method, invoking PetDog and PetOwner.
	 *
	 * @author Robert Skelton
	 * @version 2.8.2012
    */
 
   public class PetOwnerApp {
   
       /**
       * @param args Unused command.
       */
      public static void main(String[] args) {
      
      	//Redundant Variables
         PetOwner robert;
         PetDog myDog1;
         String dogNameIn;
         String breedIn;
         int ageIn;
         double dogWeight;
         String ownerName;
         String address;
               	
      	//Scanners
         Scanner scan = new Scanner(System.in);
         
      	//Decimal Format
         DecimalFormat fmt = new DecimalFormat("#0.00");
      	 
      	//Get inputs
         System.out.print("What is the name of your dog: ");
         dogNameIn = scan.nextLine();
         
         System.out.print("What is the breed of your dog: ");
         breedIn = scan.nextLine();
         
         System.out.print("What is the age of your dog: ");
         ageIn = Integer.parseInt(scan.nextLine());
      
         
         System.out.print("What is the weight of your dog: ");
         dogWeight = Double.parseDouble(scan.nextLine());
      	
         System.out.print("What is the owner's name: ");
         ownerName = scan.nextLine();
      	
         System.out.print("What is the address: ");
         address = scan.nextLine();
      	
         robert = new PetOwner(ownerName, address);
         myDog1 = new PetDog(dogNameIn, breedIn, ageIn, dogWeight);
         robert.setMyDog(myDog1);
         
         System.out.println("\n" + robert + "\n");
      	
         System.out.print("Do you want to change your dog's name?(Y/N) ");
         String answer = scan.nextLine();
         if (answer.equals("Y")) {
            System.out.print("\nWhat is the new name: ");
            robert.changeDogName(scan.nextLine());
            System.out.println("The name of your dog has been changed to "
               + robert.getMyDog().getName() + ".\n");
         }
         
         System.out.print("Do you want to estimate the cost?(Y/N) ");
         String answer1 = scan.nextLine();
         if (answer1.equals("Y")) {
            System.out.println("\nYour dog bills will be approximately $" 
               + fmt.format(robert.estimatePetCost()) + " per month.");
         }
      }
   }