package jo.edu.htu.io;

import java.io.File;
import java.io.IOException;

public class CurrentWorkingDirectory {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        File absoluteFile = file.getAbsoluteFile();
        System.out.println(file);
        System.out.println(absoluteFile);

        File canonicalFile = absoluteFile.getCanonicalFile();
        System.out.println(canonicalFile);

        File sampleText = new File("." + File.separatorChar + "sample.txt");
        if (!sampleText.exists())
            sampleText.createNewFile();
        System.out.println(sampleText);
        System.out.println(sampleText.getCanonicalFile());
    }
}
