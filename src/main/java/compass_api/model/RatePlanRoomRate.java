package compass_api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RatePlanRoomRate {

    private Date date;
    private Rate rate;
    private RatePlanRoomRateContractRoom contractRoom;

    public Date getDate() {
        return date;
    }

    public String getDateInString() {
        return getDate().getDate();
    }

    public Rate getRate() {
        return rate;
    }

    public RatePlanRoomRateContractRoom getContractRoom() {
        return contractRoom;
    }

    public Integer getContractRoomInId() {
        return getContractRoom().getId();
    }
}
