package compass_api.model.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBooking {

    private Integer page;
    private Integer perPage;
    private Integer total;
    private List<Booking> bookings = null;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}