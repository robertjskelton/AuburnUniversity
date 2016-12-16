
   public class BankLoan {
   	// constant fields
      private static final int MAX_LOAN_AMOUNT = 100000;
   
      // instance variables (can be used within the class)
      private String customerName;
      private static double balance, interestRate;
      private static int loansCreated = 0;
   
      public BankLoan(String customer, double interest) {
         customerName = customer;
         interestRate = interest;
         balance = 0;
         loansCreated++;
      }
      
   
     
   
      public boolean borrowFromBank(double amount) {
         
         boolean wasLoanMade = false;
         
         if (balance + amount < MAX_LOAN_AMOUNT) {// // 
            wasLoanMade = true;
            balance += amount;
         }
      
         return wasLoanMade;
      }
   
      public double payBank(double amountPaid) {
         double newBalance = balance - amountPaid;
         if (newBalance < 0) {
            balance = 0;
            // paid too much, return the overcharge
            return Math.abs(newBalance);
         }
         else {
            balance = newBalance;
            return 0;
         }
      }
      
      public static double getBalance() {
         return balance;
      }
      
      public boolean setInterest(double newInterest) {
      
         if (newInterest >= 0 && newInterest <= 1) {
            interestRate = newInterest;
            return true;
         }
         else {
            return false;
         }
      }
      
      public void chargeInterest() {
         balance = balance * (1 + interestRate);
      }
      
      public static boolean isAmountValid(double amount) {
         if (amount >= 0) {
            return true;
         }
         else {
            amount = 0;
            return false;
         }
      }
      
      public static boolean isInDebt(int loan) {
         if (getBalance() > 0) {
            return true;
         }
         else {
            return false;		
         }
      }
      
      public static int getLoansCreated() {
         return loansCreated;
      }
      
      public static void resetLoansCreated() {
         loansCreated = 0;
      }
   
      
     // toString method
      public String toString() {
         String output = "Name: " + customerName + "\r\n" 
            + "Interest rate: " + interestRate + "%\r\n" 
            + "Balance: $" + balance + "\r\n";
         return output;
      }
   
   
   }
