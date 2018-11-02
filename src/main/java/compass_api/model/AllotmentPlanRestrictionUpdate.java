package compass_api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllotmentPlanRestrictionUpdate {

    private Integer contractRoomId;
    private String fromDate;
    private String toDate;
    private Integer limitation;
    private String type;

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

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
