   import java.util.Arrays;
   import java.util.ArrayList;

/**
 * Brute force way to see what points are collinear.
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @version   10.4.12
 *
 */
 
   public class Brute
   {
      public static void main(String[] args)
      {
      // working with the arguments
         boolean drawing = false;
         if (args.length == 0)
         {
            System.out.println("No file to read.");
            return;
         }
         
         String filename = args[0];
            
      // getting the points and putting into tester
         In in = new In(filename);
         if (!in.exists()) {
         // print error because of invalid input
            System.out.println("Invalid file name.");
            drawing = false;
            return;
         }
         // declare second arg
         if ((args.length > 1) && (args[1].equals("-v"))) {
            String secondArg = args[1]; 
            drawing = true;  
         }
         
          // rescale coordinates and turn on animation mode
         if (drawing)
         {
            StdDraw.setXscale(0, 32768);
            StdDraw.setYscale(0, 32768);
            StdDraw.setPenRadius(0.007); 
            StdDraw.show(0); 
         }
         
      // put txt into points ArrayList
         int N = in.readInt();
         ArrayList<Point> tester = new ArrayList<Point>();
         for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y); 
            tester.add(p);
            if (drawing)
               p.draw(); 
         }
         
      // now go through and test all points
         for (int a = 0; a < tester.size(); a++)
            for (int b = a + 1; b < tester.size(); b++)
               for (int c = b + 1; c < tester.size(); c++)
                  for (int d = c + 1; d < tester.size(); d++)
                  {
                  // find points in a slope, put in array, sort, plot if -v 
                     if  (
                     (tester.get(a).slopeTo(tester.get(b)) 
                     == tester.get(b).slopeTo(tester.get(c))) 
                     && (tester.get(a).slopeTo(tester.get(c)) 
                     == tester.get(a).slopeTo(tester.get(d)))
                     )
                     {
                        Point[] pointArray = new Point[4];
                        pointArray[0] = tester.get(a);
                        pointArray[1] = tester.get(b);
                        pointArray[2] = tester.get(c);
                        pointArray[3] = tester.get(d);
                        Arrays.sort(pointArray);
                        System.out.println(pointArray[0] + " -> " 
                           + pointArray[1] + " -> " + pointArray[2] 
                           + " -> " + pointArray[3]);
                        if (drawing)
                        {
                           pointArray[0].drawTo(pointArray[1]);
                           pointArray[1].drawTo(pointArray[2]);
                           pointArray[2].drawTo(pointArray[3]);
                           StdDraw.show(0);
                        }
                       
                     }
                  }
                  
         
      }
   }