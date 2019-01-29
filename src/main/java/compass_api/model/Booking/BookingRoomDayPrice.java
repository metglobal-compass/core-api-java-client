package compass_api.model.Booking;

public class BookingRoomDayPrice {

    private Integer id;
    private String cost;
    private String sale;
    private String commission;
    private String discount;
    private String addOn;
    private Float abtNet;
    private Float aatNet;
    private Object markup;
    private Object detail;
    private BookingRoomDayPriceCreatedAt createdAt;
    private Object updatedAt;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    public Float getAbtNet() {
        return abtNet;
    }

    public void setAbtNet(Float abtNet) {
        this.abtNet = abtNet;
    }

    public Float getAatNet() {
        return aatNet;
    }

    public void setAatNet(Float aatNet) {
        this.aatNet = aatNet;
    }

    public Object getMarkup() {
        return markup;
    }

    public void setMarkup(Object markup) {
        this.markup = markup;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public BookingRoomDayPriceCreatedAt getCreatedAt() {
        return createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
