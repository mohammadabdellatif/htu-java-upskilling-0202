package jo.edu.htu.noaa.gsod;

import java.time.LocalDate;

public class ListGSODRequest {

    private String usaf;
    private String wban;
    private LocalDate readingDateFrom;
    private LocalDate getReadingDateTo;

    public ListGSODRequest(String usaf, String wban, LocalDate readingDateFrom, LocalDate getReadingDateTo) {
        this.usaf = usaf;
        this.wban = wban;
        this.readingDateFrom = readingDateFrom;
        this.getReadingDateTo = getReadingDateTo;
    }

    public String getUsaf() {
        return usaf;
    }

    public String getWban() {
        return wban;
    }

    public LocalDate getGetReadingDateTo() {
        return getReadingDateTo;
    }

    public LocalDate getReadingDateFrom() {
        return readingDateFrom;
    }
}
