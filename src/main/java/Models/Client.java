package Models;

import Enums.Province;

import java.time.LocalDateTime;

public abstract class Client extends User {

    //region ATRIBUTES
    private Province province;
    private String city;
    private String address;
    private int postalCode;

    //region CONSTRUCTORS
    public Client(){

    }


    public Client(int idUser, String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate, long phoneNumber, boolean active, Province province, String city, String address, int postalCode) {

        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active);
        this.province = province;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
    }
    //endregion

    //region GETTERS AND SETTERS
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
    //endregion



}