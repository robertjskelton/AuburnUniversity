   import java.util.Iterator;
    
/**
 * Node-based implementation of the Bag interface.
 *
 * @param	<T>	type of elements in this collection
 *
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2010-09-17
 * 
 */
   public class LinkedBag<T> implements Bag<T>
   {
   
      private Node<T> front;
      private int size;
   
   /**
    * Instantiates an empty bag.
    *
    */
      public LinkedBag() {
         front = null;
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
      public boolean add(T element) {
         Node<T> n = new Node<T>(element);
         n.setNext(front);
         front = n;
         size++;
         return true;
      }
      
   /**
    * Removes a single instance of the specified element from this collection.
    *
    * @param	element	the element to be removed, if present
    * @return  true if element was removed
    *
    */
      public boolean remove(T element) {
         if (isEmpty())
         {
            return false;
         }
      
         Node<T> n = front;
         Node<T> prev = null;
         while ((n != null) && (!n.getElement().equals(element)))
         {
            prev = n;
            n = n.getNext();
         }
         
         if (n != null)
         {
            if (n == front)
            {
               front = front.getNext();
            }
            else
            {
               prev.setNext(n.getNext());
            }
            size--;
            return true;
         }
         return false;
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
         Node<T> p = this.front;
         while ((!found) && (p != null))
         {
            if (p.getElement().equals(element))
            {
               found = true;
            }
            p = p.getNext();
         }
         return found;
      }
   
   /**
    * Returns the current size of this collection.
    *
    * @return	the number of elements in this collection.
    *
    */
      public int size() {
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
      public Iterator<T> iterator() {
         return new LinkedIterator<T>(front, size);
      }
   
   /**
    * Creates a string representation of this collection.
    * 
    * @return	string representation of this collection.
    *
    */
      @Override public String toString() {
         String result = "";
         Node<T> n = front;
         while (n != null)
         {
            result += n.getElement() + " ";
            n = n.getNext();
         }
         return result + "\n";
      }
   
   }