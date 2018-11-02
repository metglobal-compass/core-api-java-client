package compass_api.model;

import java.util.List;

public class Contract {

    private Integer id;
    private String name;
    private String type;
    private String code;
    private Integer childMaxPax;
    private String ratePlanType;
    private List<ContractRoom> contractRooms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getChildMaxPax() {
        return childMaxPax;
    }

    public void setChildMaxPax(Integer childMaxPax) {
        this.childMaxPax = childMaxPax;
    }

    public String getRatePlanType() {
        return ratePlanType;
    }

    public void setRatePlanType(String ratePlanType) {
        this.ratePlanType = ratePlanType;
    }

    public List<ContractRoom> getContractRooms() {
        return contractRooms;
    }

    public void setContractRooms(List<ContractRoom> contractRooms) {
        this.contractRooms = contractRooms;
    }
}
