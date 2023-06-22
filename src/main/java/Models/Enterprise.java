package Models;

import Enums.Province;
import Tools.Console;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public final class Enterprise extends Client implements Serializable {

    //region ATTRIBUTES
    private String fantasyName;
    private float salesRevenue;

    private ArrayList<Integer> myProducts = new ArrayList<>();
    //endregion

    //region CONSTRUCTORS
    public Enterprise(){

    }


    //Creado para metodo addEnterprose() en clase EnterpriseManager
    public Enterprise(int idEnterprise, String username, String email, String password, String firstName, String surname, int dni,
                      String birthDate, long phoneNumber, String fantasyName) {

        super(idEnterprise, username, email, password, firstName, surname, dni, birthDate, phoneNumber);

        this.fantasyName = fantasyName;
    }

    public Enterprise(int idEnterprise, String username, String email, String password, String firstName, String surname,
                      String birthDate, long phoneNumber, String fantasyName) {

        super(idEnterprise, username, email, password, firstName, surname, birthDate, phoneNumber);

        this.fantasyName = fantasyName;
    }


    //endregion

    //region GETTERS AND SETTERS
    public String getFantasyName() {
        return fantasyName;
    }
    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public float getSalesRevenue() {
        return salesRevenue;
    }
    public void setSalesRevenue(float salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public ArrayList<Integer> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(ArrayList<Integer> myProducts) {
        this.myProducts = myProducts;
    }

    //endregion

    public void addProduct(){

    }
    public void editProduct(){

    }
    public void updateProduct(){

    }
    public void deleteProduct(){

    }



    @Override
    public String toString() {
        return  super.toString() +
                "\n NOMBRE FANTASIA.....:   " + this.fantasyName +
                "\n INGRESOS POR VTAS...:   " + this.salesRevenue;
    }

    @Override
    public void viewProfile() {
        super.viewProfile();
    }
}
