import java.util.ArrayList;

public class Order {
    private ArrayList<Product>solicitedProducts;
    private PayMethod payMethod;
    private String deliveryAdress;

    public Order(){

    }

    public Order(ArrayList<Product> solicitedProducts, PayMethod payMethod, String deliveryAdress) {
        this.solicitedProducts = solicitedProducts;
        this.payMethod = payMethod;
        this.deliveryAdress = deliveryAdress;
    }

    public ArrayList<Product> getSolicitedProducts() {
        return solicitedProducts;
    }

    public void setSolicitedProducts(ArrayList<Product> solicitedProducts) {
        this.solicitedProducts = solicitedProducts;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }
}
