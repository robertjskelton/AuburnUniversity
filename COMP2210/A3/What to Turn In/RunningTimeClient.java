/**
 * RunningTimeClient.java. Provides a simple example
 * client of RunningTime.java.
 *
 * Compilation:   %javac RunningTimeClient.java
 * Execution:     %java -ea RunningTimeClient
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @author    Devin House    (dph0008@auburn.edu)
 * @version   9.14.2012
 */
   public class RunningTimeClient {
   
      public static void main(String[] args) {
         Clock clock;              // measures elapsed time
         double elapsedTime = 0;   // elapsed time of current run
         int N = 1;              // problem size parameter
         int seed = 31;            // selects internal method of RunningTime
       
         
      // time RunningTime.timeTrial()
         clock = new Clock();
         RunningTime.timeTrial(N, seed);
         elapsedTime = clock.elapsedTime();
         System.out.print("This call to method RunningTime.timeTrial(" 
            + N + ", " + seed + ") took ");
         System.out.printf("%4.3f", elapsedTime);
         System.out.println(" seconds.");		
      }
   
   
   }
