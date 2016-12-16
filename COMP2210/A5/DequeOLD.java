   import java.util.Iterator;
   // import java.util.NoSuchElementException;

/**
 * Deque.java. Implements dequeue with O(1) worst-case
 * cost for all methods, iterator construction, and
 * iterator methods.
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @version   10.11.2012
 */
 
   public class Deque<Item> implements Iterable<Item> {
    
     /*The code for Node (nodecode) was taken from the Linked 
   	Structures lecture notes, COMP 2210 Fall 2012, Dean Hendrix. */
      private class Node<T>
      {
         private Item item;
      
      /** Pointer to the node following this one. */
         private Node<Item> next;   
      
      /* Creates an empty node. */
         public Node()
         {
            next = null;
            item = null;
         }
      
      /* Creates a node storing the specified element. */
         public Node(Item elem)
         {
            next = null;
            item = elem;
         }
      
      /* Creates a node storing the specified element 
      and a link to the next node. */
         public Node(Item elem, Node<Item> n)
         {
            next = n;
            element = elem;
         }
      
      /* Returns the node that follows this one. */
         public Node<T> getNext()
         {
            return next;
         }
      
      /* Sets the node that follows this one to the parameter. */
         public void setNext(Node<T> node)
         {
            next = node;
         }
      
      /* Returns the element stored in this node. */
         public T getElement()
         {
            return element;
         }
      
      /* Sets the element stored in this node to the parameter. */
         public void setElement(T elem)
         {
            element = elem;
         }
      }
      
    // helpers
      private int N;         // number of elements on queue
      private Node first;    // beginning of queue
      private Node last;     // end of queue
    
      
    // construct an empty deque
      public Deque() {
         /** Node that contains the current element in the iteration. */
         Node<Item> current;
         first = null;
         last  = null;
      }
   
    // is the deque empty?
      public boolean isEmpty() {
         return first == null;
      }         
   
    // return the number of items on the deque
      public int size() {
         return N;
      }
   
    // insert the item at the front
      public void addFirst(Item item) {
         if (item.equals(null))
            throw new java.lang.NullPointerException();
         
           
            
      }
   
    // insert the item at the end   
      public void addLast(Item item) {
         if (item.equals(null))
            throw new java.lang.NullPointerException();
            
         Node x = new Node();
         x.item = item;
         if (isEmpty()) { 
            first = x;     last = x; 
         }
         else           { 
            last.next = x; last = x; 
         }
         N++;  
      }
   
    // delete and return the item at the front    
      public Item removeFirst() {
         if (isEmpty())
            throw new java.util.NoSuchElementException();
            
         Item item = first.item;
         first = first.next;
         N--;
         if (isEmpty()) last = null;   // to avoid loitering
         return item;
         
      }
   
    // delete and return the item at the end
      public Item removeLast() {
         if (isEmpty())
            throw new java.util.NoSuchElementException();
            
         return null;
      }
   
    // return an iterator over items in order from front to end
      public Iterator<Item> iterator() {
         return new DequeIterator();
      }
      
      private class DequeIterator implements Iterator<Item>
      {
         private Node current = first;
      
      /* Returns true if this iterator has at least one more element
       to deliver in the iteration.*/
         public boolean hasNext()
         {
            return (current != null);
         }
      
         public Item next()
         {
         // returns exception is no more items when next is called
            if (!hasNext()) 
               throw new java.util.NoSuchElementException();
               
            Item item = current.item;
            current = current.next; 
            return item;
         }
      
      // not used
         public void remove()
         {
           // exception if remove() called in the itr
            throw new java.lang.UnsupportedOperationException();  
         }
      }
      
   	
   }