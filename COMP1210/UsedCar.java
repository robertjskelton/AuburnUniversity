
   import java.text.NumberFormat;
   import java.text.DecimalFormat;

/** 
    *	This is the class to input car statistics. 
	 *
	 * @author Robert Skelton
	 * @version 2.19.2012
    */
   
   public class UsedCar {
   //instance variables
   /**
       * @param numberIn inputs a number
       */
      public static final String HONDA = "Honda";
      /**
       * @param numberIn inputs a number
       */
      public static final String TOYOTA = "Toyota";
      /**
       * @param numberIn inputs a number
       */
      public static final String MAZDA = "Mazda";
      /**
       * @param numberIn inputs a number
       */
      public static final String NISSAN = "Nissan";
      private String stockNumber;
      private int year;
      private String make;
      private String model;
      private int mileage;
      private int originalPrice;
      private double referencePrice;
      private NumberFormat currencyFmt;
      private DecimalFormat dollarFmt; 
      	
     
   	//constructor
   	/**
       * @param stockNumberIn inputs the stock number
   	 * @param yearIn inputs the year
   	 * @param makeIn inputs the make
   	 * @param modelIn inputs the model
   	 * @param mileageIn inputs the mileage
   	 * @param originalPriceIn inputs the original price
       */
      public UsedCar(String stockNumberIn, int yearIn, String makeIn,
       String modelIn, int mileageIn, int originalPriceIn) {
         stockNumber = stockNumberIn;
         year = yearIn;
         make = makeIn;
         model = modelIn;
         mileage = mileageIn;
         originalPrice = originalPriceIn;
         currencyFmt = NumberFormat.getCurrencyInstance();
         dollarFmt = new DecimalFormat("$0,000");
      }
   	
   	//methods
   	/**
       * @param stockNumberIn inputs the stock number
       */
      public void setStockNo(String stockNumberIn) {
         stockNumber = stockNumberIn;
      }
      
   	/**
       * @return stockNumber returns the stock number
       */
      public String getStockNo() {
         return stockNumber;
      }
      
   	/**
       * @return year returns the year
       */
      public int getYear() {
         return year;
      }
      
   	/**
       * @param yearIn inputs the year
       */
      public void setYear(int yearIn) {
         year = yearIn;
      }
      
   	/**
       * @param makeIn inputs the make
   	 * @return boolean returns true or false
       */
      public boolean setMake(String makeIn) {
         if (makeIn == "Honda") {
            make = makeIn;
            return true;
         }
         else if (makeIn == "Toyota") {
            make = makeIn;
            return true;
         }
         else if (makeIn == "Nissan") {
            make = makeIn;
            return true;
         }
         else if (makeIn == "Mazda") {
            make = makeIn;
            return true;
         }
         else {
            return false;
         }
      }
      
   	/**
       * @return make returns the make
       */
      public String getMake() {
         return make;
      }
      
   	/**
       * @param modelIn inputs the model
       */
      public void setModel(String modelIn) {
         model = modelIn;
      }
   	
   	/**
       * @return model returns the model
       */
      public String getModel() {
         return model;
      }
      
   	/**
       * @param mileageIn inputs the mileage
       */
      public void setMileage(int mileageIn) {
         mileage = mileageIn;
      }
      
   	/**
       * @return mileage returns the mileage
       */
      public int getMileage() {
         return mileage;
      }
      
   	/**
       * @return originalPrice returns the original price
       */
      public int getOriginalPrice() {
         return originalPrice;
      }
   	
   	/**
       * @param originalPriceIn inputs the original price
   	 * @return boolean returns true or false
       */
      public boolean setOriginalPrice(int originalPriceIn) {
         if (originalPriceIn > 0) {
            originalPrice = originalPriceIn;
            return true;
         }
         else {
            return false;
         }
         
      }
      
   	/**
       * @return referencePrice returns the sale price
       */
      public double calcReferencePrice() {
         double x;
         if (mileage > 120000) {
            x = .45;
         }
         else if (mileage <= 120000 && mileage > 70000) {
            x = .7;
         }
         else {
            x = 1;
         }
         double months = (2012 - year) * 12;
         referencePrice = (x - (months / 320)) * originalPrice; 
         return referencePrice;
      }
   	
   	//toString method
   	/**
       * @return toString returns the string
       */
      public String toString() {
         
         return "Stock Number: " + stockNumber
            + "\nYear: " + year 
            + "\nMake: " + make
            + "\nModel: " + model
            + "\nMileage: " + mileage
            + "\nOriginal Price: " + dollarFmt.format(originalPrice)
            + "\nReference Price: " + dollarFmt.format(calcReferencePrice());
      }
   }