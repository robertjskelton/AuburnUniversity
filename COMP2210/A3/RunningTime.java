   public class RunningTime
   {
      private static final int MERSENNE_3 = 31;
      private static final int MERSENNE_4 = 127;
      private static final int MERSENNE_5 = 8191;
      private static final int MERSENNE_6 = 131071;
      private static final int MERSENNE_7 = 524287;
   
      public static void timeTrial(int N, int seed)
      {
         switch (seed) { 
            case 31:
               N2(N);
               break;
            case 127:
               N4(N);
               break;
            case 8191:
               N3(N);
         }
      }
   
      private static void N2(int N)
      {
         for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
               foo();
         for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
               foo();
      }
   
      private static void N3(int N)
      {
         for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
               for (int k = 0; k < N; k++)
                  foo();
         for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
               for (int k = 0; k < N; k++)
                  foo();
      }
   
      private static void N4(int N)
      {
         for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
               for (int k = 0; k < N; k++)
                  for (int m = 0; m < N; m++)
                     foo();
      }
   
      private static void foo()
      {
         String s1 = "Hello";
         String s2 = "World";
         String s3 = s1 + s2;
      }
   }