package Models.SubModels;


public final class Card extends PayMethod {
    private long creditCardNumber;
    private String expDate;
    private int cvcCode;
    //region CONSTRUCTORES

    public Card(){

    }

    public Card(int idPayMethod, int idUser, double availableMoney, long creditCardNumber, String expDate, int cvcCode) {
        super(idPayMethod, idUser, availableMoney);
        this.creditCardNumber = creditCardNumber;
        this.expDate = expDate;
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

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(int cvcCode) {
        this.cvcCode = cvcCode;
    }

    //endregion
}
