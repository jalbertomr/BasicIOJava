package basicIO;

import java.io.*;

/**
 * Created by Bext on 31/01/2017.
 */
public class DataStreamDemoOut {
    static final String dataFile = "invoicedata.txt";
    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99};
    static final int[] units = {12, 8, 36, 29, 50};
    static final String[] descs = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java pin",
            "Java Key Chain"
    };

    public static void main(String[] args) throws IOException {

        DataOutputStream out = new DataOutputStream( new BufferedOutputStream( new FileOutputStream(dataFile)));

        for (int i = 0; i < prices.length; i++){
            out.writeDouble(prices[i]);
            out.writeInt(units[i]);
            out.writeUTF(descs[i]);
        }
        out.close();
    }
}
