   public class Test {
   
      public static void main(String[] args) {
         Number n = new Number(4);
         n.setDigit(0, 0);
         n.setDigit(1, 1);
         n.setDigit(2, 2);
         n.setDigit(3, 3);
         Game g = new Game(n);
         System.out.println(n);
         System.out.println(g.isGameOver());
         System.out.println(g.play("0132"));
         System.out.println(g.isGameOver());
         System.out.println(g.play("1234"));
         System.out.println(g.isGameOver());
         System.out.println(g.play("0123"));
         System.out.println(g.isGameOver());
         g.play("key");
         g.play("end");
         g.play("");
      
      
      
      
      
      
      
      }
   
   }