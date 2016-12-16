 /**
 * DequeTest.java. 23 Tests for Deque.java.
 *
 * @author    Zachary Pearson (zdp0002@auburn.edu)
 * @version   2012-10-16
 *
 */  
	
   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;
   import java.util.Iterator;
   import java.util.NoSuchElementException;

   public class DequeTest {
   
      Deque<Integer> d = new Deque<Integer>();
   	
      /** Fixture initialization.
   	    Creates a Deque of size 10. **/
      @Before public void setUp() {
         for (int i = 0; i < 10; i++) {
            d.addFirst(i);
         }
      }
   
   	// Check isEmpty() for false
      @Test public void isEmptyTest() {
         Assert.assertFalse(d.isEmpty());
      }
   	
   	// Check isEmpty() for true
      @Test public void isEmptyTest2() {
         Deque<Integer> z = new Deque<Integer>();
         Assert.assertTrue(z.isEmpty());
      }
   	
   	// Check isEmpty() after emptying a Deque
      @Test public void isEmptyTest3() {
         for (int i = 0; i < 10; i++) {
            d.removeFirst();
         }
         Assert.assertTrue(d.isEmpty());
      }
   
   	
   	// Check size()
      @Test public void sizeTest() {
         int s = d.size();
         Assert.assertEquals(10, s);
      }
   	
   	// Check if size increases with addFirst()
      @Test public void firstTest1() {
         d.addFirst(15);
         Assert.assertEquals(11, d.size());
      }
   	
   	// Check if addFirst() adds correct Item
   	// and that removeFirst() returns correct Item
      @Test public void firstTest2() {
         d.addFirst(15);
         Integer i = d.removeFirst();
         Assert.assertEquals((Integer) 15, i);
      }
   	
   	// Check if size decreases with removeFirst()
      @Test public void firstTest3() {
         d.addFirst(15);
         d.removeFirst();
         Assert.assertEquals(10, d.size());
      	
      }
   	
   	// Check if size increases with addLast()
      @Test public void lastTest1() {
         d.addLast(15);
         Assert.assertEquals(11, d.size());
      }
   	
   	// Check if addLast() adds correct Item
   	// and removeLast() returns correct Item
      @Test public void lastTest2() {
         d.addLast(15);
         Integer i = d.removeLast();
         Assert.assertEquals((Integer) 15, i);
      }
   	
   	// Check if size decreases with removeLast()
      @Test public void lastTest3() {
         d.addFirst(15);
         d.removeLast();
         Assert.assertEquals(10, d.size());
      }
   
   	// Check if Iterator is created
      @Test public void iteratorTest() {
         Iterator<Integer> itr = d.iterator();
         Assert.assertTrue(itr != null && itr instanceof Iterator);
      } 
   	
   	// Check hasNext() when it's true
      @Test public void itrTest2() {
         Iterator<Integer> itr = d.iterator();
         Assert.assertTrue(itr.hasNext());
      }
   	
   	// Check hasNext() when it's false
      @Test public void itrTest3() {
         Iterator<Integer> itr = d.iterator();
         for (int i = 0; i < 10; i++) {
            itr.next();
         }
         Assert.assertFalse(itr.hasNext());
      }
   	
   	// Check next()
      @Test public void itrTest4() {
         Iterator<Integer> itr = d.iterator();
         Integer x = 9;
         Assert.assertEquals(x, itr.next());
      }
   	
   	// Check next() multiple times 
      @Test public void itrTest5() {
         Iterator<Integer> itr = d.iterator();
         Integer x = null;
         while(itr.hasNext()) {
            x = itr.next();
         }
         Assert.assertEquals((Integer) 0, x);
      }
   	
   	// Check that remove() throws exception
      @Test public void itrTest6() {
         Iterator<Integer> itr = d.iterator();
         boolean thrown = false;
         try {
            itr.remove();
         }
            catch (UnsupportedOperationException e) {
               thrown = true;
            }
         Assert.assertTrue(thrown);	
      }
   	
   	// Check next() throws exception at end of dequeue
      @Test public void itrTest7() {
         Iterator<Integer> itr = d.iterator();
         boolean thrown = false;
         while(itr.hasNext()) {
            itr.next();
         }
         try {
            itr.next();
         }
            catch (NoSuchElementException e) {
               thrown = true;
            }
         Assert.assertTrue(thrown);
      }
   	
   	// Check removeLast() with one Item in the deque
      @Test public void removeLastTest1() {
         Deque<Integer> q = new Deque<Integer>();
         q.addFirst(1);
         Assert.assertEquals((Integer) 1, q.removeLast());
      }
   	
   	// Check that removeLast() throws exception with empty Deque
      @Test public void removeLastTest2() {
         boolean thrown = false;
         Deque<Integer> q = new Deque<Integer>();
         q.addFirst(2);
         q.removeLast();
         try {
            q.removeLast();
         }
            catch (NoSuchElementException e) {
               thrown = true;
            }
         Assert.assertTrue(thrown);
      }
   	
   	// Check removeLast() works for deque originally 
   	// of size 10 after other items have been removed
      @Test public void removeLastTest3() {
         for (int i = 0; i < 4; i++) {
            d.removeFirst();
         }
         for (int i = 0; i < 5; i++) {
            d.removeLast();
         }
         d.removeLast();
         Assert.assertEquals(0, d.size());
      }
   	
   	// Check removeFirst() with one Item in the deque
      @Test public void removeFirstTest1() {
         Deque<Integer> q = new Deque<Integer>();
         q.addFirst(1);
         Assert.assertEquals((Integer) 1, q.removeFirst());
      }
   	
   	// Check that removeFirst() throws exception with empty Deque
      @Test public void removeFirstTest2() {
         boolean thrown = false;
         Deque<Integer> q = new Deque<Integer>();
         q.addFirst(2);
         q.removeLast();
         try {
            q.removeFirst();
         }
            catch (NoSuchElementException e) {
               thrown = true;
            }
         Assert.assertTrue(thrown);
      }
   	
   	// Check removeFirst() works for deque originally 
   	// of size 10 after other items have been removed
      @Test public void removeFirstTest3() {
         for (int i = 0; i < 4; i++) {
            d.removeFirst();
         }
         for (int i = 0; i < 5; i++) {
            d.removeLast();
         }
         d.removeFirst();
         Assert.assertEquals(0, d.size());
      }
   	
   }