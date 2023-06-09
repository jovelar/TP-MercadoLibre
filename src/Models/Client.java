package Models;

import Enums.Province;
import Models.User;

import java.time.LocalDateTime;

public abstract class Client extends User {
    private Province province;
    private String city;
    private String address;
    private int postalCode;
    private String type; //eliminar

    //region constructors
    public Client(){

    }
    public Client(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber, LocalDateTime birthDate, Province province, String city, String address, int postalCode, String type) {
        super(iDPerson, dni, surname, firstName, username, email, password, active, birthDate,phoneNumber);
        this.province = province;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.type = type;
    }
    //endregion

    //region getters and setters

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//endregion
}