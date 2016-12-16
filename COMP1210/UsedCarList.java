   import java.util.Scanner; 
   import java.io.File; 
   import java.util.ArrayList; 
   import java.io.FileNotFoundException; 
 
	/** 
  *	This is a list of used cars for a dealership. 
	 *
	 * @author Robert Skelton
	 * @version 2.26.2012
  */
 
   public class UsedCarList {
   
   /**
    * @param args Unused command line arguments
    */
      public static void main(String[] args) {
         int hondaNo = 0; 
         int toyotaNo = 0; 
         int nissanNo = 0; 
         int mazdaNo = 0; 
         try
         {
            Scanner scan = new Scanner(System.in); 
            String input; 
            UsedCar x; 
            int makeNo; 
            int i; 
            String stockNumberIn; 
            int yearIn; 
            String makeIn; 
            String modelIn; 
            int mileageIn; 
            int originalPriceIn; 
            System.out.print("Input the file to scan: "); 
            input = scan.nextLine(); 
            Scanner inFile = new Scanner(new File(input)); 
            ArrayList carList = new ArrayList < UsedCar >(); 
            while (inFile.hasNext())
            {
               input = inFile.nextLine(); 
            
               Scanner lineScan = new Scanner(input); 
               stockNumberIn = lineScan.next(); 
               yearIn = lineScan.nextInt(); 
               makeIn = lineScan.next(); 
               modelIn = lineScan.next(); 
               mileageIn = lineScan.nextInt(); 
               originalPriceIn = lineScan.nextInt(); 
            
               x = new UsedCar(stockNumberIn, yearIn, makeIn,
                  modelIn, mileageIn, originalPriceIn); 
               carList.add(x); 
            
            
            }
         
            for (i = 0; i < carList.size(); i++)
            {
               x = (UsedCar) carList.get(i); 
               if (x.getMake().equals("Honda"))
               {
                  hondaNo++; 
               }
               else if (x.getMake().equals("Toyota"))
               {
                  toyotaNo++; 
               }
               else if (x.getMake().equals("Mazda"))
               {
                  mazdaNo++; 
               }
               else if (x.getMake().equals("Nissan"))
               {
                  nissanNo++; 
               }
            }
         
            while (true)
            {
               System.out.println("\n1. Honda("  +  hondaNo
                   +  ") 2. Mazda("  +  mazdaNo
                   +  ") 3. Nissan("  +  nissanNo 
                   +  ") 4. Toyota("  +  toyotaNo  +  ")"); 
               System.out.print("\nEnter Car Make"
                   +  "(1, 2, 3, 4, or 99 for all, 0 to end): "); 
               makeNo = scan.nextInt();
               System.out.print("\n"); 
               if (makeNo == 1)//Honda
               {
                  for (i = 0; i < carList.size(); i++)
                  {
                     x = (UsedCar) carList.get(i); 
                     if (x.getMake().equals("Honda"))
                     {
                        System.out.print(x + "\n------------------------\n"); 
                     }
                  }
                  System.out.print("\nTotal Number of Cars Listed: " 
                     + hondaNo + "\n");
               }
               else if (makeNo == 2)//Mazda
               {
                  for (i = 0; i < carList.size(); i++)
                  {
                     x = (UsedCar) carList.get(i); 
                     if (x.getMake().equals("Mazda"))
                     {
                        System.out.print(x + "\n------------------------\n"); 
                     }
                  }
                  System.out.print("\nTotal Number of Cars Listed: "
                     + mazdaNo + "\n");
               }
               else if (makeNo == 3)//Nissan
               {
                  for (i = 0; i < carList.size(); i++)
                  {
                     x = (UsedCar) carList.get(i); 
                     if (x.getMake().equals("Nissan"))
                     {
                        System.out.print(x + "\n------------------------\n"); 
                     }
                  }
                  System.out.print("\nTotal Number of Cars Listed: " 
                     + nissanNo + "\n");
               }
               else if (makeNo == 4)//Toyota
               {
                  for (i = 0; i < carList.size(); i++)
                  {
                     x = (UsedCar) carList.get(i); 
                     if (x.getMake().equals("Toyota"))
                     {
                        System.out.print(x + "\n------------------------\n"); 
                     }
                  }
                  System.out.print("\nTotal Number of Cars Listed: " 
                     + toyotaNo + "\n");
               }
               else if (makeNo == 99)//All
               {
                  for (i = 0; i < carList.size(); i++)
                  {
                     x = (UsedCar) carList.get(i); 
                     System.out.print(x + "\n------------------------\n"); 
                  }
                  System.out.print("\nTotal Number of Cars Listed: "
                     + i + "\n");
               }
               else if (makeNo == 0)//quit
               {
                  break; 
               }
               else
               {
                  System.out.println("cats"); 
               }
            }
         }
         
            catch (FileNotFoundException e)
            {
            }
      
      }
   }
   	
   	  
  
  
  
