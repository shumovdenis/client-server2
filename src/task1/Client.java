package task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 23444;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            String msg;
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            while (true) {
                System.out.print("Ввод: ");
                msg = scanner.nextLine();
                out.println(msg);
                if ("end".equals(msg)) break;
                System.out.println("Ответ " + in.readLine());
            }
        }

    }

}
