package jo.edu.htu.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteTextFile {

    public static void main(String[] args) throws IOException {
        Path pwd = Paths.get(".", "io-text-files");
        Path data = pwd.resolve("data.xml");

        try (BufferedWriter writer = Files.newBufferedWriter(data, Charset.forName("UTF-16"), StandardOpenOption.TRUNCATE_EXISTING)) {
//        try (OutputStream os = Files.newOutputStream(data, StandardOpenOption.TRUNCATE_EXISTING)) {
//            Writer writer = new OutputStreamWriter(os, "UTF-16");
            writer.write("<student>\n");
            writer.write("<first-name>Mohammad</first-name>\n");
            writer.write("<last-name>Abdellatif</last-name>\n");
            writer.write("</student>");
            writer.flush();
        }
    }
}
