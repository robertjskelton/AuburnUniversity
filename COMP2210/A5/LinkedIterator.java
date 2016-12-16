   import java.util.Iterator;
   import java.util.NoSuchElementException;

/**
 * Provides an iterator over the elements of a
 * pointer chain.
 *
 * @param	<T>	the type of elements in the chain
 *
 * @author	Dean Hendrix (dh@auburn.edu)
 * @author	John Lewis (dh@auburn.edu)
 * @author	Joseph Chase (dh@auburn.edu)
 * @version	2010-09-17
 *
 */
   public class LinkedIterator<T> implements Iterator<T>
   {
   /** Node that contains the current element in the iteration. */
      private Node<T> current;
      
   /** Total number of nodes in the chain to be iterated over. */
      private int count;
   
    
   /**
    * Initializes the iterator on a given pointer chain with
    * a given number of elements.
    *
    * @param firstNode	first node in the chain to be iterated over
    * @param size			the number of nodes in the chain
    * 
    */	
      public LinkedIterator(Node<T> firstNode, int size)
      {
         current = firstNode;
         count = size;
      }
   
   /**
    * Returns true if this iterator has at least one more element
    * to deliver in the iteration.
    *
    * @return	true if at least one more element, false otherwise
    *
    */
      public boolean hasNext()
      {
         return (current != null);
      }
   
   /**
    * Returns the next element in the iteration. If there are no
    * more elements in this iteration, a NoSuchElementException is
    * thrown.
    *
    * @return	the next element in the iteration
    * @throws	NoSuchElementException if there are no more elements
    *
    */
      public T next()
      {
         if (!hasNext())
         {
            throw new NoSuchElementException();
         }
      
         T result = current.getElement();
         current = current.getNext();
         return result;
      }
   
   /**
    * Remove is not supported in this iteration.
    *
    * @throws UnsupportedOperationException
    * 
    */
      public void remove() 
      {
         throw new UnsupportedOperationException();
      }
   }
