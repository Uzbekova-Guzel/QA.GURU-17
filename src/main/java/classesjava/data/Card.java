package classesjava.data;

public abstract class Card {

    public String cardHolder;
    public int balance;
    public String cardNumber;
    public PaymentSystem paymentSystem;

    public Card(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public abstract void payInCountry(Country country, int amount);

    protected abstract boolean isCountryValidForTheseCard(Country country);
}
