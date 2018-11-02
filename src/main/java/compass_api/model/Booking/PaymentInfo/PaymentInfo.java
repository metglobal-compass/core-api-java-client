package compass_api.model.Booking.PaymentInfo;

public class PaymentInfo {

    private CreditCard creditCard;

    private Company company;

    private String clientName;

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getClientName() {
        return clientName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
