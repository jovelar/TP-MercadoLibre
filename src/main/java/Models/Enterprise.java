package Models;

import Enums.Province;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Enterprise extends Client implements Serializable {

    //region ATTRIBUTES
    private String fantasyName;
    private float salesRevenue;
    //endregion


    //region CONSTRUCTORS
    public Enterprise(){

    }

    public Enterprise(int idUser, String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate,
          long phoneNumber, boolean active, Province province, String city, String address, int postalCode, String fantasyName, float salesRevenue) {

        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active, province, city, address, postalCode);

        this.fantasyName = fantasyName;
        this.salesRevenue = salesRevenue;
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
    //endregion

    public void addProduct(){

    }
    public void editProduct(){

    }
    public void updateProduct(){

    }
    public void deleteProduct(){

    }
}
