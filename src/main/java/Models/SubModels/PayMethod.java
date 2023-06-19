package Models.SubModels;

public abstract class PayMethod {

     //region ATTRIBUTES
    private int idPayMethod;
    private int idUser;

    private double availableMoney;//saldo disponible del cliente
    //endregion



    //region CONSTRUCTORS


    public PayMethod() {
    }

    public PayMethod(int idPayMethod, int idUser, double availableMoney) {
        this.idPayMethod = idPayMethod;
        this.idUser = idUser;
        this.availableMoney = availableMoney;
    }

    //endregion

    //region GETTERS AND SETTERS


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
