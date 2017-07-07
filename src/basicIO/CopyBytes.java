package basicIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Bext on 30/01/2017.
 */
public class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try{
            fileInputStream = new FileInputStream("xanadu.txt");
            fileOutputStream = new FileOutputStream("FileOutputStream.txt");

            int c;
            while ( (c = fileInputStream.read()) != -1 ){
                fileOutputStream.write(c);
            }
        } finally {
          if (fileInputStream != null) fileInputStream.close();
          if (fileOutputStream != null) fileOutputStream.close();
        }

    }
}
