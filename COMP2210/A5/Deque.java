   import java.util.Iterator;
   import java.util.NoSuchElementException;

/**
 * Deque.java. Implements dequeue with O(1) worst-case
 * cost for all methods, iterator construction, and
 * iterator methods.
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @version   10.18.2012
 */
 
   public class Deque<Item> implements Iterable<Item> {
      private int N;         // number of elements in deque
      private Node first;    // beginning of deque
      private Node last;     // end of deque
      //private Node previous; // to make it doubly linked
   
    // helper linked list class
      private class Node 
      {
         private Item item = null;
         private Node next = null;
         private Node previous = null;
      }
   
   // constructor
      public Deque()
      {
         first = null;
         last  = null;
         N = 0; // initialize N
      }
   
   // is the deque empty?
      public boolean isEmpty() 
      {
         return first == null;
      }
   
   // returns size of the deque (N)
      public int size() 
      {
         return N;     
      }
    
    // add an item to the front
      public void addFirst(Item item) {
         if (item.equals(null))
            throw new java.lang.NullPointerException();
         
         Node x = new Node();
         x.item = item;
         if (isEmpty()) 
         { 
            first = x;     
            last = x; 
         }
         else
         { 
            x.next = first; 
            first.previous = x;
            first = x; 
         }
         N++;  // make size() one larger     
      }
   
   // add an item to the end
      public void addLast(Item item) {
         if (item.equals(null))
            throw new java.lang.NullPointerException();
            
         Node x = new Node();
         x.item = item;
         if (isEmpty()) 
         { 
            first = x;     
            last = x; 
         }
         else
         { 
            x.previous = last;
            last.next = x; 
            last = x; 
         }
         N++; // make size() one larger
      }
   
     // remove the first item
      public Item removeFirst() {
         if (isEmpty())
            throw new java.util.NoSuchElementException();
       
         Item item = first.item;
         if (N == 1)
         {
            first = null;
            last = null;
         }
         else {
            first = first.next;
            first.previous = null;
         }
         N--; // make size() one smaller
         return item;
      }
      
   // remove the last item in the list
      public Item removeLast() {
         if (isEmpty())
            throw new java.util.NoSuchElementException();
         
         Item item = last.item;
      
         if (N == 1)
         {
            first = null;
            last = null;
         }
         else {
            last = last.previous;
            last.next = null;
         } 
         N--; // make size() one smaller
         return item; 
      }
   
      public Iterator<Item> iterator() 
      {
         return new ListIterator();  
      }
   
    // an iterator, remove() is not used
      private class ListIterator implements Iterator<Item> {
         private Node current = first;
      
         public boolean hasNext() 
         { 
            return current != null;                     
         }
         
         public void remove()      
         { 
            throw new UnsupportedOperationException(); 
         }
      
         public Item next() 
         {
            if (!hasNext()) 
               throw new NoSuchElementException();
               
            Item item = current.item;
            current = current.next; 
            return item;
         }
      }
   }