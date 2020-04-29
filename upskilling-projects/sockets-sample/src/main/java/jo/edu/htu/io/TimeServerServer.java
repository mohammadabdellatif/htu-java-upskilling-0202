package jo.edu.htu.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServerServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("read to accept connections");
            OutputStream outputStream;
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    System.out.println("client is accepted");
                    outputStream = client.getOutputStream();
                    LocalDateTime now = LocalDateTime.now();
                    byte[] time = new byte[]{
                            (byte) now.getDayOfMonth(),
                            (byte) now.getMonthValue(),
                            (byte) (now.getYear() / 100),
                            (byte) (now.getYear() % 100),
                            (byte) now.getHour(),
                            (byte) now.getMinute(),
                            (byte) now.getSecond(),
                            'A'
                    };

                    outputStream.write(time);
                    outputStream.flush();
                }
            }
        }
    }
}
