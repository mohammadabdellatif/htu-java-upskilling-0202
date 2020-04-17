package jo.edu.htu.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteBytesToFile {

    public static void main(String[] args) {
        Path targetDir = Paths.get(".", "io-samples");
        Path filePath = targetDir.resolve("sample.txt");
        File asFile = filePath.toFile();
        try {
            OutputStream os = new FileOutputStream(asFile);
            // -128 <-> 127
            os.write(0xfeff0da6);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
