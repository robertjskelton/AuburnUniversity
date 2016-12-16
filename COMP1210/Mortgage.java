   import java.util.Scanner;
	 
	 /** 
    *	This program is a mortgage calculator.
	 *
	 * @author Robert Skelton
	 * @version 1.22.2012
    */
	 
	 
   public class Mortgage {
   
   	 /**
       * This calculates your mortgage, and is a main.
       * @param args Command line arguments (not used).
       */
   
      public static void main(String[] args) {
      
      //Create variables
         Scanner userInput = new Scanner(System.in);
         double loan;
         double payment;
         double interest;
         int loanType;
         double loanTerm;
         
      //payment=(loan+interest+1200*loanTerm)/(loanTerm*12);
      //Output
         System.out.print("Loan Amount: ");
         loan = userInput.nextDouble();
         System.out.println("Interest Rate");
         System.out.println("10 year fixed: 4.07%");
         System.out.println("15 year fixed: 4.01%");
         System.out.println("30 year fixed: 3.87%");
         System.out.print("Choose Type of the Loan (1: 10 year fixed; "
            + "2: 15 year fixed"
            + "; 3: 30 year fixed): ");
         loanType = userInput.nextInt();
         if (loanType == 1) {
            loanType = 10; 
            interest = .0407; }
         else if (loanType == 2) {
            loanType = 15;
            interest = .0401; }
         else {
            loanType = 30;
            interest = .0387; } 
         System.out.print("Loan Term (Within " 
            + loanType + " years): ");
         loanTerm = userInput.nextInt();
         System.out.println("");  
         
         double totalInterest;
         totalInterest = loan * interest;
      
         payment = (loan + totalInterest + (1200 * loanTerm)) / (loanTerm * 12);
      
         System.out.println("Monthly Payment is: " + payment);
         
         
       
      	
         
      
      
      
      
      }
   }