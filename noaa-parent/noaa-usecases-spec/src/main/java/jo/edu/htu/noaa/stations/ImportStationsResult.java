package jo.edu.htu.noaa.stations;

public class ImportStationsResult {

    private int total;
    private int updated;
    private int newRecords;

    public ImportStationsResult(int total, int updated, int newRecords) {
        this.total = total;
        this.updated = updated;
        this.newRecords = newRecords;
    }

    public int getTotal() {
        return total;
    }

    public int getUpdated() {
        return updated;
    }

    public int getNewRecords() {
        return newRecords;
    }
}
