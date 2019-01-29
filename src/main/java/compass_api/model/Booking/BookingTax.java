package compass_api.model.Booking;

public class BookingTax {
    private Integer id;
    private Float amount;
    private String amountType;
    private String applyOption;
    private String taxRateOption;
    private String taxType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getApplyOption() {
        return applyOption;
    }

    public void setApplyOption(String applyOption) {
        this.applyOption = applyOption;
    }

    public String getTaxRateOption() {
        return taxRateOption;
    }

    public void setTaxRateOption(String taxRateOption) {
        this.taxRateOption = taxRateOption;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
}
