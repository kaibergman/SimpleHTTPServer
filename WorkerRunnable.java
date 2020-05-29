import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class WorkerRunnable implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    public void run() {

        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            Date now = new Date();
            String response = "HTTP/1.1 200 OK\r\n\r\n" + now;
            output.write(response.getBytes("UTF-8"));

            output.close();
            input.close();
            System.out.println("Request processed: " + now);
        } catch (IOException e) {
            // report exception somewhere.
            e.printStackTrace();
        }
    }
}
