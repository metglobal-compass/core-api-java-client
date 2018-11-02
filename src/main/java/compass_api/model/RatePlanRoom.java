package compass_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatePlanRoom {
    private Integer id;
    private Date contractDate;
    private ContractCurrency contractCurrency;
    private Integer minStay;
    private ContractRoom contractRoom;
    private String paxOption;
    private Double rate; //amount
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinStay() {
        return minStay;
    }

    public void setMinStay(Integer minStay) {
        this.minStay = minStay;
    }

    @JsonProperty(value = "date")
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public ContractCurrency getContractCurrency() {
        return contractCurrency;
    }

    public void setContractCurrency(ContractCurrency contractCurrency) {
        this.contractCurrency = contractCurrency;
    }

    public String getPaxOption() {
        return paxOption;
    }

    public void setPaxOption(String paxOption) {
        this.paxOption = paxOption;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public ContractRoom getContractRoom() {
        return contractRoom;
    }

    public void setContractRoom(ContractRoom contractRoom) {
        this.contractRoom = contractRoom;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
