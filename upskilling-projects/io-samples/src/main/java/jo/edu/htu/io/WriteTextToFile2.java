package jo.edu.htu.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteTextToFile2 {

    public static void main(String[] args) {
        Path targetDir = Paths.get(".", "io-samples");
        Path filePath = targetDir.resolve("hello-message");
        // try with resource
        try (OutputStream os = Files.newOutputStream(filePath)) {
            String name =  "Hello";
            // UTF-8 encoding
            System.out.println(name.length());
            byte[] bytes = name.getBytes("UTF-16");
            System.out.println(bytes.length);
            os.write(bytes);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
