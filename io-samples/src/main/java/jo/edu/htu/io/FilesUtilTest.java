package jo.edu.htu.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FilesUtilTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".", "io-samples", "info.txt");
        System.out.println(Files.exists(path));
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        Files.write(path, "hello world".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));
        Files.copy(path, path.getParent().resolve("info-copy.txt"), StandardCopyOption.REPLACE_EXISTING);
//        try (OutputStream outputStream = Files.newOutputStream(path)) {
//            byte[] helloWorlBytes = "hello world\n".getBytes();
//            outputStream.write(helloWorlBytes);
//            LocalDateTime now = LocalDateTime.now();
//            byte[] currentTimeBytes = now.toString().getBytes();
//            outputStream.write(currentTimeBytes);
//            outputStream.flush();
//        }

//        try (InputStream inputStream = Files.newInputStream(path)) {
//            byte[] buffer = new byte[1024];
//            StringBuilder sb = new StringBuilder();
//            int read;
//            while ((read = inputStream.read(buffer)) > 0) {
//                sb.append(new String(buffer, 0, read));
//            }
//            System.out.println("file content is: " + sb);
//        }
    }
}
