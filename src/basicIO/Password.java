package basicIO;

import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Bext on 31/01/2017.
 */
public class Password {

    public static void main(String[] args) throws IOException {

        //InputStreamReader in = new InputStreamReader(System.in);
        Console c  = System.console();
        if ( c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login:");
        char[] oldPassword = c.readPassword("Enter your Old Password:");

        if ( verify( login, oldPassword)){
           boolean noMatch;
           do {
                char[] newPassword1 = c.readPassword("Enter your new password:");
                char[] newPassword2 = c.readPassword( "Enter your new password again:");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    changePassword( login, newPassword1);
                    c.format("Password for %s has been Changed.$n");
                }
                Arrays.fill(newPassword1,' ' );
                Arrays.fill(newPassword2, ' ');
           } while( noMatch );
        }
        Arrays.fill( oldPassword, ' ');

    }

    //Dummy verify method
    static boolean verify( String login, char[] oldPassword){
        return true;
    }

    //Dummy changePassword method
    static void changePassword( String login, char[] oldPassword) {

    }
}

