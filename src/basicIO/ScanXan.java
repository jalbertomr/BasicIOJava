package basicIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Bext on 31/01/2017.
 */
public class ScanXan {

    static public void main(String[] args) throws FileNotFoundException {
        Scanner s = null;

        try{
            s = new Scanner(new BufferedReader( new FileReader("xanadu.txt")));
            s.useDelimiter(",\\s*");

            while ( s.hasNext())
                System.out.println(s.next());
        } finally {
            if (s != null) s.close();
        }
    }
}
