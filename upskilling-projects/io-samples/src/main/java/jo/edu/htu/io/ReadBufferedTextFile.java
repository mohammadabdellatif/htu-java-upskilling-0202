package jo.edu.htu.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadBufferedTextFile {

    public static void main(String[] args) throws IOException {
        Path cwd = Paths.get(".", "io-samples");
        Path resolve = cwd.resolve("sample.txt");

        try (InputStream is = Files.newInputStream(resolve)) {
            int read;
            byte[] buffer = new byte[4];
            while ((read = is.read(buffer)) > 0) {
                String readAsStr = new String(buffer, 0, read);
                System.out.println(readAsStr + "->" + read);
            }

        }
        System.out.println("the content of the text file is: ");
    }
}
