package compass_api.model.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRoom {

    private Integer id;
    private String referenceIdentifier;
    private Integer adultPax;
    private Integer childPax;
    private Integer babyPax;
    private String roomUse;
    private String code;
    private String category;
    private String type;
    private Object view;
    private String description;
    private String name;
    private Object remark;
    private Object updatedAt;
    private List<BookingRoomGuest> bookingRoomGuests = null;
    private ContractRoom contractRoom;
    private BookingRoomPrice price;
    private List<BookingRoomDay> bookingRoomDays = null;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private RatePlan ratePlan;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceIdentifier() {
        return referenceIdentifier;
    }

    public void setReferenceIdentifier(String referenceIdentifier) {
        this.referenceIdentifier = referenceIdentifier;
    }

    public Integer getAdultPax() {
        return adultPax;
    }

    public void setAdultPax(Integer adultPax) {
        this.adultPax = adultPax;
    }

    public Integer getChildPax() {
        return childPax;
    }

    public void setChildPax(Integer childPax) {
        this.childPax = childPax;
    }

    public Integer getBabyPax() {
        return babyPax;
    }

    public void setBabyPax(Integer babyPax) {
        this.babyPax = babyPax;
    }

    public String getRoomUse() {
        return roomUse;
    }

    public void setRoomUse(String roomUse) {
        this.roomUse = roomUse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BookingRoomGuest> getBookingRoomGuests() {
        return bookingRoomGuests;
    }

    public void setBookingRoomGuests(List<BookingRoomGuest> bookingRoomGuests) {
        this.bookingRoomGuests = bookingRoomGuests;
    }

    public ContractRoom getContractRoom() {
        return contractRoom;
    }

    public void setContractRoom(ContractRoom contractRoom) {
        this.contractRoom = contractRoom;
    }

    public BookingRoomPrice getPrice() {
        return price;
    }

    public void setPrice(BookingRoomPrice price) {
        this.price = price;
    }

    public List<BookingRoomDay> getBookingRoomDays() {
        return bookingRoomDays;
    }

    public void setBookingRoomDays(List<BookingRoomDay> bookingRoomDays) {
        this.bookingRoomDays = bookingRoomDays;
    }

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan ratePlan) {
        this.ratePlan = ratePlan;
    }
}