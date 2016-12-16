   import java.util.Iterator;

/**
 * A simple client of the Bag interface and the
 * ArrayBag class.
 *
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2010-09-08
 *
 */	 
   public class ArrayBagClient
   {
   
   /**
    * Exercises Bag and ArrayBag methods.
    *
    * @param args	command line arguments not used.
    *
    */
      public static void main(String[] args)
      {
      
         Bag<Book> bookBag = new ArrayBag<Book>(100);
         bookBag.add(new Book("Furst", "The World at Night", 123));
         bookBag.add(new Book("Kanon", "Alibi", 456));
         bookBag.add(new Book("Lewis", "Perelandra", 789));
      
         System.out.println(bookBag);
      
         Book btarget = new Book("James", "The Lighthouse", 333);
       
         if (bookBag.contains(btarget))
         {
            System.out.println("My book is in the collection.");
         }  
         else
         {
            System.out.println("My book is not in the collection.");
         }
      	
         int count = 0;
         Iterator<Book> bitr = bookBag.iterator();
         while (bitr.hasNext()) {
            Book b = bitr.next();
            if (b.compareTo(btarget) == 0)
            {
               count++;
            }
         }
         System.out.println("The collection contains " + count 
            + " instance(s) of " + btarget + ".\n");
      
      
         Bag<String> strBag = new ArrayBag<String>(10);
      
         strBag.add("red");
         strBag.add("orange");
         strBag.add("yellow");
         strBag.add("green");
         strBag.add("blue");
         strBag.add("indigo");
         strBag.add("violet");
      
         System.out.println(strBag);
      
         String starget = "blue"; 
       
         if (strBag.contains(starget))
         {
            System.out.println("My color is in the collection.");
         }  
         else
         {
            System.out.println("My color is not in the collection.");
         }
      
      	
         count = 0;
         Iterator<String> itr = strBag.iterator();
         while (itr.hasNext()) {
            String s = itr.next();
            if (s.compareTo(starget) == 0)
            {
               count++;
            }
         }
         System.out.println("The collection contains " + count 
            + " instance(s) of " + starget + ".");
      
      
      
      }
   }