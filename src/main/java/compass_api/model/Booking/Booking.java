package compass_api.model.Booking;
/*
* Modelde gönderilen verilen json olarak algılanması için set fonksiyonları uygulama içerisinde kullanılmasa bile
* get metodlarıyla model içerisinde kullanılmak zorunda.
* */

import java.util.List;

public class Booking {

    private Integer id;
    private String provisionId;
    private String hotelCode;
    private String referenceCode;
    private String saleChannelReferenceCode;
    private CheckIn checkIn;
    private CheckOut checkOut;
    private String currency;
    private String cancelOption;
    private String status;
    private BookingCancelPenalty bookingCancelPenalty;
    private BookingCreatedAt createdAt;
    private BookingUpdatedAt updatedAt;
    private BookingCancelledAt cancelledAt;
    private List<BookingRoom> bookingRooms = null;
    private BookingPrice price;
    private RatePlan ratePlan;
    private BoardType boardType;
    private Contract contract;
    private Client client;
    private Contact contact;
    private String remark;
    private List<BookingModification> bookingModifications;
    private Region region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvisionId() {
        return provisionId;
    }

    public void setProvisionId(String provisionId) {
        this.provisionId = provisionId;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getSaleChannelReferenceCode() {
        return saleChannelReferenceCode;
    }

    public void setSaleChannelReferenceCode(String saleChannelReferenceCode) {
        this.saleChannelReferenceCode = saleChannelReferenceCode;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCancelOption() {
        return cancelOption;
    }

    public void setCancelOption(String cancelOption) {
        this.cancelOption = cancelOption;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingCreatedAt getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(BookingCreatedAt createdAt) {
        this.createdAt = createdAt;
    }

    public List<BookingRoom> getBookingRooms() {
        return bookingRooms;
    }

    public void setBookingRooms(List<BookingRoom> bookingRooms) {
        this.bookingRooms = bookingRooms;
    }

    public BookingPrice getPrice() {
        return price;
    }

    public void setPrice(BookingPrice price) {
        this.price = price;
    }

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan ratePlan) {
        this.ratePlan = ratePlan;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BookingUpdatedAt getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(BookingUpdatedAt updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BookingCancelPenalty getBookingCancelPenalty() {
        return bookingCancelPenalty;
    }

    public void setBookingCancelPenalty(BookingCancelPenalty bookingCancelPenalty) {
        this.bookingCancelPenalty = bookingCancelPenalty;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public BookingCancelledAt getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(BookingCancelledAt cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<BookingModification> getBookingModifications() {
        return bookingModifications;
    }

    public void setBookingModifications(List<BookingModification> bookingModifications) {
        this.bookingModifications = bookingModifications;
    }
}