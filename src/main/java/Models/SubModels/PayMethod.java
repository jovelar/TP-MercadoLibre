package Models.SubModels;

public abstract class PayMethod {

     //region ATTRIBUTES
    private int idPayMethod;
    private int idBuyer;

    private double availableMoney;//saldo disponible del cliente
    //endregion



    //region CONSTRUCTORS


    public PayMethod() {
    }

    public PayMethod(int idPayMethod, int idBuyer, double availableMoney) {
        this.idPayMethod = idPayMethod;
        this.idBuyer = idBuyer;
        this.availableMoney = availableMoney;
    }

    //endregion

    //region GETTERS AND SETTERS


    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }

    public int getIdPayMethod() {
        return idPayMethod;
    }

    public void setIdPayMethod(int idPayMethod) {
        this.idPayMethod = idPayMethod;
    }



    //endregion
}
