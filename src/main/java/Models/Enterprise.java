package Models;

import Enums.Province;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Enterprise extends Client implements Serializable {

    //region ATTRIBUTES
    private String fantasyName;
    private float salesRevenue;
    //endregion

    //region CONSTRUCTORS
    public Enterprise(){

    }

    public Enterprise(int idEnterprise, String username, String email, String password, String firstName, String surname,
                      int dni, String birthDate, long phoneNumber, boolean active, Province province,
                      String city, String address, int postalCode, String fantasyName, float salesRevenue) {

        super(idEnterprise, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active,
                province, city, address, postalCode);

        this.fantasyName = fantasyName;
        this.salesRevenue = salesRevenue;
    }

    //Creado para metodo addEnterprose() en clase EnterpriseManager
    public Enterprise(int idEnterprise, String username, String email, String password, String firstName, String surname, int dni,
                      String birthDate, long phoneNumber, String fantasyName) {

        super(idEnterprise, username, email, password, firstName, surname, dni, birthDate, phoneNumber);

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
}
