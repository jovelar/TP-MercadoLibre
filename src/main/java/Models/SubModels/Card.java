package Models.SubModels;

public final class Card extends PayMethod {
    private float amount; //no iria para mi porq ya tenemos un atributo amount en la clase padre
    private long creditCardNumber;
    private String expDate;
    private int cvcCode;

    public Card(){

    }

    public Card(int idPayMethod, String tyype, float amount, long dni, double amount1, long creditCardNumber, String expDate, int cvcCode) {
        super(idPayMethod, tyype, amount, dni);
        this.amount = (float) amount1;
        this.creditCardNumber = creditCardNumber;
        this.expDate = expDate;
        this.cvcCode = cvcCode;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = (float) amount;
    }

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
}
