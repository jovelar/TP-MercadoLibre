package Models.SubModels;

import Models.Product;

import java.util.ArrayList;

public class Order {
    private int idOrder;
    private int idUser; //o seria mejor idBuyer?
    private ArrayList<Product>solicitedProducts;
    private PayMethod payMethod;
    private String deliveryAddress;

    public Order(){

    }

    public Order(ArrayList<Product> solicitedProducts, PayMethod payMethod, String deliveryAddress) {
        this.solicitedProducts = solicitedProducts;
        this.payMethod = payMethod;
        this.deliveryAddress = deliveryAddress;
    }

    //region constructors
    public ArrayList<Product> getSolicitedProducts() {
        return solicitedProducts;
    }

    public void setSolicitedProducts(ArrayList<Product> solicitedProducts) {
        this.solicitedProducts = solicitedProducts;
    }

    //endregion

    //region getters and setters


    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    //endregion
}
