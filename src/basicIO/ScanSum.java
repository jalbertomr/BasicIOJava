package basicIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Bext on 31/01/2017.
 */
public class ScanSum {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = null;
        double sum = 0;
        double num = 0;

        try{
            s = new Scanner( new BufferedReader(new FileReader("usnumbers.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()){
                if (s.hasNextDouble()) {
                    num = s.nextDouble();
                    sum += num;

                    System.out.format("%1$+020.5f  %2$+020.5f %n", num , sum);
                } else
                    s.next();
            }
        } finally {
            if (s != null) s.close();
        }

        System.out.println(sum);
    }
}
