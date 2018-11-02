package compass_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatePlanCancelPolicy {
    private Integer days;
    private String cancelType;
    private Double cancelAmount;
    private Date contractDate;
    private ContractRoom contractRoom;

    public Integer getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public Double getCancelAmount() {
        return cancelAmount;
    }

    public void setCancelAmount(double cancelAmount) {
        this.cancelAmount = cancelAmount;
    }

    @JsonProperty(value = "date")
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public ContractRoom getContractRoom() {
        return contractRoom;
    }

    public void setContractRoom(ContractRoom contractRoom) {
        this.contractRoom = contractRoom;
    }
}
