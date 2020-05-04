package jo.edu.htu.noaa.gsod;

import java.nio.file.Path;

public class ImportGSODRequest {

    private Path stationsPath;

    public ImportGSODRequest(Path stationsPath) {
        this.stationsPath = stationsPath;
    }

    public Path getStationsPath() {
        return stationsPath;
    }
}
