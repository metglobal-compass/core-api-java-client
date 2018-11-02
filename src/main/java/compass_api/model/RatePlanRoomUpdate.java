package compass_api.model;

import java.util.ArrayList;

public class RatePlanRoomUpdate {

    private String fromDate;
    private String toDate;
    private ArrayList<RateUpdate> rates = new ArrayList<>();

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public ArrayList<RateUpdate> getRates() {
        return rates;
    }

    public void addRates(RateUpdate rateUpdate) {
        this.rates.add(rateUpdate);
    }
}
