 	/** 
    *	This is a class to change information about a dog.
	 *
	 * @author Robert Skelton
	 * @version 2.8.2012
    */
  
 
 
   public class PetDog {
   
   //declare instance variables
      private String name;
      private String breed;
      private int age;
      private double weight;
      private String owner;
   
   //constructor
   	 /**
       * @param nameIn Name of dog.
   	 * @param breedIn The breed of dog.
   	 * @param ageIn The age of the dog.
   	 * @param weightIn How much the dog weighs.
       */
      public PetDog(String nameIn, String breedIn, int ageIn, double weightIn) {
         name = nameIn;
         breed = breedIn;
         age = ageIn;
         weight = weightIn;
      }
       /**
       * @param 
       */
   
   //methods
   
   	 /**
       * @return name 
       */
      public String getName() {
         return name;
      }
      
   	 /**
       * @param nameOfDog Returns the name of dog.
   	 * @return boolean
       */
      public boolean setName(String nameOfDog) { 
      
         name = nameOfDog;
         return true;	
      }
      
   	 /**
       * @return breed
       */
      public String getBreed() {
         return breed;
      }
      
   	 /**
       * @param breedIn breed of the dog
   	 * @return boolean
       */
      public boolean setBreed(String breedIn) {
         if (breedIn == null) {
            return false;
         }
         else {
            breed = breedIn;
            return true;
         }
      }
      
   	 /**
       * @return age Returns your age
       */
      public int getAge() {
         return age;
      }
      
   	/**
       * @return age Returns your age
   	 * @param ageIn  Inputs the dogs age
       */
      public boolean setAge(int ageIn) {
         if (ageIn < 0) {
            return false;
         }
         else {
            this.age = ageIn;
            return true;
         }
      }
      
   	 /**
       * @return weight 
       */
      public double getWeight() {
         return weight;
      }
      
       /**
   	 * @param weightIn The dog's weight.
       * @return age Returns your age
       */
      public boolean setWeight(double weightIn) {
         if (weightIn < 0) {
            return false;
         }
         else {
            weight = weightIn;
            return true;
         }
      }
      
   	 /**
       * @return owner Returns the owner's name.
       */
      public String getOwner() {
         return owner;
      }
   	
   	 /**
       * @return ownerIn
   	 * @param ownerIn The owner's name.
       */
      public boolean setOwner(String ownerIn) {
         owner = ownerIn;
         if (owner == null) {
            return false;
         }
         else {
            this.owner = owner;
            return true;
         }
      }
      
   	 /**
       * @return toString method
       */
   	
   //toString method
      public String toString() {
         String output = name + " (" + breed + ")\n"
            + "Age: " + age + "\n"
            + "Weight: " + weight + "\n"
            + "Owner: " + owner;
         return output;
      }
   }
