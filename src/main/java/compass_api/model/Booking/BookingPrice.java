package compass_api.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingPrice {

    private Integer id;
    private Float cost;
    private String sale;
    private Float commission;

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

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Float getCommission() {
        return commission;
    }
}
