   import java.util.Iterator;
    
/**
 * Array-based implementation of the Bag interface.
 *
 * @param	<T>	type of elements in this collection
 *
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2010-09-08
 * 
 */
   public class ArrayBag<T> implements Bag<T>
   {
   
      private T[] elements;
      private int size;
   
   /**
    * Instantiates a collection of a given capacity.
    *
    * @param capacity	maximum capacity of this collection
    *
    */
      @SuppressWarnings("unchecked")
      public ArrayBag(int capacity) 
      {
         elements = (T[]) new Object[capacity];
         size = 0;
      }
      
   /**
    * Ensures the collection contains the specified element.
    * No specific order is maintained, duplicates are allowed.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise
    *
    */
      public boolean add(T element)
      {
         if (size < elements.length)
         {
            elements[size] = element;
            size++;
            return true;
         }
         else
         {
            return false;
         }
      }
      	
   /**
    * Removes a single instance of the specified element from this collection.
    *
    * @param	element	the element to be removed, if present
    * @return  true if element was removed
    *
    */
      public boolean remove(T element)
      {
         if (isEmpty())
         {
            return false;      
         }
         
         int i = 0;
         while ((i < size) && (!elements[i].equals(element)))
         {
            i++;
         }
         
         if (i < size)
         {
            elements[i] = elements[size - 1];
            elements[size - 1] = null;
            size--;
            return true;
         }
         else
         {
            return false;
         }
      }
   
   /**
    * Searches for specified element in this collection.
    *
    * @param	element	element whose presence in this collection is to be tested
    * @return  true if this collection contains the specified element
    *
    */
      public boolean contains(T element)
      {
         boolean found = false;
         int i = 0;
         while ((!found) && (i < this.size))
         {
            if (elements[i].equals(element))
            {
               found = true;
            }
            i++;
         }
         return found;
      }
   
   /**
    * Returns the current size of this collection.
    *
    * @return	the number of elements in this collection.
    *
    */
      public int size() 
      {
         return size;
      }
   
   
   /**
    * Returns true if this collection contains no elements.
    *
    * @return	true if this collection contains no elements.
    *
    */
      public boolean isEmpty() 
      {
         return size == 0;
      }
   
   
   /**
    * Returns an iterator over the elements in this collection.
    *
    * @return	an iterator over the elements in this collection
    *
    */ 
      public Iterator<T> iterator() 
      {
         return new ArrayIterator<T>(elements, size);
      }
   
   /**
    * Creates a string representation of this collection.
    * 
    * @return	string representation of this collection.
    *
    */
      @Override
      public String toString() 
      {
         String result = "";
         for (int i = 0; i < this.size; i++)
         {
            result += elements[i] + " ";
         }
         return result + "\n";
      }
   
   }