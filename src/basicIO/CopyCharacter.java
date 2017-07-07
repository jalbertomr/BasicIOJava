package basicIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Bext on 30/01/2017.
 */
public class CopyCharacter {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try{
            fileReader = new FileReader("xanadu.txt");
            fileWriter = new FileWriter("FileWriter.txt");

            int c;
            while ( (c = fileReader.read()) != -1 )
                fileWriter.write(c);
        } finally {
            if (fileReader != null) fileReader.close();
            if (fileWriter != null) fileWriter.close();
        }
    }
}
