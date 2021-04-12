package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 23444;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Calculations calculations = new Calculations();
        System.out.println("task1.Server start \nWaiting connection...");
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()))) {

                out.println("Connection 200 OK \nВведите число");
                String line;
                while ((line = in.readLine()) != null) {
                    int number = Integer.parseInt(line);
                    out.println(calculations.calculation(number));
                    if (line.equals("end")) {
                        break;
                    }
                }
            }
        }
    }
}
