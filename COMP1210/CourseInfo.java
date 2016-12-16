   /** 
    * Prints the course name, semester, and instructor of COMP 
	 * 1210 followed by a description of the course. 
	 *
	 * @author Lauren Goff, rev Robert Skelton
	 * @version 1-05-2012
    */
   public class CourseInfo {
   
      /**
       * Prints course information to std output.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
        
         // print name, semester, & instructor
         System.out.println("Course Name: COMP 1210");
         System.out.println("Semester: Spring 2012");
         System.out.println("Instructor: Dr. Cross");
         System.out.println("");
      	
         // print description
         System.out.println("Description:"); 
         System.out.println("COMP 1210 uses the Java programming language "
            + "to cover the basics of software development.");
      }
   }