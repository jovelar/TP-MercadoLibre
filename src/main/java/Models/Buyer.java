package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Models.SubModels.Card;
import Models.SubModels.Order;


import Enums.Province;
import Models.SubModels.PayMethod;
import Tools.Console;
import Tools.Validations;

public final class Buyer extends Client {

    //region ATTRIBUTES
    private ArrayList<Integer> cart = new ArrayList<>();
    private List<Integer> favorites = new ArrayList<Integer>();
    private List<Integer> cards=new ArrayList<>();

    private List<Integer>shoppingHistory=new ArrayList<Integer>();
    //endregion

    //region CONTRUCTORS
    public Buyer() {
    }

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, int dni, String birthDate, long phoneNumber) {
        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber);
    }

    //constructor para la modificacion de buyer sin DNI

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, String birthDate, long phoneNumber) {
        super(idUser, username, email, password, firstName, surname, birthDate, phoneNumber);
    }

    public Buyer(int idUser, String username, String email, String password, String firstName, String surname, String birthDate, long phoneNumber, Province province, String city, String address, int postalCode, float availableMoney, ArrayList<Integer> cart, List<Integer> favorites, List<Integer> cards, List<Integer> shoppingHistory) {
        super(idUser, username, email, password, firstName, surname, birthDate, phoneNumber, province, city, address, postalCode, availableMoney);
        this.cart = cart;
        this.favorites = favorites;
        this.cards = cards;
        this.shoppingHistory = shoppingHistory;
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

   /* public List<PayMethod> getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(List<PayMethod> payMethod) {
        this.payMethod = payMethod;
    }*/
    //endregion

    //region METHODS
    public void pay(float price) {

    }

    public void cancelBuy() {

    }

    public void buyCart() {

    }

    public Order instantBuy() { //buy a product instantly
        Order newOrder = new Order();


        return newOrder;
    }

    public void addFavorite(int idProduct){
        if(this.favorites == null){
            favorites = new ArrayList<>();
            favorites.add(idProduct);
            Console.showMessage("PRODUCTO AGREGADO A FAVORITOS!");

        }else {
            this.favorites.add(idProduct);
            Console.showMessage("PRODUCTO AGREGADO A FAVORITOS!");

        }
    }

    public void showFavoriteList(ArrayList<Product> importedFavoriteList) {
        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               LISTA FAVORITOS");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");
        if(!importedFavoriteList.isEmpty()){
            for(int x=0;x<importedFavoriteList.size();x++){
            System.out.println("- ID: "+importedFavoriteList.get(x).getIdProduct() +
                               " - PRODUCTO: "+importedFavoriteList.get(x).getProductName()+
                                " - MARCA: "+importedFavoriteList.get(x).getBrand()+
                                " - PRECIO: "+importedFavoriteList.get(x).getPrice());
            }
        } else {
            Console.showMessageError("La lista esta vacia!");
        }
    }


    public void deleteFavorite(int idToDelete) {
        favorites.remove(Integer.valueOf(idToDelete));
    }

    public void deleteProductFromCart(int idToDelete) {
        cart.remove((Integer) idToDelete);
    }

    public boolean validateAvailableProducts() {
        boolean state = true;


        return state;
    }

    public boolean validateValidFavorite(int iDToDelete) {
        boolean valid = false;
        if (favorites == null) {
            valid = true;
        } else {
            for (int x = 0; x < favorites.size(); x++) {
                if (favorites.get(x) == iDToDelete) {
                    valid = true;
                }
            }
        }

        return valid;
    }

    public void addToCart(int idProduct) {
        if (cart == null) {
            cart = new ArrayList<Integer>();
        }
        if (cart.size() == 1) {
            if (cart.get(0) != idProduct) {
                cart.add(idProduct);
            }
        } else {
            boolean exist = false;
            for (int x = 0; x < cart.size(); x++) {
                if (cart.get(x) == idProduct) {
                    exist = true;
                }
            }
            if (!exist) {
                cart.add(idProduct);
            }
        }
    }
    @Override
    public void viewProfile() {
        super.viewProfile();
    }
    @Override
    public String toString() {
        return  super.toString();

    }

    public float cartValue(List<Product>list){
        float finalValue=0;
        for(int x=0;x<list.size();x++){
            finalValue=finalValue+list.get(x).getPrice();
        }
        return finalValue;
    }
    public boolean checkAvailableCredit(float value){
        boolean valid=true;
        if(value>super.getAvailableMoney()){
            valid=false;
        }
        return valid;
    }
    public void removeCredit(float value){
        super.setAvailableMoney(super.getAvailableMoney()-value);
    }
    public void clearCart(){
        cart.clear();
    }
    //endregion
    public List<Integer> getShoppingHistory(){
        return shoppingHistory;
    }

    public void setShoppingHistory(List<Integer> shoppingHistory) {
        this.shoppingHistory = shoppingHistory;
    }
    public void addToShoppingHistory(int orderNumber){
        if(shoppingHistory==null){
            shoppingHistory=new ArrayList<>();
        }
        shoppingHistory.add(orderNumber);
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void setCards(List<Integer> cards) {
        this.cards = cards;
    }
    public void addCard(int idCard){
        if(cards==null){
            cards=new ArrayList<Integer>();
        }
        if(cards.size()==1){
            if(!(cards.get(0)==idCard)){
                cards.add(idCard);
            }
        }else{
            boolean exists=false;
            for(int x=0;x<cards.size();x++){
                if(cards.get(x)==idCard){
                    exists=true;
                }
            }
            if(!exists){
                cards.add(idCard);
            }
        }
    }
}

