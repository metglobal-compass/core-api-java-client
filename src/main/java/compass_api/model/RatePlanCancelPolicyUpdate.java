package compass_api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatePlanCancelPolicyUpdate {
    private List<Integer> contractRoomIds;
    private String fromDate,toDate;
    private Integer days;
    private Double cancelAmount;
    private String cancelType;
    private String status;

    public List<Integer> getContractRoomIds() {
        return contractRoomIds;
    }

    public void setContractRoomIds(List<Integer> contractRoomIds) {
        this.contractRoomIds = contractRoomIds;
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getCancelAmount() {
        return cancelAmount;
    }

    public void setCancelAmount(Double cancelAmount) {
        this.cancelAmount = cancelAmount;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
