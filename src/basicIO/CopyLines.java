package basicIO;

import java.io.*;

/**
 * Created by Bext on 30/01/2017.
 */
public class CopyLines {

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try{
            bufferedReader = new BufferedReader(new FileReader("xanadu.txt"));
            printWriter = new PrintWriter( new FileWriter("PrintWriter.txt"));

            String line;
            while (  (line = bufferedReader.readLine()) != null )
                printWriter.println( line);
        } finally {
            if (bufferedReader != null) bufferedReader.close();
            if (printWriter != null) printWriter.close();
        }
    }
}
