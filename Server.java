/*
* @author Kai Bergman
* @version 29/05/2020
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server extends Thread {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            Socket socket = null;
            try {
                socket = server.accept();

            } catch (IOException e) {

                System.out.println("Server Stopped." + e);
                return;

            }
            System.out.println("new client");
            new Thread(new WorkerRunnable(socket, "new client")).start();

        }
    }

}
