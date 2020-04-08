package jo.edu.htu.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

    public static void main(String[] args) {
        Path cwd = Paths.get(".").toAbsolutePath().normalize();
        System.out.println(cwd);

        Path parent = cwd.getParent().getParent();
        System.out.println(parent);

        Path relativize = parent.relativize(cwd);
        System.out.println(relativize);

        relativize = cwd.relativize(parent);
        System.out.println(relativize);

        // m:
        System.out.println(parent.startsWith(cwd));
        System.out.println(cwd.startsWith(parent));


        Path c = Paths.get("C:");
//        System.out.println(cwd.relativize(c));
//        System.out.println(c.relativize(cwd));
    }
}
