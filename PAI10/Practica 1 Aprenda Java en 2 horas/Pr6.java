
import java.io.*;

class Pr6 {
  public static void main (String argv[]) {
    String w;
    BufferedReader reader = new BufferedReader( new FileReader(argv[0]) );
    while (reader.ready()) {
      w = reader.readLine();
      System.out.println(w);
    }
  }
}
