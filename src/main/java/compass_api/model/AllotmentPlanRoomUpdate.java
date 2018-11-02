package compass_api.model;

public class AllotmentPlanRoomUpdate {

    private Integer contractRoomId;
    private String fromDate;
    private String toDate;
    private Integer allotment;
    private String status;

    public Integer getContractRoomId() {
        return contractRoomId;
    }

    public void setContractRoomId(Integer contractRoomId) {
        this.contractRoomId = contractRoomId;
    }

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

    public Integer getAllotment() {
        return allotment;
    }

    public void setAllotment(Integer allotment) {
        this.allotment = allotment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
