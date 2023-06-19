package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Models.SubModels.Order;


import Enums.Province;
import Models.SubModels.PayMethod;

public final class Buyer extends Client {

    //region ATTRIBUTES
    private ArrayList<Integer>cart;
    private List<Integer>favorites;
    private List<PayMethod> payMethod;
    //endregion

    //region CONTRUCTORS
    public Buyer(){}

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate, long phoneNumber, boolean active, Province province, String city, String address, int postalCode) {
        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active, province, city, address, postalCode);
    }


    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate, long phoneNumber, boolean active, Province province, String city, String address, int postalCode, ArrayList<Integer> cart, List<Integer> favorites, List<PayMethod> payMethod) {
        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active, province, city, address, postalCode);
        this.cart = cart;
        this.favorites = favorites;
        this.payMethod = payMethod;
    }

    public Buyer(String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate, long phoneNumber, ArrayList<Integer> cart, List<Integer> favorites, List<PayMethod> payMethod) {
        super(username, email, password, firstName, surname, dni, birthDate, phoneNumber);
        this.cart = cart;
        this.favorites = favorites;
        this.payMethod = payMethod;
    }

//endregion

    //region GETTERS AND SETTERS


    public ArrayList<Integer> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Integer> cart) {
        this.cart = cart;
    }

    public List<Integer> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Integer> favorites) {
        this.favorites = favorites;
    }

    public List<PayMethod> getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(List<PayMethod> payMethod) {
        this.payMethod = payMethod;
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

