package jo.edu.htu.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

public class TimeServerClient {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 9090)) {
            byte[] message = new byte[8];
            InputStream inputStream = socket.getInputStream();
            inputStream.read(message);
            System.out.println(Arrays.toString(message));
        }
    }
}
