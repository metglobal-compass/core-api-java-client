package compass_api.model;

public class AllotmentPlanRoom {

    private Integer allotment;
    private String status;
    private Date date;
    private ContractRoom contractRoom;

    public Integer getAllotment() {
        return allotment;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    //Get date day for
    public String getDateInString() {
        return getDate().getDate();
    }

    public ContractRoom getContractRoom() {
        return contractRoom;
    }

}
