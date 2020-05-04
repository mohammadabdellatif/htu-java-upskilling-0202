package jo.edu.htu.noaa;

import java.time.LocalDate;

public class GlobalSummaryOfDay {

    private String wban;
    private String usaf;
    private LocalDate date;
    private double temperature;
    private double maxTemp;
    private double minTemp;
    private double windSpeed;

    public String getWban() {
        return wban;
    }

    public void setWban(String wban) {
        this.wban = wban;
    }

    public String getUsaf() {
        return usaf;
    }

    public void setUsaf(String usaf) {
        this.usaf = usaf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
