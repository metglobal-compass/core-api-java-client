package compass_api.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RatePlanRoomRate {
    private Integer id;
    private Date date;
    private HashMap<Integer, RateContent> rate;
    private String remark;
    private RatePlanRoomRateContractRoom contractRoom;

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getDateInString() {
        return getDate().getDate();
    }

    public HashMap<Integer, RateContent> getRate() {
        return rate;
    }

    public String getRemark() {
        return remark;
    }

    public RatePlanRoomRateContractRoom getContractRoom() {
        return contractRoom;
    }

    public Integer getContractRoomInId() {
        return getContractRoom().getId();
    }
}
