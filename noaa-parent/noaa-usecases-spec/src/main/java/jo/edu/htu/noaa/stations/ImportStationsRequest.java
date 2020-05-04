package jo.edu.htu.noaa.stations;

import java.nio.file.Path;

public class ImportStationsRequest {

    private Path stationsPath;

    public ImportStationsRequest(Path stationsPath) {
        this.stationsPath = stationsPath;
    }

    public Path getStationsPath() {
        return stationsPath;
    }
}
