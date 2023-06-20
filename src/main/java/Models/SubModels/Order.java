package Models.SubModels;

import Models.Product;

import java.util.ArrayList;

public final class Order {

    private int idOrder;
    private int idBuyer;
    private ArrayList<Product>solicitedProducts;
    private PayMethod payMethod;
    private String deliveryAddress;

    private OrderStatus state;
    private String deliveryDate;

    public enum OrderStatus {
        IN_PREPARATION, ON_THE_WAY, CANCELLED, DELIVERED

    }


    //region constructors

    public Order(){}


    public Order(int idOrder, int idBuyer, ArrayList<Product> solicitedProducts, PayMethod payMethod, String deliveryAddress, String deliveryDate) {
        this.idOrder = idOrder;
        this.idBuyer = idBuyer;
        this.solicitedProducts = solicitedProducts;
        this.payMethod = payMethod;
        this.deliveryAddress = deliveryAddress;
        this.state = OrderStatus.IN_PREPARATION;
        this.deliveryDate = deliveryDate;
    }

    //endregion

    //region GETTERS AND SETTERS

    public ArrayList<Product> getSolicitedProducts() {
        return solicitedProducts;
    }

    public void setSolicitedProducts(ArrayList<Product> solicitedProducts) {
        this.solicitedProducts = solicitedProducts;
    }


    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
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

    public OrderStatus getState() {
        return state;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    //endregion
}
