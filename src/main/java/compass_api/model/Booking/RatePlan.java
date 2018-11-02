package compass_api.model.Booking;

public class RatePlan {

    private Integer id;
    private String name;
    private String rateType;
    private String pricingType;
    private String cancelOption;
    private Boolean isManageableByCm;
    private Integer defaultReleaseRestriction;
    private Integer defaultMinStayRestriction;
    private Integer defaultMaxStayRestriction;
    private String defaultCancelType;
    private String defaultCancelAmount;
    private Integer defaultCancelDays;
    private String status;
    private BookingCreatedAt createdAt;
    private BookingUpdatedAt updatedAt;

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

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public String getCancelOption() {
        return cancelOption;
    }

    public void setCancelOption(String cancelOption) {
        this.cancelOption = cancelOption;
    }

    public Boolean getIsManageableByCm() {
        return isManageableByCm;
    }

    public void setIsManageableByCm(Boolean isManageableByCm) {
        this.isManageableByCm = isManageableByCm;
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

    public Integer getDefaultMaxStayRestriction() {
        return defaultMaxStayRestriction;
    }

    public void setDefaultMaxStayRestriction(Integer defaultMaxStayRestriction) {
        this.defaultMaxStayRestriction = defaultMaxStayRestriction;
    }

    public String getDefaultCancelType() {
        return defaultCancelType;
    }

    public void setDefaultCancelType(String defaultCancelType) {
        this.defaultCancelType = defaultCancelType;
    }

    public String getDefaultCancelAmount() {
        return defaultCancelAmount;
    }

    public void setDefaultCancelAmount(String defaultCancelAmount) {
        this.defaultCancelAmount = defaultCancelAmount;
    }

    public Integer getDefaultCancelDays() {
        return defaultCancelDays;
    }

    public void setDefaultCancelDays(Integer defaultCancelDays) {
        this.defaultCancelDays = defaultCancelDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingCreatedAt getCreatedAt() { return createdAt; }

    public void setCreatedAt(BookingCreatedAt createdAt) { this.createdAt = createdAt; }

    public BookingUpdatedAt getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(BookingUpdatedAt updatedAt) {
        this.updatedAt = updatedAt;
    }
}