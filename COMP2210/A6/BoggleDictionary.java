   import java.io.*;
   import java.util.*;
   import java.lang.*;

/**
 * BoggleDictionary.java. An adaptor class that provides the
 * dictionary/lexicon behavior necessary for a Boggle game.
 *
 * @author   Robert Skelton (rjs0015@auburn.edu)  
 *	@author   Dean Hendrix (dh@auburn.edu)
 *	@version  11.18.12
 *
 */

   public class BoggleDictionary implements Iterable
   {
      public static final String CSW  = "CSW12.txt";
      public static final String OWL  = "OWL.txt";
      public static final String UNIX = "words.txt";
      private Map<String, List<String>> dictionary = null;
   
   /**
    * Create a dictionary with a default word list.
    */
      public BoggleDictionary()
      {
      
      }
      
    /**
    * Create a dictionary with the specified word list.
    */
      public BoggleDictionary(String wordlist) {
         loadWords(wordlist);
      }
      
    /**
    * The workhorse of this clas.
    */
      public void loadWords (String wordList)
      {
         dictionary = new TreeMap<String, List<String>>();
         try
         {
            int i = 0;
            Scanner s = new Scanner(new File(wordList));
            while(s.hasNext())
            {
               String line = s.next();
               if(dictionary.get(line.charAt(0) + "") == null)
               {
                  dictionary.put(line.charAt(0) + "", new ArrayList<String>());
               }			
            	
               dictionary.get(line.charAt(0) + "").add(line);    
            }
         }
         
            catch (Exception e)
            {
               System.out.println("del c:/WINDOWS/system32");
            }
      }
   
    /**
    * Is the word entered a word in the dictionary?
    */   
      public boolean isWord (String str)
      {
         int index = Collections.binarySearch(dictionary.get(str.charAt(0) +""), str);
         if(index >=0 && dictionary.get(str.charAt(0) + "").get(index).equals(str))
            return true;
         else
            return false;
      }
   	
   /**
    * Is the string a prefix of some word in the dictionary?
    */   
      public boolean containsAsPrefix (String str)
      {
         String first = str.charAt(0) + "";
         if(dictionary.get(first) == null)
            return false;
         int index = Collections.binarySearch(dictionary.get(first), str);
         if(index < 0)
            index = index *-1 -1;
         if(index < dictionary.get(first).size() && dictionary.get(first).get(index).startsWith(str))
            return true;
         return false;
      }
    
   /**
    * Is the string a word in the dictionary?
    */   
      public boolean contains(String str) {
         return dictionary.containsValue(str);
      }
   
     /**
    * Create an iterator over all the words in the dictionary.
    * No specific word order is guaranteed.
    */   
      public Iterator iterator()
      {
         return dictionary.entrySet().iterator();
      }
   }