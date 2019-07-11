package compass_api.model.Booking;

public class Region {
    private String hotelContractEmail;
    private Region parent;

    public String getHotelContactEmail() {
        return hotelContractEmail;
    }

    public void setHotelContactEmail(String hotelContactEmail) {
        this.hotelContractEmail = hotelContactEmail;
    }

    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }
}
