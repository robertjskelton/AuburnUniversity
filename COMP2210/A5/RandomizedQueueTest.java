 /**
 * RandomizedQueueTest.java. 13 tests for RandomizedQueue.java.
 *
 * @author    Zachary Pearson (zdp0002@auburn.edu)
 * @version   2012-10-16
 *
 */  
	
	
   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;
   import java.util.Iterator;


   public class RandomizedQueueTest {
   
      RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
   	
      /** Fixture initialization (common initialization
       *  for all tests). **/
      @Before public void setUp() {
         for (int i = 0; i < 10; i++) {
            rq.enqueue(i);
         }
      }
   	
   	// Check isEmpty() when it's true
      @Test public void isEmptyTest1() {
         RandomizedQueue<Integer> a = new RandomizedQueue<Integer>();
         Assert.assertTrue(a.isEmpty());
      }
   	
   	// Check isEmpty() when it's false
      @Test public void isEmptyTest2() {
         Assert.assertFalse(rq.isEmpty());
      }
   	
   	// Check size()
      @Test public void sizeTest() {
         Assert.assertEquals(10, rq.size());
      }
   	
   	// Check that dequeue() returns a valid element of the queue
      @Test public void dequeueTest1() {
         Integer x = rq.dequeue();
         Assert.assertTrue(x < 10 && x >= 0);
      }
   	
   	// Check that dequeue() decreases the size
      @Test public void dequeueTest2() {
         rq.dequeue();
         Assert.assertEquals(9, rq.size());
      }
   	
   	// Check that sample() does not change the size
      @Test public void sampleTest1() {
         rq.sample();
         Assert.assertEquals(10, rq.size());
      }
   	
   	// Check that sample() returns a valid element of the queue
      @Test public void sampleTest2() {
         Integer x = rq.sample();
         Assert.assertTrue(x < 10 && x >= 0);
      }
   
   	// Checks that calling dequeue() on two different but identical queues
   	// returns different values (usually)
      @Test public void randomizationTest1() {
         RandomizedQueue<Integer> fq = new RandomizedQueue<Integer>();
         for (int i = 0; i < 10; i++) {
            fq.enqueue(i);
         }
         Integer rx = rq.dequeue();
         Integer fx = fq.dequeue();
         Assert.assertFalse(rx.equals(fx)); //should fail sometimes
      }
   	
   	// Checks that calling sample() on two different but identical queues
   	// returns different values (usually)
      @Test public void randomizationTest2() {
         RandomizedQueue<Integer> fq = new RandomizedQueue<Integer>();
         for (int i = 0; i < 10; i++) {
            fq.enqueue(i);
         }
         Integer rx = rq.sample();
         Integer fx = fq.sample();
         Assert.assertFalse(rx.equals(fx)); //should fail sometimes
      }
   	
   	// Check that Iterator is created
      @Test public void iteratorTest1() {
         Iterator<Integer> itr = rq.iterator();
         Assert.assertTrue(itr != null && itr instanceof Iterator);
      }
   	
   	// Check hasNext() for true
      @Test public void iteratorTest2() {
         Iterator<Integer> itr = rq.iterator();
         Assert.assertTrue(itr.hasNext());
      }
   
   	// Check hasNext() for false
      @Test public void iteratorTest3() {
         Iterator<Integer> itr = rq.iterator();
         for (int i = 0; i < 10; i++) {
            itr.next();
         }
         Assert.assertFalse(itr.hasNext());
      }
   	
   	// Check that two Iterators of the same queue maintain
   	// independent orders
      @Test public void iteratorTest4() {
         Iterator<Integer> itr1 = rq.iterator();
         Iterator<Integer> itr2 = rq.iterator();
         Integer x = itr1.next();
         Integer y = itr2.next();
         Assert.assertNotSame(x, y); //should fail sometimes
      }
   	
   	
   
     
   }