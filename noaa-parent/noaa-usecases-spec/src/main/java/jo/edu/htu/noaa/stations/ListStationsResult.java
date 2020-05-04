package jo.edu.htu.noaa.stations;

import jo.edu.htu.noaa.Station;

import java.util.List;

public class ListStationsResult {

    private List<Station> stations;

    public ListStationsResult(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }
}
