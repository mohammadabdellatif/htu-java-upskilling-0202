package jo.edu.htu.io;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileStoreAttributeView;

public class FilesUtilTest2 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".", "io-samples", "info.txt");
        System.out.println(Files.exists(path));
        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        FileSystem fileSystem = FileSystems.getDefault();
        for (Path rootDirectory : fileSystem.getRootDirectories()) {
            System.out.println(rootDirectory);
        }
        Iterable<FileStore> fileStores = fileSystem.getFileStores();
        for (FileStore fileStore : fileStores) {
            FileStoreAttributeView fileStoreAttributeView = fileStore.getFileStoreAttributeView(FileStoreAttributeView.class);
            System.out.println(fileStore.name() + " " + fileStore.type());
        }

    }
}
