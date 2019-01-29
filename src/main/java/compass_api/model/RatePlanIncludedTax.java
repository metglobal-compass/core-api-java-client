package compass_api.model;

public class RatePlanIncludedTax {
    private String status;
    private Double amount;
    private String amountType;
    private String taxRateOption;
    private String applyOption;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getTaxRateOption() {
        return taxRateOption;
    }

    public void setTaxRateOption(String taxRateOption) {
        this.taxRateOption = taxRateOption;
    }

    public String getApplyOption() {
        return applyOption;
    }

    public void setApplyOption(String applyOption) {
        this.applyOption = applyOption;
    }
}
