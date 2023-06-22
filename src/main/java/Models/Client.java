package Models;

import Enums.Province;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Client extends User {

    //region ATRIBUTES
    protected Province province;
    protected String city;
    protected String address;
    protected int postalCode;

    protected float availableMoney; //nuevo, reemplazamos la clase Credit
    //endregion

    //region CONSTRUCTORS
    public Client(){

    }

    //Creado para metodo addEnterprose() en clase EnterpriseManager
    public Client(int idUser, String username, String email, String password, String firstName, String surname,
                  int dni, String birthDate, long phoneNumber) {

        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber);
    }

    public Client(int idUser, String username, String email, String password, String firstName, String surname,
                   String birthDate, long phoneNumber) {

        super(idUser, username, email, password, firstName, surname, birthDate, phoneNumber);
    }

    public Client(int idUser, String username, String email, String password, String firstName, String surname, String birthDate, long phoneNumber, Province province, String city, String address, int postalCode, float availableMoney) {
        super(idUser, username, email, password, firstName, surname, birthDate, phoneNumber);
        this.province = province;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.availableMoney = availableMoney;
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

    public float getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(float availableMoney) {
        this.availableMoney = availableMoney;
    }

//endregion

    @Override
    public String toString() {
        return  super.toString() +
                "\n PROVINCIA...........:   " + this.province.getNombre() +
                "\n CIUDAD..............:   " + this.city +
                "\n DIRECCION...........:   " + this.address +
                "\n CODIGO POSTAL.......:   " + this.postalCode +
                "\n DINERO DISPONIBLE...:   " + this.availableMoney;
    }

    @Override
    public void viewProfile() {
        super.viewProfile();
    }
}