package classesjava.data;

public class MipCard extends Card {

    public MipCard() {
        super(PaymentSystem.MIR);
    }

    @Override
    public void payInCountry(Country country, int amount) {

    }

    protected boolean isCountryValidForTheseCard(Country country) {
        if (country == Country.RU)
            return true;
        else
            return false;
    }
}
