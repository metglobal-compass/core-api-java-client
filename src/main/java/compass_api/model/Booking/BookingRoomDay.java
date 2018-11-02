package compass_api.model.Booking;

public class BookingRoomDay {

    private Integer id;
    private Object updatedAt;
    private BookingRoomDayPrice price;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BookingRoomDayPrice getPrice() {
        return price;
    }

    public void setPrice(BookingRoomDayPrice price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
