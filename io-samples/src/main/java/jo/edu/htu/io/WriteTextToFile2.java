package jo.edu.htu.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteTextToFile2 {

    public static void main(String[] args) {
        Path targetDir = Paths.get(".", "io-samples");
        Path filePath = targetDir.resolve("sample.xml");
        File asFile = filePath.toFile();

        // try with resource
        try (OutputStream os = new FileOutputStream(asFile)) {
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
