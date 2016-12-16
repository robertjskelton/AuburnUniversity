/**
 * Represents a Book.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @author  James Cross (crossjh@auburn.edu)
 * @version 2010-08-20
 *
 */
   public class Book implements Comparable
   {
      private String author = new String("no title");
      private String title = new String("none");
      protected int pages = 0; 
      
   /**
    * Default constructor.
    *
    */	
      public Book()
      {
         
      }
   
   /**
    * Instantiates book with supplied fields.
    * 
    * @param theAuthor	the book's author
    * @param theTitle	the book's title
    * @param thePages	number of pages in the book
    *
    */
      public Book(String theAuthor, String theTitle, int thePages)
      {
         author = theAuthor; 
         title = theTitle;
         pages = thePages;  
      }
      
   /**
    * Getter for the author field.
    *
    * @return	the book's author
    *
    */	   
      public String getAuthor() 
      {
         return this.author;
      }
   
   /**
    * Getter for the title field.
    *
    * @return	the book's title
    *
    */	   
      public String getTitle() 
      {
         return this.title;
      }
   
   /**
    * Compares this book to another book based on title.
    * Specifies the natural order of books.
    *
    * @param obj	Other book to be compared to this book
    * @return		zero if this book == obj,
    *					positive if this book > obj
    *					negative if this book < obj
    * @see			java.lang.Comparable
    */	
      public int compareTo(Object obj)
      {
         Book otherBook = (Book) obj;
         return this.getTitle().compareTo(otherBook.getTitle());
      }
   
   /**
    * Checks equality of this book and another book based
    * on title. Consistent with compareTo above.
    *
    * @param obj	Other book to be compared to this book
    * @return		true if this book == obj, false otherwise
    *
    */
      @Override
      public boolean equals(Object obj)
      {
         return this.compareTo(obj) == 0;
      }
   
   /**
    * Creates a string representation of this book.
    *
    * @return		string representation of this book
    *
    */
      @Override   
      public String toString()
      {
         return ("\nAuthor: " + author
            + "\nTitle: " + title
            + "\nPages: " + pages);
      }
   }
