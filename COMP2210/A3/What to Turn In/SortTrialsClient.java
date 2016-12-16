/**
 * SortTrialsClient.java. Provides a simple example
 * client of SortTrials.java.
 *
 * NOTE: The generic type of SortTrials must be bound
 *       to a Comparable type. The sorting methods in
 *       SortTrials use the natural ordering of the
 *       elements in the parameter array.
 *
 * Compilation:   %javac SortTrialsClient.java
 * Execution:     %java -ea SortTrialsClient
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @author    Devin House    (dph0008@auburn.edu)
 * @version   9.14.2012
 *
 */
   import java.util.Random;
   public final class SortTrialsClient {
   
      public static void main(String[] args) {
       
         // String[] a = {"z", "y",  "x", "w", "v", "u", "t",
               // "s", "r", "q", "p", "o", "n", "m", "l", "k", "j",
               // "i", "h", "g", "f", "e", "d", "c", "b", "a"};
      //              
        
         String[] b = {"a", "b", "c", "d", "e", "f", "g",
                     "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                     "r", "s", "t", "u", "v", "w", "x", "y", "z"};
      
      
         Random generator = new Random();      
         String[] c = new String[50000];
         for (int i = 50000; i > 0; i--)    
            c[c.length - i] = Integer.toString(generator.nextInt(1000000));
              
               	
      	
         
         SortTrials<String> st = new SortTrials<String>();
      
      // sort1-insertion
         Clock clock1;
         clock1 = new Clock();
         double elapsedTime1 = 0;
      	
         assert st.isSorted(c) == false;
         st.sort1(c);
         assert st.isSorted(c) == true;
         elapsedTime1 = clock1.elapsedTime();
         System.out.println("sort1 for c: " +  elapsedTime1 + " seconds.");
         st.shuffle(c);
      
      // sort2-selection
         Clock clock2;
         clock2 = new Clock();
         double elapsedTime2 = 0;
         
         assert st.isSorted(c) == false;
         st.sort2(c);
         assert st.isSorted(c) == true;
         elapsedTime2 = clock2.elapsedTime();
         System.out.println("sort2 for c: " +  elapsedTime2 + " seconds.");
         st.shuffle(c);
      
      
      // sort3-mergesort
         Clock clock3;
         clock3 = new Clock();
         double elapsedTime3 = 0;
         
         assert st.isSorted(c) == false;
         st.sort3(c);
         assert st.isSorted(c) == true;
         elapsedTime3 = clock3.elapsedTime();
         System.out.println("sort3 for c: " +  elapsedTime3 + " seconds.");
         st.shuffle(c);
         
      	
      // sort4-quicksort
         Clock clock4;
         clock4 = new Clock();
         double elapsedTime4 = 0;
         
         assert st.isSorted(c) == false;
         st.sort4(c);
         assert st.isSorted(c) == true;
         elapsedTime4 = clock4.elapsedTime();
         System.out.println("sort4 for c: " +  elapsedTime4 + " seconds.");
         st.shuffle(c);
         
      	
      // sort5-quicksort w/ randomization
         Clock clock5;
         clock5 = new Clock();
         double elapsedTime5 = 0; 
         
         assert st.isSorted(c) == false;
         st.sort5(c);
         assert st.isSorted(c) == true;
         elapsedTime5 = clock5.elapsedTime();
         System.out.println("sort5 for c: " +  elapsedTime5 + " seconds.");
         st.shuffle(c);
         
      	
      }
   }