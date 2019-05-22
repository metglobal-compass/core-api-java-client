package compass_api.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRoomPrice {

    private Integer id;
    private Float cost;
    private String sale;
    private String commission;
    private String discount;
    private String addOn;
    private Float abtNet;
    private Float aatNet;
    private Object markup;
    private Object detail;
    private BookingRoomPriceCreatedAt createdAt;
    private Object updatedAt;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
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

    public Float getAatNet() {
        return aatNet;
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

    public BookingRoomPriceCreatedAt getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(BookingRoomPriceCreatedAt createdAt) {
        this.createdAt = createdAt;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
