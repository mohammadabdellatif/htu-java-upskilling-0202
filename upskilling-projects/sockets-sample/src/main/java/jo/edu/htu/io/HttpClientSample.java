package jo.edu.htu.io;

import java.io.*;
import java.net.Socket;

public class HttpClientSample {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("htu.edu.jo", 80)) {
            System.out.println("connected");
            int localPort = socket.getLocalPort();
            System.out.println("my port: " + localPort);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            PrintStream printer = new PrintStream(outputStream);
            // send HTTP request
            printer.println("GET / HTTP/1.1");
            printer.println("Host: www.htu.edu.jo");
            printer.println("Connection: keep-alive");
            printer.println();

            printer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = reader.readLine();
                System.out.println(line);
            }

        }
    }
}
