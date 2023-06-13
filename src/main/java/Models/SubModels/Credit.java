package Models.SubModels;

public class Credit extends PayMethod {
    private float amount;//no iria para mi porq ya tenemos un atributo amount en la clase padre

   //region constructors
    public Credit(){

    }

    public Credit(int idPayMethod, String type, float amount, long dni, float amount1) {
        super(idPayMethod, type, amount, dni);
        this.amount = amount1;
    }

    //endregion

    public void addMoney(){

    }
    public void removeMoney(){

    }
}
