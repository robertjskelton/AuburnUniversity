   import java.util.ArrayList;
   import java.util.Collections;

/**
 * Fast  way to see what points are collinear.
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @version   10.7.12
 *
 */

   public class Fast 
   {   
      public static void main(String[] args)
      { //if no args, quit
         if (args.length == 0)
         {
            System.out.println("No file to read.");
            return;
         }
         
         ArrayList<Point> tester = new ArrayList<Point>();
         // sets input file
         String filename = args[0];  
         
         In in = new In(filename);
         int N = in.readInt();
      
         for (int i = 0; i < N; i++)
         {    
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            
           // put points into tester
            tester.add(p);
         }
        
         ArrayList<ArrayList> lineArray = new ArrayList<ArrayList>();
         ArrayList<Double> slopeArray = new ArrayList<Double>();
         int length = tester.size();
         for (int p = 0; p < length - 1; p++)
         {
            Point origin = (Point) tester.get(0);
            
         // remove first array item to use as the origin
            tester.remove(0);
            Collections.sort(tester, origin.SLOPE_ORDER);
            
            // keeps a count of all points in a line
            int count = 0;
            double slope = origin.slopeTo((Point) tester.get(0));
            int j = 1;
            for (j = 1; j < tester.size(); j++)
            {
               if (slope == origin.slopeTo((Point) tester.get(j)))
                  count++;
                  
               else
               {
                  if (count >= 2 && !slopeArray.contains(slope))
                  {
                     slopeArray.add(slope);
                     ArrayList<Point> line = new ArrayList<Point>();
                     for (int i = j - (count + 1); i < j; i++)
                        line.add(tester.get(i));
                     
                     line.add(origin);            
                     Collections.sort(line, ((Point) tester.get(0)).POINT_ORDER);
                     lineArray.add(line);
                  }
                  slope = origin.slopeTo((Point) tester.get(j));
                  // reset the count
                  count = 0;
               }
            }
         
            if (count >= 2 && !slopeArray.contains(slope))
            {
               ArrayList<Point> line = new ArrayList<Point>();
               for (int i = j - (count + 1); i < j; i++)
                  line.add(tester.get(i));
               
               line.add(origin);            
               Collections.sort(line, ((Point) tester.get(0)).POINT_ORDER);
               count = 0;
               lineArray.add(line);
            }
         }
      
         for (int p = 0; p < lineArray.size(); p++)
         {
            System.out.print("\n");
            ArrayList line = (ArrayList) lineArray.get(p);
            int j = 0;
            for (j = 0; j < line.size() - 1; j++)
               System.out.print((Point) line.get(j)+" -> "); 
            System.out.print((Point) line.get(j));
         }
      
         if (args.length > 1)
         {
            if (args[1].equals("-v"))
            {
               StdDraw.setXscale(0, 32768);
               StdDraw.setYscale(0, 32768);
               StdDraw.show(0);
               StdDraw.setPenColor(StdDraw.RED);
               StdDraw.setPenRadius(0.007);
               // for all Point p in tester, draw p
               for (Point p : tester)
                  p.draw();
               
               for (int p = 0; p < lineArray.size(); p++)
               {
                  ArrayList line = (ArrayList) lineArray.get(p);
                  Point first = (Point) line.get(0);
                  Point last = (Point) line.get(line.size()-1);
                  first.drawTo(last);
               }
               StdDraw.show(0);
            }
         }
      }    
   }
