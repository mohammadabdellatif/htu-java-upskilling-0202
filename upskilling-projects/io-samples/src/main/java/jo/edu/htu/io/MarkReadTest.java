package jo.edu.htu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarkReadTest {

    public static void main(String[] args) throws IOException {
        Path cwd = Paths.get(".", "io-samples");
        Path resolve = cwd.resolve("sample.txt");
        File file = resolve.toFile();

        try (InputStream is = new FileInputStream(file)) {
            System.out.println("mark supported: " + is.markSupported());
            System.out.println((char) is.read());
            is.skip(3);
            System.out.println((char) is.read());
            System.out.println((char) is.read());

            is.mark(10);
            System.out.println((char)is.read());// mark position
            System.out.println((char)is.read());
            is.reset();// should throw exception (not supported by fileinputstream)
            System.out.println((char)is.read());// same position as line 24
        }

    }
}
