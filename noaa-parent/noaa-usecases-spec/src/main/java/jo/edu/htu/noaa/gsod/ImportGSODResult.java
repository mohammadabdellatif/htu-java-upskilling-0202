package jo.edu.htu.noaa.gsod;

public class ImportGSODResult {

    private int total;
    private int newRecords;

    public ImportGSODResult(int total, int newRecords) {
        this.total = total;
        this.newRecords = newRecords;
    }

    public int getTotal() {
        return total;
    }

    public int getNewRecords() {
        return newRecords;
    }
}
