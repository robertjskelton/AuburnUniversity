   import java.util.Arrays;
   import java.util.Collection;
   import java.util.Comparator;
   import java.util.Iterator;
   import java.util.NoSuchElementException;
   import java.util.ArrayList;
   

/**
 * Defines a library of selection methods.
 *
 * @author  Robert Skelton (robertjskelton@gmail.com)
 * @version 9.4.12
 *
 */
   public final class Selector {
   
   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
      private Selector() { }
   
   
   /**
    * Selects the minimum value from the Collection c, as defined by
    * the supplied Comparator comp. This method throws an IllegalArgumentException
    * if either c or comp is null, and it throws a NoSuchElementException 
    * if c is empty. The Collection c is not changed by this method.
    *
    * @param c     the Collection to be searched through
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      minimum value in c
    * @throws      IllegalArgumentException if either c or comp is null
    * @throws      NoSuchElementException if c is empty
    *
    */
      public static <T> T min(Collection<T> c, Comparator<T> comp) {
         
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty())
            throw new NoSuchElementException("Collection is empty.");
         
         Iterator<T> itr = c.iterator();
         T min = itr.next();
         while (itr.hasNext()) {
            T nextElem = itr.next();
            if (comp.compare(nextElem, min) < 0)
               min = nextElem;
         }
         return min;
      }
   
   
   /**
    * Selects the maximum value from the Collection c, as defined by
    * the supplied Comparator comp. This method throws an IllegalArgumentException
    * if either c or comp is null, and it throws a NoSuchElementException 
    * if c is empty. The Collection c is not changed by this method.
    *
    * @param c     the Collection to be searched through
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      maximum value in c
    * @throws      IllegalArgumentException if either c or comp is null
    * @throws      NoSuchElementException if c is empty
    *
    */
      public static <T> T max(Collection<T> c, Comparator<T> comp) {
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty())
            throw new NoSuchElementException("Collection is empty.");
         
         Iterator<T> itr = c.iterator();
         T max = itr.next();
         while (itr.hasNext()) {
            T nextElem = itr.next();
            if (comp.compare(nextElem, max) > 0)
               max = nextElem;
         }
         return max;
        
      }
   
   
   /**
    * Selects the kth minimum value from the Collection c, as defined by
    * the supplied Comparator comp. This method throws an IllegalArgumentException 
    * if either c or comp is null, and it throws a NoSuchElementException
    * if either c is empty or if there is no kth minimum value. Note that there 
    * is no kth minimum value if k < 1, k > c.size(), or if k is larger than
    * the number of distinct values in c. The Collection c is not changed by 
    * this method.
    *
    * @param c     the Collection to be searched through
    * @param k     the k-selection value
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      kth minimum value in c
    * @throws      IllegalArgumentException as specified above
    * @throws      NoSuchElementException as specified above
    *
    */
      public static <T> T kmin(Collection<T> c, int k, Comparator<T> comp) {
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty() || (k < 1) || (k > c.size()))
            throw new NoSuchElementException("Collection is empty.");
            
         T[] test = (T[]) c.toArray();
         Arrays.sort(test);
         T kmin = test[k];
         int count = 1; 
      
         if (k == 1)
            kmin = test[k];
         
         else {
            for (int i = 1; i < test.length; i++)
            {
               if (test[i - 1] != test[i])
                  count++; 
                   
               if (count == k)
                  kmin = test[i];
            }
         }
         return kmin;
      }
   
   
   /**
    * Selects the kth minimum value from the Collection c, as defined by
    * the supplied Comparator comp. This method throws an IllegalArgumentException 
    * if either c or comp is null, and it throws a NoSuchElementException
    * if either c is empty or if there is no kth minimum value. Note that there 
    * is no kth minimum value if k < 1, k > c.size(), or if k is larger than
    * the number of distinct values in c. The Collection c is not changed by 
    * this method.
    *
    * @param c     the Collection to be searched through
    * @param k     the k-selection value
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      kth minimum value in c
    * @throws      IllegalArgumentException as specified above
    * @throws      NoSuchElementException as specified above
    *
    */
      public static <T> T kmax(Collection<T> c, int k, Comparator<T> comp) {
        
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty() || (k < 1) || (k > c.size()))
            throw new NoSuchElementException("Collection is empty.");
         
         
         T[] test = (T[]) c.toArray();
         Arrays.sort(test);
         int count = 1; 
      
         if (k == 1)
            return test[test.length - 1];
         
         else {
            for (int i = test.length - 2; i > -1; i--)
            {
               if (comp.compare(test[i], test[i + 1]) != 0)
                  count++; 
                   
               if (count == k)
                  return test[i];
            }
         }
         throw new NoSuchElementException("No kth element.");
      }
   
   
   /**
    * Returns a Collection containing all the values in the supplied
    * Collection c that are in the range [low..high]; that is, all the 
    * values that are greater than or equal to low and less than or 
    * equal to high, including duplicate values, as determined by the
    * supplied Comparator comp. The returned Collection contains only
    * values in the range [low..high], and no others. Note that low and
    * high do not have to be actual values in c. If there are no 
    * qualifying values, including the case where c is empty, this method 
    * throws a NoSuchElementException. This method throws an 
    * IllegalArgumentException if either c or comp is null. The Collection c
    * is not changed by this method.
    *
    * @param c     the Collection to be searched through
    * @param low   the lower bound value of the range
    * @param high  the upper bound value of the range
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      a Collection of elements in the range [low..high]
    * @throws      IllegalArgumentException as specified above
    * @throws      NoSuchElementException as specified above
    *
    */
      public static <T> Collection<T> range(Collection<T> c, T low, T high, 
                       Comparator<T> comp) { //recommends arraylist
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty())
            throw new NoSuchElementException("Collection is empty.");
         
         Collection<T> range = new ArrayList<T>();
         Iterator<T> itr = c.iterator();
         while (itr.hasNext()) {
            T nextElem = itr.next();
            //must be greater than low, less than high
            if (!range.contains(nextElem))
               if ((comp.compare(nextElem, low) >= 0)
               && (comp.compare(nextElem, high) <= 0))
                  range.add(nextElem);
         }
         return range; 
      }
   
   
   /**
    * Returns the smallest value in the Collection c that is strictly
    * greater than the given key, as defined by the supplied Comparator
    * comp. This method throws an IllegalArgumentException if either c
    * or comp is null, and throws a NoSuchElementException if c is empty
    * or if there is no qualifying value. Note that key does not have to 
    * be an actual value in c.
    *
    * @param c     the Collection to be searched through
    * @param key   the reference value
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      the next greater value in c
    * @throws      IllegalArgumentException as specified above
    * @throws      NoSuchElementException as specified above
    *
    */
      public static <T> T nextgt(Collection<T> c, T key, Comparator<T> comp) {
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty()) //or if no such value
            throw new NoSuchElementException("Collection is empty.");
         //just need an iterator
         Collection<T> range = new ArrayList<T>();
         Iterator<T> itr = c.iterator();
         T nextgt = itr.next();
         while (itr.hasNext())
         {
            T nextElem = itr.next();
            if ((comp.compare(nextElem, key) > 0) 
            && (comp.compare(nextElem, nextgt) < 0))
               nextgt = nextElem;
         }
      
         return nextgt;
      }
   
   
   /**
    * Returns the largest value in the Collection c that is strictly
    * less than the given key, as defined by the supplied Comparator
    * comp. This method throws an IllegalArgumentException if either c
    * or comp is null, and throws a NoSuchElementException if c is empty
    * or if there is no qualifying value. Note that key does not have to 
    * be an actual value in c.
    *
    * @param c     the Collection to be searched through
    * @param key   the reference value
    * @param comp  the Comparator that defines the ordering of the elements in c
    * @return      the next smaller value in c
    * @throws      IllegalArgumentException as specified above
    * @throws      NoSuchElementException as specified above
    *
    */
      public static <T> T nextlt(Collection<T> c, T key, Comparator<T> comp) {
         if ((c == null) || (comp == null))
            throw new IllegalArgumentException();
         if (c.isEmpty()) //or if no such value
            throw new NoSuchElementException("Collection is empty.");
         
         Collection<T> range = new ArrayList<T>();
         Iterator<T> itr = c.iterator();
         T nextlt = itr.next();
         while (itr.hasNext())
         {
            T nextElem = itr.next();
            if ((comp.compare(nextElem, key) > 0) 
            && (comp.compare(nextElem, nextlt) > 0))
               nextlt = nextElem;
         }
      
         return nextlt;         
      }
   
   
   /**
    * Embedded sample tests. Run with assertions enabled:
    *    % java -ea Selector
    *
    */
      public static void main(String[] args) {
         Integer[] a = {12, 2, 8, 4, 2, 10, 8, 2, 10, 12, 8, 10};
         Collection<Integer> c = Arrays.asList(a);
         Comparator<Integer> comp = new CompareIntegers();
      
         assert Selector.min(c, comp) == 2;
         assert Selector.max(c, comp) == 12;
         assert Selector.kmin(c, 1, comp) == 2;
         assert Selector.kmin(c, 2, comp) == 4;
         assert Selector.kmin(c, 3, comp) == 8;
         assert Selector.kmin(c, 4, comp) == 10;
         assert Selector.kmin(c, 5, comp) == 12;
         assert Selector.kmax(c, 1, comp) == 12;
         assert Selector.kmax(c, 2, comp) == 10;
         assert Selector.kmax(c, 3, comp) == 8;
         assert Selector.kmax(c, 4, comp) == 4;
         assert Selector.kmax(c, 5, comp) == 2;
      
         assert Selector.nextgt(c, 5, comp) == 8;
         assert Selector.nextlt(c, 5, comp) == 4;
         
         Integer[] arange = {4, 8, 10};
         Collection<Integer> range = Arrays.asList(arange);
         Collection<Integer> r = Selector.range(c, 3, 10, comp);
         assert r.size() == 3;
         assert r.containsAll(range);
      //my testm uses multiple of same value in array
         Integer[] m = {17, 17, 1, 1, 189, 189, 1, 17, 98};
         Collection<Integer> coll = Arrays.asList(m);
         Comparator<Integer> comp1 = new CompareIntegers();
      
         assert Selector.min(coll, comp1) == 1;
         assert Selector.max(coll, comp1) == 189;
         assert Selector.kmin(coll, 1, comp1) == 1;
         assert Selector.kmin(coll, 2, comp1) == 17;
         assert Selector.kmin(coll, 3, comp1) == 98;
         assert Selector.kmax(coll, 4, comp1) == 1;
         assert Selector.kmax(coll, 3, comp1) == 17; 
         assert Selector.kmax(coll, 1, comp1) == 189;
         assert Selector.kmax(coll, 2, comp1) == 98; 
         assert Selector.nextgt(coll, 5, comp1) == 17;
         assert Selector.nextlt(coll, 5, comp1) == 1;
      
      }
      
      
      static class CompareIntegers implements Comparator<Integer> {
         public int compare(Integer i, Integer j) {
            return i.compareTo(j);
         }
      }
      
   //make new Comparator for String
   }