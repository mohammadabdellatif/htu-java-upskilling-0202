package jo.edu.htu.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadTextFile {

    public static void main(String[] args) throws IOException {
        Path pwd = Paths.get(".", "io-text-files");
        Path data = pwd.resolve("data.xml");

        try (BufferedReader reader = Files.newBufferedReader(data, Charset.forName("UTF-16"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
//        try (InputStream is = Files.newInputStream(data)) {
//            Reader reader = new InputStreamReader(is, "UTF-16");
//            StringBuilder sb = new StringBuilder();
//            int read;
//            while ((read = reader.read()) != -1) {
//                sb.append((char) read);
//            }
//            System.out.println(sb);
        }
    }
}
