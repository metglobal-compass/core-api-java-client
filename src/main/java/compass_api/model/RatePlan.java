package compass_api.model;

import java.util.List;

public class RatePlan {

    private AllotmentPlan allotmentPlan;
    private Integer id;
    private ContractCurrency contractCurrency;
    private BoardType boardType;
    private String name;
    private RatePlan parent;
    private String rateType;
    private Integer defaultMinStayRestriction;
    private Integer defaultMaxStayRestriction;
    private List<RatePlanSaleChannel> ratePlanSaleChannels;

    public AllotmentPlan getAllotmentPlan() {
        return allotmentPlan;
    }

    public void setAllotmentPlan(AllotmentPlan allotMentPlan) {
        this.allotmentPlan = allotMentPlan;
    }

    public Integer getId() {
        return id;
    }

    public ContractCurrency getContractCurrency() {
        return contractCurrency;
    }

    public String getName() {
        return name;
    }

    public RatePlan getParent() {
        return parent;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContractCurrency(ContractCurrency contractCurrency) {
        this.contractCurrency = contractCurrency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(RatePlan parent) {
        this.parent = parent;
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

	public List<RatePlanSaleChannel> getRatePlanSaleChannels() {
		return ratePlanSaleChannels;
	}

	public void setRatePlanSaleChannels(List<RatePlanSaleChannel> ratePlanSaleChannels) {
		this.ratePlanSaleChannels = ratePlanSaleChannels;
	}
}