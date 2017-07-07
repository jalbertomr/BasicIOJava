package basicIO;

import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Bext on 01/02/2017.
 */
public class ObjectStreams {
    static final String dataFile = "invoicedata.txt";
    static final BigDecimal[] prices = {
            new BigDecimal("19.99"),
            new BigDecimal("9.99"),
            new BigDecimal("15.99"),
            new BigDecimal("3.99"),
            new BigDecimal("4.99")
    };
    static final int units[] = {12, 8, 13, 29,50};
    static final String descs[] = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java pin",
            "Java Key Chain"
    };


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(dataFile)));
            oos.writeObject(Calendar.getInstance());
            for ( int i = 0; i < prices.length; i++){
                oos.writeObject(prices[i]);
                oos.writeInt(units[i]);
                oos.writeUTF(descs[i]);
            }
        } finally {
            if (oos != null) oos.close();
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            Calendar date = null;
            BigDecimal price;
            int unit;
            String desc;
            BigDecimal total = new BigDecimal(0);

            date = (Calendar) ois.readObject();
            System.out.format("On %tA %<tB %<te, %<tY:%n", date);

            try {
                while (true) {
                    price = (BigDecimal) ois.readObject();
                    unit = ois.readInt();
                    desc = ois.readUTF();
                    System.out.format("You ordered %d units of %s at $%.2f%n", unit, desc, price);
                    total = total.add( price.multiply( new BigDecimal(unit)));
                }
            } catch (EOFException e) {

            }

            System.out.format("For a TOTAL of: $%.2f%n", total);
        } finally {
            if ( ois != null)ois.close();
        }

    }
}
