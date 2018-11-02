package compass_api.model.Booking;

public class ContractRoom {

    private Integer id;
    private String code;
    private String name;
    private Object priority;
    private Object prefix;
    private Object suffix;
    private Integer adultPax;
    private Integer adultMinPax;
    private Integer adultMaxPax;
    private Integer childMaxPax;
    private Integer totalPax;
    private Integer childMaxAge;
    private Integer babyMaxAge;
    private Integer childMinAge;
    private String status;
    private String thresholdRate;
    private Object updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Object getPrefix() {
        return prefix;
    }

    public void setPrefix(Object prefix) {
        this.prefix = prefix;
    }

    public Object getSuffix() {
        return suffix;
    }

    public void setSuffix(Object suffix) {
        this.suffix = suffix;
    }

    public Integer getAdultPax() {
        return adultPax;
    }

    public void setAdultPax(Integer adultPax) {
        this.adultPax = adultPax;
    }

    public Integer getAdultMinPax() {
        return adultMinPax;
    }

    public void setAdultMinPax(Integer adultMinPax) {
        this.adultMinPax = adultMinPax;
    }

    public Integer getAdultMaxPax() {
        return adultMaxPax;
    }

    public void setAdultMaxPax(Integer adultMaxPax) {
        this.adultMaxPax = adultMaxPax;
    }

    public Integer getChildMaxPax() {
        return childMaxPax;
    }

    public void setChildMaxPax(Integer childMaxPax) {
        this.childMaxPax = childMaxPax;
    }

    public Integer getTotalPax() {
        return totalPax;
    }

    public void setTotalPax(Integer totalPax) {
        this.totalPax = totalPax;
    }

    public Integer getChildMaxAge() {
        return childMaxAge;
    }

    public void setChildMaxAge(Integer childMaxAge) {
        this.childMaxAge = childMaxAge;
    }

    public Integer getBabyMaxAge() {
        return babyMaxAge;
    }

    public void setBabyMaxAge(Integer babyMaxAge) {
        this.babyMaxAge = babyMaxAge;
    }

    public Integer getChildMinAge() {
        return childMinAge;
    }

    public void setChildMinAge(Integer childMinAge) {
        this.childMinAge = childMinAge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThresholdRate() {
        return thresholdRate;
    }

    public void setThresholdRate(String thresholdRate) {
        this.thresholdRate = thresholdRate;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}