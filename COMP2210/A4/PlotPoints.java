/**
 * Plot points to illustrate data.
 *
 */
 
   import java.util.ArrayList;
   
   public class PlotPoints {
   
      public static void main(String[] args) {
      
        // rescale coordinates and turn on animation mode
         StdDraw.setXscale(0, 32768);
         StdDraw.setYscale(0, 32768);
         StdDraw.setPenRadius(0.007); //new
         StdDraw.show(0); 
      
        // read in the input
         ArrayList<Point> points = new ArrayList<Point>(); //new
         String filename = args[0];
         In in = new In(filename);
         int N = in.readInt();
         for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points.add(p); //new
         }
         
      	
         points.get(0).drawTo(points.get(5)); //new
      
        // display to screen all at once
         StdDraw.show(0);
         
      	
      	
      	
      	// my tests
         // Point a  = new Point(60,50);
         // Point b = new Point(1,3);
         // double slope1 = a.slopeTo(b);
         // double compare1 = a.compareTo(b);
         // System.out.println(slope1 + " " + compare1);
      //    
         // Point c  = new Point(0,0);
         // Point d = new Point(500,500);
         // Point g = new Point(500,600);
         // double slope2 = g.slopeTo(d);
         // double compare2 = g.compareTo(d);
         // System.out.println(slope2 + " " + compare2);
         // int tester = c.SLOPE_ORDER.compare(g, d);
         // System.out.println("Tester: " + tester);
      //    
         // Point e  = new Point(50,500);
         // Point f = new Point(50,500);
         // double slope3 = e.slopeTo(f);
         // double compare3 = e.compareTo(f);
         // System.out.println(slope3 + " " + compare3);
      }
   
   }