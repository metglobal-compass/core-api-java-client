package compass_api.model.Booking.PaymentInfo;

public class CreditCard {

    private String id;
    private String status;
    private String reference;
    private String number;
    private Integer securityCode;
    private String type;
    private String expireDate;
    private String processId;
    private String provider;
    private Integer balance;
    private Integer maxAuthorisationAmount;
    private String currency;
    private String activationDate;
    private String hotelId;
    private String webSite;
    private String notes;
    private String clientName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getNumber() {
        return number;
    }

    public String getClientName() {
        return clientName;
    }
}
