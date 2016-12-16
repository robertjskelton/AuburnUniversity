    /** 
    *	This is another class for Project 4A.
	 *
	 * @author Robert Skelton
	 * @version 2.8.2012
    */
 
 
   public class PetOwner {
   //instance variables
      private String name;
      private String address;
      private PetDog myDog;
      
   	 /**
       * @param nameIn the name of the owner
   	 * @param addressIn the address
       */
   //constructor
      public PetOwner(String nameIn, String addressIn) {
         name = nameIn;
         address = addressIn;
         myDog = null;
      } 
   
       /**
       * @return name returns the owners name
       */
   //methods
      public String getName() {
         return name;
      }
      
   	 /**
       * @param nameIn inputs the name
   	 * @return boolean
       */
      public boolean setName(String nameIn) {
         if (nameIn == null) {
            return false;
         }
         else {
            name = nameIn;
            return true;
         }
      }
      
   	 /**
       * @return address
       */
      public String getAddress() {
         return address;
      }
      
   	 /**
       * @return boolean
   	 * @param addressIn inputs the address
       */
      public boolean setAddress(String addressIn) {
         if (address == null) {
            return false;
         }
         else {
            address = addressIn;
            return true;
         }
      }
      
   	 /**
       * @return myDog myDog object
       */
      public PetDog getMyDog() {
         return myDog;
      }
      
   	 /**
       * @param dogIn iputs myDog object
       */
      public void setMyDog(PetDog dogIn) {
         myDog = dogIn;
      }
      
   	 /**
       * @param changed changed dogs name
       */
      public void changeDogName(String changed) {
         myDog.setName(changed);
      }
       /**
       * @return cost the cost of supplies/food
       */
      public double estimatePetCost() {
         double dogFood = myDog.getWeight() * .7;
         int other;
         if (myDog.getAge() < 2) {
            other = 100;
         }
         else if (myDog.getAge() > 2 && myDog.getAge() < 9) { 
            other = 40;
         }
         else {
            other = 120;
         }
         double cost = other + dogFood;
         return cost;
      } 
       /**
       * @return toString the toString command
       */
   //toString method
      public String toString() {
         String output;
         output = getName() + "\n";
         output += myDog.getName(); // + "\n" + getMyDog().getName();
         output += " (" + myDog.getBreed() + ")\n";
         output +=  "Age: " + myDog.getAge() + "\n";
         output +=  "Weight: " + myDog.getWeight() + " lbs\n";
         output +=  "Owner: " + getName(); 
         output +=  "\n" + getAddress();
         return output;
      }
      
   }