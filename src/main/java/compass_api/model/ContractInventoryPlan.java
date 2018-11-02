package compass_api.model;

public class ContractInventoryPlan {

    private Integer id;

    private Integer defaultAllotmentPlanId;

    private Integer defaultNetRatePlanId;

    private Integer defaultSaleRatePlanId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDefaultAllotmentPlanId() {
        return defaultAllotmentPlanId;
    }

    public void setDefaultAllotmentPlanId(Integer defaultAllotmentPlanId) {
        this.defaultAllotmentPlanId = defaultAllotmentPlanId;
    }

    public Integer getDefaultNetRatePlanId() {
        return defaultNetRatePlanId;
    }

    public void setDefaultNetRatePlanId(Integer defaultNetRatePlanId) {
        this.defaultNetRatePlanId = defaultNetRatePlanId;
    }

    public Integer getDefaultSaleRatePlanId() {
        return defaultSaleRatePlanId;
    }

    public void setDefaultSaleRatePlanId(Integer defaultSaleRatePlanId) {
        this.defaultSaleRatePlanId = defaultSaleRatePlanId;
    }
}
