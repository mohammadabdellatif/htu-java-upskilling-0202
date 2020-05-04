package jo.edu.htu.noaa.gsod;

import jo.edu.htu.noaa.GlobalSummaryOfDay;

import java.util.List;

public class ListGSODResult {

    private List<GlobalSummaryOfDay> gsods;

    public ListGSODResult(List<GlobalSummaryOfDay> gsods) {
        this.gsods = gsods;
    }

    public List<GlobalSummaryOfDay> getGsods() {
        return gsods;
    }
}
