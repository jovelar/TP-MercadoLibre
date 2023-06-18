package Models;

import Enums.Province;
import Models.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Models.SubModels.Order;
import Models.SubModels.PayMethod;


public final class Buyer extends Client {

    //region ATTRIBUTES
    private ArrayList<Order>orders;
    private ArrayList<Product>cart;
    private List<Product>favorites;
    private List<PayMethod>paymethod;
    //endregion

    //region CONTRUCTORS
    public Buyer(){}

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni,
                 LocalDateTime birthDate, long phoneNumber, boolean active, Province province, String city, String address,
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
    public void instantBuy(){ //buy a product instantly

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
