package jo.edu.htu.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadTextFile {

    public static void main(String[] args) throws IOException {
        Path cwd = Paths.get(".", "io-samples");
        Path resolve = cwd.resolve("sample.txt");
        File file = resolve.toFile();
        StringBuilder sb = new StringBuilder();
        byte a = (byte) 0b00000000;// 97
        int aAsInt = 0b00000000_00000000_00000000_00000000;
        int minusOne = 0b11111111_11111111_11111111_11111111;

        try (InputStream is = new FileInputStream(file)) {
            System.out.println("mark supported: " + is.markSupported());

            int available = is.available();
            System.out.println("available: " + available);
            while (is.available() > 0) {
                System.out.println("remaining: " + is.available());
                byte b = (byte) is.read();
                sb.append((char) b);
            }
//            int read;
//            while ((read = is.read()) != -1) {
//                System.out.println("remaining: " + is.available());
//                byte b = (byte) read;
//                sb.append((char) b);
//            }
        }
        System.out.println("the content of the text file is: ");
        System.out.println(sb.toString());
    }
}
