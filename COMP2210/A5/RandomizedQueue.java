   import java.util.Iterator;
   import java.util.NoSuchElementException;
   import java.util.Random;

/**
 * RandomizedQueue.java. Implements a randomized queue.
 * Each randomized queue operation (besides creating an iterator)
 * has constant amortized worst-case time and use space proportional
 * to the number of queue currently in the queue.
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @version   10.19.2012
 *
 */
 
   public class RandomizedQueue<Item> implements Iterable<Item> {
      private Item[] queue;
      private int rear; 
      private int front;
      private int N; // for the counter
      private Item[] elements;
      private int size;
         
   // construct an empty randomized queue
      public RandomizedQueue() {
         queue = (Item[]) new Object[2];
         rear = 0;
         front = 0;
      }
   
   // is the queue empty?
      public boolean isEmpty() {
         if (queue[0] == null)
         {
            return true;
         }
         else
            return false;
      }
   
   // return the number of queue on the queue
      public int size() {
         return N;
      }
   
      // make a new array and copy it all over to that
      @SuppressWarnings("unchecked")
      private void expandCapacity() {
         Item[] temp = (Item[]) new Object[queue.length * 2];
         System.arraycopy(queue, 0, temp, 0, queue.length);
         queue = temp;
      }
      
   // add the item to the end
      public void enqueue(Item item) {
         if(item.equals(null))
            throw new java.lang.NullPointerException();
            
         if (size() == queue.length)
            expandCapacity();
            
         queue[rear] = item;
         rear++;
         N++; // increments the count 
      }
   
   // delete and return a random item
      public Item dequeue() {
         if (isEmpty())
            throw new java.util.NoSuchElementException();
            
            // create random generator and pick a random 
            // number in arrays size
         Random gen = new Random(3);
         int ran = gen.nextInt();
         
         Item result = queue[ran]; 
         N--; // decrease the size
         queue[ran] = queue[rear];
         queue[rear] = null; // make rear be null
         return result;
      }
   
   // return (but do not delete) a random item
      public Item sample() {
         if (isEmpty())
            throw new java.util.NoSuchElementException();
            
            // create random generator and pick a random 
            // number in arrays size
         Random gen = new Random(size());
         int ran = gen.nextInt();
         Item temp = queue[ran];
         return temp;
      }
   
   // return an independent iterator over queue in random order
      public Iterator<Item> iterator() {
         
         return new RandomIterator(elements, size());
      }
      
      private class RandomIterator implements Iterator<Item>
      {
       /** the array of elements to be iterated over. */
         private Item[] items;
      /** the number of elements in the array. */
         private int count;
      /** the current position in the iteration. */
         private int current;
      
      
         private Item[] queue = (Item[]) new Object[2];
         public RandomIterator(Item[] elements, int size)
         {
            items = elements;
            count = size;
            current = 0;
         }
      
         public boolean hasNext()
         {
            return (current < count);
         }
      
         public Item next()
         {
         // returns exception is no more items when next is called
            if (!hasNext()) 
               throw new java.util.NoSuchElementException();
            
            current++;
            Item result = queue[current];
            return result;
         }
      
         public void remove()
         {
           // exception if remove() called in the itr
            throw new java.lang.UnsupportedOperationException();  
         }
         
      }
   }