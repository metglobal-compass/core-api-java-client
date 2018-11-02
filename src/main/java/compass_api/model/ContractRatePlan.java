package compass_api.model;


public class ContractRatePlan {

    private Integer id;

    private String name;

    private String status;

    private boolean isManageableByCm;

    private AllotmentPlan allotmentPlan;

    private BoardType boardType;

    private String rateType;

    private String cancelOption;

    private Integer defaultReleaseRestriction;

    private Integer defaultMinStayRestriction;

    private String defaultCancelType;

    private Double defaultCancelAmount;

    private Integer defaultCancelDays;

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isManageableByCm() {
        return isManageableByCm;
    }

    public void setManageableByCm(boolean manageableByCm) {
        isManageableByCm = manageableByCm;
    }

    public AllotmentPlan getAllotmentPlan() {
        return allotmentPlan;
    }

    public void setAllotmentPlan(AllotmentPlan allotmentPlan) {
        this.allotmentPlan = allotmentPlan;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getCancelOption() {
        return cancelOption;
    }

    public void setCancelOption(String cancelOption) {
        this.cancelOption = cancelOption;
    }

    public Integer getDefaultReleaseRestriction() {
        return defaultReleaseRestriction;
    }

    public void setDefaultReleaseRestriction(Integer defaultReleaseRestriction) {
        this.defaultReleaseRestriction = defaultReleaseRestriction;
    }

    public Integer getDefaultMinStayRestriction() {
        return defaultMinStayRestriction;
    }

    public void setDefaultMinStayRestriction(Integer defaultMinStayRestriction) {
        this.defaultMinStayRestriction = defaultMinStayRestriction;
    }

    public String getDefaultCancelType() {
        return defaultCancelType;
    }

    public void setDefaultCancelType(String defaultCancelType) {
        this.defaultCancelType = defaultCancelType;
    }

    public Double getDefaultCancelAmount() {
        return defaultCancelAmount;
    }

    public void setDefaultCancelAmount(Double defaultCancelAmount) {
        this.defaultCancelAmount = defaultCancelAmount;
    }

    public Integer getDefaultCancelDays() {
        return defaultCancelDays;
    }

    public void setDefaultCancelDays(Integer defaultCancelDays) {
        this.defaultCancelDays = defaultCancelDays;
    }

    private ContractCurrency contractCurrency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public boolean getIsManageableByCm() {
        return isManageableByCm;
    }

    public ContractCurrency getContractCurrency() {
        return contractCurrency;
    }

    public void setContractCurrency(ContractCurrency contractCurrency) {
        this.contractCurrency = contractCurrency;
    }
}
