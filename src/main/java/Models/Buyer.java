package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Models.SubModels.Order;


import Enums.Province;
import Models.SubModels.Order;
import Models.SubModels.PayMethod;

import Tools.Console;

public final class Buyer extends Client {

    //region ATTRIBUTES
    private ArrayList<Order>orders;
    private ArrayList<Product>cart;
    private List<Product>favorites;
    private List<PayMethod>paymethod;
    //endregion

    //region CONTRUCTORS
    public Buyer(){}

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni, String birthDate, long phoneNumber, boolean active, Province province, String city, String address, int postalCode) {
        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active, province, city, address, postalCode);
    }

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni,
                 String birthDate, long phoneNumber, boolean active, Province province, String city, String address,
                 int postalCode, ArrayList<Order> orders, ArrayList<Product> cart, List<Product> favorites,
                 List<PayMethod> paymethod) {

        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active, province,
                city, address, postalCode);

        this.orders = orders;
        this.cart = cart;
        this.favorites = favorites;
        this.paymethod = paymethod;
    }
    //endregion

    //region GETTERS AND SETTERS
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public List<Product> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Product> favorites) {
        this.favorites = favorites;
    }

    public List<PayMethod> getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(List<PayMethod> paymethod) {
        this.paymethod = paymethod;
    }
    //endregion

    //region METHODS
    public void pay(){

    }
    public void cancelBuy(){

    }
    public void buyCart(){

    }
    public Order instantBuy(){ //buy a product instantly
        Order newOrder=new Order();


        return newOrder;
    }
    public void addFavorite(){

    }
    public void showFavoriteList(){

    }
    public void deleteFavorite(){

    }
    public boolean validateAvailableProducts(){
        boolean state = true;



        return state;
    }


    //endregion
}

