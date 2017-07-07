package basicIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Bext on 02/02/2017.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Uso: java EchoServer <numero de puerto>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try ( ServerSocket serverSocket = new ServerSocket(portNumber);
              Socket clientSocket = serverSocket.accept();
              PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true);
              BufferedReader in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()))
            ) {
              String inputLine;
              while ( (inputLine = in.readLine()) != null){
                 out.println(inputLine);
              }
        } catch( IOException e){
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
