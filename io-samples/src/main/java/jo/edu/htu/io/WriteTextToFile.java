package jo.edu.htu.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteTextToFile {

    public static void main(String[] args) {
        Path targetDir = Paths.get(".", "io-samples");
        Path filePath = targetDir.resolve("sample.xml");
        File asFile = filePath.toFile();
        try {
            // file handle
            OutputStream os = new FileOutputStream(asFile, false);
            try {
                String name = "<employee>\n\t<first-name>Mohammad</first-name>\n\t<last-name>Abdellatif</last-name>\n</employee>";
                // UTF-8 encoding
                System.out.println(name.length());
                byte[] bytes = name.getBytes("UTF-16");
                System.out.println(bytes.length);
                os.write(bytes);
                os.flush();
            } finally {
                os.close();// release the resource (file handle)
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
