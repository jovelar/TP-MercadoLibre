package Models;

import Enums.Province;

import java.time.LocalDateTime;

public abstract class Client extends User {

    //region ATRIBUTES
    protected Province province;
    protected String city;
    protected String address;
    protected int postalCode;

    protected double availableMoney; //nuevo, reemplazamos la clase Credit
    //endregion

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

    @Override
    public String toString() {
        return  super.toString() +
                "\n PROVINCIA...........:   " + this.province +
                "\n CIUDAD..............:   " + this.city +
                "\n DIRECCION...........:   " + this.address +
                "\n CODIGO POSTAL.......:   " + this.postalCode +
                "\n DINERO DISPONIBLE...:   " + this.availableMoney;
    }


}