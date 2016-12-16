   import java.util.Scanner;
	 
	 /** 
    *	This program works with the first class I built!!!
	 *
	 * @author Robert Skelton
	 * @version 2.5.2012
    */
	 
	 
   public class Activity4A {
    /**
       *
       * @param args Command line arguments (not used).
       */
   
      public static void main(String[] args) {
      
         ProfileInformation p = new ProfileInformation("Robert", "Skelton");
         p.setLocation("Auburn");
         p.setAge(19);
         p.logOn();
      	
      
         System.out.print(p);
       
      }
      
   }