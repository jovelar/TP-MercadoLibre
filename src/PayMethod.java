public abstract class PayMethod {
    private int idPayMethod;
    private int idUser;

    private String type; //para que necesitamos este atributo "tipo"?
    private float amount;//cuanta plata paga el cliente o cuanto saldo tiene?
    private long dni;

    //region constructors

    public PayMethod() {
    }

    public PayMethod(int idPayMethod, String type, float amount, long dni) {
        this.idPayMethod = idPayMethod;
        this.type = type;
        this.amount = amount;
        this.dni = dni;
    }

    //endregion

    //region getters and setters

    public int getIdPayMethod() {
        return idPayMethod;
    }

    public void setIdPayMethod(int idPayMethod) {
        this.idPayMethod = idPayMethod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    //endregion
}
