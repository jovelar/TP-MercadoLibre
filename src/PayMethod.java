public class PayMethod {
    private int idPayMethod;
    private String tyype;
    private float amount;
    private long dni;

    public PayMethod() {
    }

    public PayMethod(int idPayMethod, String tyype, float amount, long dni) {
        this.idPayMethod = idPayMethod;
        this.tyype = tyype;
        this.amount = amount;
        this.dni = dni;
    }

    public int getIdPayMethod() {
        return idPayMethod;
    }

    public void setIdPayMethod(int idPayMethod) {
        this.idPayMethod = idPayMethod;
    }

    public String getTyype() {
        return tyype;
    }

    public void setTyype(String tyype) {
        this.tyype = tyype;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
}
