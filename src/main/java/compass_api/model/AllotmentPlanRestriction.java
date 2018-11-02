package compass_api.model;

public class AllotmentPlanRestriction {

    private Integer id;

    private Integer limitation;

    private String type;

    private Date date;

    private ContractRoom contractRoom;

    private RoomCategory roomCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public String getDateInString() {
        return getDate().getDate();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ContractRoom getContractRoom() {
        return contractRoom;
    }

    public void setContractRoom(ContractRoom contractRoom) {
        this.contractRoom = contractRoom;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }
}
