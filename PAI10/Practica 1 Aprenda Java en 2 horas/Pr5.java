

import java.util.ArrayList;

class Pr5 {
   public static void main (String args[]) {
      int k, n, size = args.length;
      ArrayList<Integer> a = new ArrayList();

      for (k = 0; k < size; ++k) {
         a.add(new Integer(args[k]));
         n = a.get(k);
         System.out.println( "a[" + k + "]= " + n );
      }
   }
}
