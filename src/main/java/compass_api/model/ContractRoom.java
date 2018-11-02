package compass_api.model;

public class ContractRoom {

    private Integer id;

    private String code;

    private String name;

    private String status;

    private Integer adultPax;

    private Integer adultMinPax;

    private Integer adultMaxPax;

    private Integer childMaxPax;

    private Integer totalPax;

    private Integer babyMaxAge;

    private Integer childMaxAge;

    private RoomCategory roomCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public Integer getAdultPax() {
        return adultPax;
    }

    public Integer getAdultMinPax() {
        return adultMinPax;
    }

    public Integer getAdultMaxPax() {
        return adultMaxPax;
    }

    public Integer getChildMaxPax() {
        return childMaxPax;
    }

    public Integer getTotalPax() {
        return totalPax;
    }

    public void setTotalPax(Integer totalPax) {
        this.totalPax = totalPax;
    }

    public Integer getBabyMaxAge() {
        return babyMaxAge;
    }

    public Integer getChildMaxAge() {
        return childMaxAge;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }
}
