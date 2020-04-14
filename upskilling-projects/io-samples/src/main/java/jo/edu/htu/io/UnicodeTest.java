package jo.edu.htu.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class UnicodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SortedMap<String, Charset> supportedSets = Charset.availableCharsets();
        supportedSets.keySet().forEach(System.out::println);
        String name = "Hello, سامي";
        // 00000000 01100001  00000000 01100010 UTF-16
        // 01100001 01100010 UTF-8
        byte[] bytes = name.getBytes("Cp1256");
        System.out.println(name.length()+" is represented in: " + bytes.length);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
