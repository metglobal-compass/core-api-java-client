package compass_api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateUpdate {

    private Integer minStay;
    private String paxOption;
    private Integer paxNumber;
    private Float rate;
    private Integer minAge;
    private Integer maxAge;
    private Integer contractRoomId;
    private String fromDate;
    private String toDate;
    private String remark;
    private List<String> validDays;

    public Integer getMinStay() {
        return minStay;
    }

    public String getPaxOption() {
        return paxOption;
    }

    public Integer getPaxNumber() {
        return paxNumber;
    }

    public Float getRate() {
        return rate;
    }

    public void setMinStay(Integer minStay) {
        this.minStay = minStay;
    }

    public void setPaxOption(String paxOption) {
        this.paxOption = paxOption;
    }

    public void setPaxNumber(Integer paxNumber) {
        this.paxNumber = paxNumber;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getValidDays() {
        return validDays;
    }

    public void setValidDays(List<String> validDays) {
        this.validDays = validDays;
    }
}
