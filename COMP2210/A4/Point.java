/**
 * Point.java. An immutable data type for points in the plane.
 *
 * @author    Robert Skelton (robertjskelton@gmail.com)
 * @version   9.27.12
 *
 */

   import java.util.Comparator;

   public class Point implements Comparable<Point> {
   
    // compare points by slope
      public final Comparator<Point> SLOPE_ORDER = 
      new ComparePointsBySlope(); 
      // could not run as private
      public final Comparator<Point> POINT_ORDER = new SortByPoint();
   
      private final int x;    // x coordinate
      private final int y;    // y coordinate
   
    // create the point (x, y)
      public Point(int x, int y) {
        /* DO NOT MODIFY */
         this.x = x;
         this.y = y;
      }
   
    // plot this point to standard drawing
      public void draw() {
        /* DO NOT MODIFY */
         StdDraw.point(x, y);
      }
   
    // draw line between this point and that point to standard drawing
      public void drawTo(Point that) {
        /* DO NOT MODIFY */
         StdDraw.line(this.x, this.y, that.x, that.y);
      }
   
    // slope between this point and that point
      public double slopeTo(Point that) {
      /* DO NOT MODIFY */
      // point 0
         double thisX = this.x;
         double thisY = this.y;
      
      // point 1
         double thatX = that.x;  
         double thatY = that.y;
         
      // special cases
         double slope = 0;  
         if ((thatX - thisX == 0) && (thatY - thisY == 0))
            slope = java.lang.Double.NEGATIVE_INFINITY;
         else if (thatX - thisX == 0)
            slope = java.lang.Double.POSITIVE_INFINITY;
         //find slope
         else
            slope = (thatY - thisY) / (thatX - thisX);
         return slope; 
      }
   
    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
      public int compareTo(Point that) {
      /* DO NOT MODIFY */
      // point 0
         double thisX = this.x;
         double thisY = this.y;
      
      // point 1
         double thatX = that.x;  
         double thatY = that.y;
         
         if (((thisY < thatY) || (thisY == thatY)) && (thisX < thatX))
            return -1;
         if ((thisX == thatX) && (thisY == thatY))
            return 0;
         else 
            return 1;
      }
   
      
      private class ComparePointsBySlope implements Comparator<Point> {
       /* DO NOT MODIFY */   
         public int compare(Point point1, Point point2)
         {  /* DO NOT MODIFY */
         // point 0 comparable
            double x0 = x;
            double y0 = y;
         // point 1
            double x1 = point1.x;
            double y1 = point1.y;
         // point 2
            double x2 = point2.x;  
            double y2 = point2.y;
         // slopes
            double slope1 = (y1 - y0) / (x1 - x0);
            double slope2 = (y2 - y0) / (x2 - x0);
         // return values
            if (slope1 < slope2)
               return -1;
            else if (slope1 == slope2)
               return 0;
            else 
               return 1;
         }
      }
   
    // return string representation of this point
      public String toString() {
        /* DO NOT MODIFY */
         return "(" + x + ", " + y + ")";
      }
   
      public final class SortByPoint implements Comparator<Point>
      {    
         public int compare(Point a, Point b)
         {
            int returnValue = -2;
         
            if (a.y < b.y)
               returnValue = -1;
            
            if (a.y > b.y)
               returnValue = 1;
            
            if (a.y == b.y)
            {
               if (a.x < b.y)
                  returnValue = -1;
               if (a.x > b.x)
                  returnValue = 1;
               if (a.x == b.x)
                  returnValue = 0;   
            }
            return returnValue;
         }
      }
   }
