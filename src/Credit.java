public class Credit extends PayMethod{
    private float amount;
    public Credit(){

    }

    public Credit(int idPayMethod, String tyype, float amount, long dni, float amount1) {
        super(idPayMethod, tyype, amount, dni);
        this.amount = amount1;
    }
    public void addMoney(){

    }
    public void removeMoney(){

    }
}
