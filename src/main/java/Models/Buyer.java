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
    private List<Integer>favorites;
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
    public void showFavoriteList(List<Product> importedFavoriteList) {
        if(!favorites.isEmpty()){
            int position = 0;
            boolean found = false;
            for (int x = 0; x < importedFavoriteList.size(); x++) {
                while (found == false && position < importedFavoriteList.size()) {
                    if (favorites.get(x)== importedFavoriteList.get(position).getIdProduct()) {
                        System.out.println("ID: " + importedFavoriteList.get(x).getIdProduct() + ",MARCA: " + importedFavoriteList.get(x).getBrand() + ", PRODUCTO: " + importedFavoriteList.get(x).getProductName() + ", PRECIO: " + importedFavoriteList.get(x).getPrice() + ", DESCRIPCION: " + importedFavoriteList.get(x).getDescription());
                        found=true;
                    }
                    position++;
                }
                found=false;
            }
        }else{
            System.out.println("La lista esta vacia");
        }
    }


    public void deleteFavorite(){
        if(!favorites.isEmpty()){
            int id= Validations.doUntilValidNumber(Console.readInt("Ingrese el ID del producto a eliminar"));
            boolean found=false;
            int counter=0;
            while(counter<favorites.size() && found==false){
                if(favorites.get(counter)==id){
                    found=true;
                }
                counter++;
            }

        }else{
            System.out.println("La lista esta vacia");
        }

    }
    public boolean validateAvailableProducts(){
        boolean state = true;



        return state;
    }


    //endregion
}

