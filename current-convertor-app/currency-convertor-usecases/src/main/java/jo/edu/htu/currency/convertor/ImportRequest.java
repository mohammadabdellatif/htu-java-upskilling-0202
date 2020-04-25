package jo.edu.htu.currency.convertor;

import java.nio.file.Path;

public class ImportRequest {

    private Path filePath;

    public ImportRequest(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFilePath() {
        return filePath;
    }
}
