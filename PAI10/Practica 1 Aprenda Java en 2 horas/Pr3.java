class Pr3 {
   public static void main (String[] args) {
      Pair p1 = new Pair(1, 1);
      Pair p2 = new Pair(4, 5);
      p1.swap(p2);
      System.out.println(p1);
      System.out.println(p2);
      p1.reflex();
      System.out.println(p1);

      Pair p, q;
      p = new Pair (1, 2);
      q = p; 
      q.reflex();
      System.out.println(p);
      System.out.println(q);
   }
}
