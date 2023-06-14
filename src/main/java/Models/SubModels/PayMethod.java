package Models.SubModels;

public abstract class PayMethod {

     //region ATTRIBUTES
    private int idPayMethod;
    private int idUser;

    private String type; //para que necesitamos este atributo "tipo"?
    private float amount;//cuanta plata paga el cliente o cuanto saldo tiene?
    private long dni;
    //endregion



    //region CONSTRUCTORS
    //endregion


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

    //region GETTERS AND SETTERS
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
