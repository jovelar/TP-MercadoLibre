package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Models.SubModels.Order;


import Enums.Province;
import Models.SubModels.PayMethod;
import Tools.Console;
import Tools.Validations;

public final class Buyer extends Client {

    //region ATTRIBUTES
    private ArrayList<Integer>cart;
    private List<Integer>favorites=new ArrayList<Integer>();
    private List<PayMethod> payMethod;
    //endregion

    //region CONTRUCTORS
    public Buyer(){}

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni, String birthDate, long phoneNumber) {
        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber);
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
    public void pay(float price){

    }
    public void cancelBuy(){

    }
    public void buyCart(){

    }
    public Order instantBuy(){ //buy a product instantly
        Order newOrder=new Order();


        return newOrder;
    }
    public void addFavorite(int idProduct){


    }
    public void showFavoriteList(ArrayList<Product> importedFavoriteList) {
        if(!importedFavoriteList.isEmpty()){
            for(int x=0;x<importedFavoriteList.size();x++){
            System.out.println("ID: "+importedFavoriteList.get(x).getIdProduct() +
                               "PRODUCTO: "+importedFavoriteList.get(x).getProductName()+
                                "MARCA: "+importedFavoriteList.get(x).getBrand()+
                                "PRECIO: "+importedFavoriteList.get(x).getPrice());
            }
        }else{
            Console.showMessageError("La lista esta vacia!");
        }
    }


    public void deleteFavorite(int idToDelete){
        favorites.remove(idToDelete);
    }
    public boolean validateAvailableProducts(){
        boolean state = true;



        return state;
    }
    public boolean validateValidFavorite(int iDToDelete){
        boolean valid=false;
        for(int x=0;x<favorites.size();x++){
            if(favorites.get(x)==iDToDelete){
                valid=true;
            }
        }
        return valid;
    }

    //endregion
}

