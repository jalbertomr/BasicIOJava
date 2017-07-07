package basicIO;

import java.io.*;

/**
 * Created by Bext on 31/01/2017.
 */
public class DataStreamDemoIn {

    public static void main(String[] args) throws IOException {
        double price;
        int unit;
        String desc;
        double total = 0.0;

        DataInputStream in = null;
        in = new DataInputStream( new BufferedInputStream( new FileInputStream("invoicedata.txt")));
        try {
            while( true) {
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
                total += unit * price;
            }

        } catch (EOFException e){

        }
    }
}
