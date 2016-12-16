   import java.util.ArrayList;
 /** 
    *	This is the class about temperatures. 
	 *
	 * @author Robert Skelton
	 * @version 2.26.2012
    */
 
 
   public class Temperatures {
   //instance variables
      private int lowIn;
      private int highIn;
      private ArrayList<Integer> temperatures;
      
   //constructor
      public Temperatures(ArrayList temperaturesIn) {
         temperatures = temperaturesIn;
      }
   //methods
   //getLowTemp
      public int getLowTemp() {
         if (temperatures.isEmpty()) {
            return 0;
         }
         int low = temperatures.get(0);
         for (int i = 0; i < lowIn; i++) {
            
            if (temperatures.get(i) < low) {
               low = temperatures.get(i);
            }
         }
         return low;
      }
      
   	//getHighTemp
      public int getHighTemp() {
         if (temperatures.isEmpty()) {
            return 0;
         }
         int high = temperatures.get(0);
         
         for (Integer currentTemp : temperatures) {
            if (currentTemp > high) {
               high = currentTemp;
            }
         }
         return high;
      
      }
   
      public int lowerMinimum(int lowIn) {
         return lowIn < getLowTemp() ? lowIn : getLowTemp();
      }
   
      public int higherMaximum(int highIn) {
         return highIn > getHighTemp() ? highIn : getHighTemp();
      }
      
   //toString method
      public String toString() {
      
         return "Low: " + getLowTemp()
            + "\r\nHigh: " + getHighTemp();
      }
   
   
   }