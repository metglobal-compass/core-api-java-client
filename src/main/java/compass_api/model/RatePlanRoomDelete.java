package compass_api.model;

public class RatePlanRoomDelete {
    private String fromDate;
    private String toDate;
    private Integer minStay;
    private Integer paxNumber;

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

    public Integer getMinStay() {
        return minStay;
    }

    public void setMinStay(Integer minStay) {
        this.minStay = minStay;
    }

    public Integer getPaxNumber() {
        return paxNumber;
    }

    public void setPaxNumber(Integer paxNumber) {
        this.paxNumber = paxNumber;
    }
}
