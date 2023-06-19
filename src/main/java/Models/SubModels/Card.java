package Models.SubModels;


public final class Card extends PayMethod {
    private long creditCardNumber;
    private String expiryDate; //TODO: cambiar a LocalDate luego de solucionar lo de des/serializacion
    private int cvcCode;
    //region CONSTRUCTORES

    public Card(){

    }

    public Card(int idPayMethod, int idBuyer, double availableMoney, long creditCardNumber, String expiryDate, int cvcCode) {
        super(idPayMethod, idBuyer, availableMoney);
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.cvcCode = cvcCode;
    }

    //endregion

    //region GETTERS AND SETTERS

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(int cvcCode) {
        this.cvcCode = cvcCode;
    }

    //endregion
}
