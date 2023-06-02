public class Card extends PayMethod{
    private float amount;
    private long creditCardNumber;
    private String expDate;
    private int cVCCode;

    public Card(){

    }

    public Card(int idPayMethod, String tyype, float amount, long dni, double amount1, long creditCardNumber, String expDate, int cVCCode) {
        super(idPayMethod, tyype, amount, dni);
        this.amount = (float) amount1;
        this.creditCardNumber = creditCardNumber;
        this.expDate = expDate;
        this.cVCCode = cVCCode;
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

    public int getcVCCode() {
        return cVCCode;
    }

    public void setcVCCode(int cVCCode) {
        this.cVCCode = cVCCode;
    }
}
