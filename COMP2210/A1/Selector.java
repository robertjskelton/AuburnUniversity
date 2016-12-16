   import java.util.Arrays;

/**
 * Defines a library of selection methods.
 *
 * @author  Robert Skelton (robertjskelton@gmail.com)
 * @version 8.24.12
 *
 */
   public class Selector {
   
   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
      private Selector() { }
   
   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    *
    * @param a     the array to be searched through
    * @return      minimum value in a
    * @throws      IllegalArgumentException if a is null or zero-length
    *
    */
    
      public static int min(int[] a) {
         if ((a == null) || (a.length == 0))
            throw new IllegalArgumentException();
         
         int min = a[0];
         
         for (int i = 0; i < a.length; i++) 
         {
            if (a[i] < min) 
            {
               min = a[i];
            }
         }
         return min;
      }
   
   
   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    *
    * @param a     the array to be searched through
    * @return      maximum value in a
    * @throws      IllegalArgumentException if a is null or zero-length
    *
    */
      public static int max(int[] a) {
         if ((a == null) || (a.length == 0))
            throw new IllegalArgumentException();
         
         int max = a[0];
      
         for (int i = 0; i < a.length; i++)
         {
            if (a[i] > max)
               max = a[i];
            
         }
         return max;
      }
   
   
   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinctk values in the array. The array a is not
    * changed by this method.
    *
    * @param a     the array to be searched through
    * @param k     the k-selection value
    * @return      kth minimum value in a
    * @throws      IllegalArgumentException as specified above
    *
    */
      public static int kmin(int[] a, int k) {
         if ((a == null) || (k < 1) || (k > a.length))
            throw new IllegalArgumentException();
            
         //make new array(test) and sort it, to not modify a
         int[] test = Arrays.copyOf(a, a.length);
         Arrays.sort(test);
         
         int kmin = test[k];
         return kmin;
      }
   
   
   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinctk values in the array. The array a is not
    * changed by this method.
    *
    * @param a     the array to be searched through
    * @param k     the k-selection value
    * @return      kth maximum value in a
    * @throws      IllegalArgumentException as specified above
    *
    */
      public static int kmax(int[] a, int k) {
         if ((a == null) || (k < 1) || (k > a.length))
         {
            throw new IllegalArgumentException();
         }
         
         //make new array(test) and sort it, to not modify a
         int[] test = Arrays.copyOf(a, a.length);
         Arrays.sort(test);
         
         int j = 0;
         int[] temp = new int[a.length];
         for (int i = test.length - 1; i >= 0; i--)
         {
            temp[j++] = test[i];
         
         }
      
         for (int i = 0; i < test.length; i++)
            test[i] = temp[i];
            
         int kmax = test[k-1];
         return kmax;
      }
   
   
   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method thows an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    *
    * @param a     the array to be searched through
    * @param low   the lower bound value of the range
    * @param high  the upper bound value of the range
    * @return      an array of elements i
    * @throws      IllegalArgumentException as specified above
    *
    */
    
      public static int[] range(int[] a, int low, int high) {
         if ((a == null) || (a.length == 0))
         {
            throw new IllegalArgumentException();
         }
         int arrayLength = 0;
         
      //loop through test, finding out how long newArray should be
         for (int i = 0; i < a.length; i++)
            if ((a[i] >= low) && (a[i] <= high))
               arrayLength++; 
         
      //creates new array of correct length
         int[] newArray = new int[arrayLength];
         
      //insert correct values into array
         int count = 0;
         for (int j = 0; j < a.length; j++)
         {
            if ((a[j] >= low) && (a[j] <= high)) {
               newArray[count] = a[j];
               count++;
            }
         }
         return newArray; 
      }
   
   
   /**
    * Returns the smallest value in a that is strictly greater than the
    * given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    *
    * @param a     the array to be searched through
    * @param key   the reference value
    * @return      the next greater value in a
    * @throws      IllegalArgumentException as specified above
    *
    */
      public static int nextgt(int[] a, int key) {
         if ((a == null) || (a.length == 0) || (key > max(a)))
         {
            throw new IllegalArgumentException();
         }
         Arrays.sort(a);
         int newkey = key;
         if (Arrays.binarySearch(a, newkey) >= 0)
            return newkey;
            
         while (Arrays.binarySearch(a, newkey) < 0)
         {
            newkey++;
         }
         return newkey; 
      }
   
   
   /**
    * Returns the largest value in a that is strictly less than the
    * given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    *
    * @param a     the array to be searched through
    * @param key   the reference value
    * @return      the next smaller value in a
    * @throws      IllegalArgumentException as specified above
    *
    */
      public static int nextlt(int[] a, int key) {
         if ((a == null) || (a.length == 0))
         {
            throw new IllegalArgumentException();
         }
         
         int newkey = key;
         if ((a == null) || (a.length == 0) || (newkey < min(a)))
         {
            throw new IllegalArgumentException();
         }
         Arrays.sort(a);
         if (Arrays.binarySearch(a, newkey) >= 0)
            return newkey;
            
         while (Arrays.binarySearch(a, newkey) < 0)
         {
            newkey--;
         }
         return newkey;
      }
   
   
   /**
    * Embedded sample tests. Run with assertions enabled:
    *    % java -ea Selector
    *
    */
      public static void main(String[] args) {
         int[] a = {12, 2, 8, 4, 2, 10};
      
         assert Selector.min(a) == 2;
         assert Selector.max(a) == 12;
         assert Selector.kmin(a, 3) == 8;
         assert Selector.kmax(a, 4) == 4;
         assert Selector.nextgt(a, 5) == 8;
         assert Selector.nextlt(a, 5) == 4;
      
         int[] range = {4, 8, 10};
         int[] r = Selector.range(a, 3, 10);
         assert r.length == 3;
         Arrays.sort(r);
         assert Arrays.equals(range, r);
         
         int[] b = {0, 2, 6, 9, 0, 10, 15, 28, 90};
         assert Selector.min(b) == 0;
         assert Selector.max(b) == 90;
         assert Selector.kmin(b, 3) == 6;
         assert Selector.kmax(b, 4) == 10;
         assert Selector.nextgt(b, 5) == 6;
         assert Selector.nextlt(b, 5) == 2;
      }
   }