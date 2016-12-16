  /** 
    *	This is a class to import/edit profile information.
	 *
	 * @author Robert Skelton
	 * @version 2.5.2012
    */
 
 
   public class ProfileInformation {
   
   //declare instance variables
      private String firstName;
      private String lastName;
      private String location;
      private int age;
      private int status;
      private static final int OFFLINE = 0, ONLINE = 1;
   
   //constructor
       /**
       * @param last Last name
       * @param first First name
       */
      public ProfileInformation(String first, String last) {
         firstName = first;
         lastName = last;
         location = "not specified";
         age = 0;
         status = OFFLINE;
      
      }
   
   //methods
   	 /**
       * @param locationName Your location.
       */
      public void setLocation(String locationName) {
         location = locationName;
      }
      /**
       * @return last Returns the last name 
   	 * @param ageInYears Your age in years
       */
      public boolean setAge(int ageInYears) {
         boolean isSet = false;
         if (ageInYears > 0) {
            age = ageInYears;
            isSet = true;
         }
         return isSet;
      }
      /**
       * @return age Returns your age
       */
      public int getAge() {
         return age;
      }
      /**
       * @return location Returns your current location
       */
      public String getLocation() {
         return location;
      }
      
      /**
       * @return
       */
      public void logOff() {
         status = OFFLINE;
      }
      
   	/**
       * @return
       */
      public void logOn() {
         status = ONLINE; 
      }
   
   	 /**
       * @return toString
   	 */
   //toString methods
      public String toString() {
         String output = "Name: " + firstName + " "
            + lastName + "\n";
         output += "Location: " + location + "\n";
         output += "Age: " + age + "\n";
         output += "Status: ";
         if (status == OFFLINE) {
            output += "Offline";
         }
         else {
            output += "Online";
         }
         
         return output;
      }
   
   }