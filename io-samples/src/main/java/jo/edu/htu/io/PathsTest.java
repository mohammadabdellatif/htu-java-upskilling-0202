package jo.edu.htu.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

    public static void main(String[] args) {
        Path path = Paths.get("M:", "work", "dir1");
        System.out.println(path);
        System.out.println(path.getFileName());
        Path root = path.getRoot();
        System.out.println(root);
// /home/user
        System.out.println("===========for each===========");
        for (Path sec : path) {
            System.out.println(sec);
        }
        System.out.println("===by index===");
        System.out.println(path.getName(1));

        Path sampleFile = path.resolve("sample.txt");
        System.out.println(sampleFile);

        Path subpath = path.subpath(1, 2);
        System.out.println("sub: " + subpath);
        System.out.println("original: " + path);
    }
}
