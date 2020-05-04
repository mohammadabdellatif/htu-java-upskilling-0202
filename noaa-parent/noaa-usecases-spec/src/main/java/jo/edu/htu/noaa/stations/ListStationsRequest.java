package jo.edu.htu.noaa.stations;

public class ListStationsRequest {

    private String usaf;
    private String wban;
    private Double latitude;
    private Double longitude;

    public ListStationsRequest(String usaf, String wban, Double latitude, Double longitude) {
        this.usaf = usaf;
        this.wban = wban;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUsaf() {
        return usaf;
    }

    public String getWban() {
        return wban;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
