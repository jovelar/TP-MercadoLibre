package Models;

import Models.Client;

import java.time.LocalDateTime;

public class Enterprise extends Client {
    private String fantasyName;

    private float salesRevenue;

    //no deberiamos tener como atributo una lista de productos aca?


    //region constructors
    public Enterprise(){

    }

    public Enterprise(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber, LocalDateTime birthDate, Province province, String city, String adress, int postalCode, String type, String fantasyName, float salesRevenue) {
        super(iDPerson, dni, surname, firstName, username, email, password, active, phoneNumber, birthDate, province, city, adress, postalCode, type);
        this.fantasyName = fantasyName;
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
