package basicIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bext on 31/01/2017.
 */
public class ScanSum2 {

    static public void main(String[] args) throws IOException {

        Scanner s = null;
        double sum = 0;
        double num;
        String line = new String();
        String nombres = new String();

        try{
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));

            while (s.hasNext()){
                if (s.hasNextDouble()) {
                    num = s.nextDouble();
                    sum += num;
                    System.out.format("%1$+020.5f  %2$+020.5f %n", num, sum);
                } else {
                    line = s.nextLine();
                    switch (line) {
                        case "Juan": nombres = nombres + line;
                            break;
                        case "Beto": nombres = nombres + line;
                            break;
                        case "Marisol": nombres = nombres + line;
                            break;
                        default:
                            break;
                    }
                }
            }

            System.out.println(sum + " " + nombres);
        }finally{
            if (s != null) s.close();
        }
    }
}
