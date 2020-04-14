package jo.edu.htu.io;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
        // both are absolute paths
        // normalized -> not-normalized (contains relative paths)
        // M:\github -> M:\htu\weather-task\..\..\github
        // holder for a path, for a file or a directory that could exists or not
        File workDirectory = new File("M:\\work");
        File file = new File("M:/work/sample.txt");
        System.out.println("file exists: " + file.exists());
        if (!file.exists()) {
            System.out.println("i will create a new file");
            file.createNewFile();
        }
        File sub = new File(workDirectory, "dir1" + File.separatorChar + "sub1/sub2");

        System.out.println(sub);
        if (!sub.exists()) {
            System.out.println("create directory");
            sub.mkdirs();
        }
        System.out.println("done");
    }
}
