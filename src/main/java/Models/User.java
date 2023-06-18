package Models;

import java.time.LocalDateTime;

public abstract class User {

    //region ATTRIBUTES
    protected int idUser;
    protected String username;
    protected String email;
    protected String password;

    //personal information
    protected String firstName;
    protected String surname;
    protected int dni;
    protected LocalDateTime birthDate; //agregado
    protected long phoneNumber;
    protected boolean active;
    //endregion

    //region CONSTRUCTORS
    public User(){}

    public User(int idUser, String username, String email, String password, String firstName, String surname, int dni,
                LocalDateTime birthDate, long phoneNumber, boolean active) {

        this.idUser = idUser;

        this.username = username;
        this.email = email;
        this.password = password;

        this.firstName = firstName;
        this.surname = surname;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.active = true;
    }

    //Creado para metodo addEnterprose() en clase EnterpriseManager
    public User(String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate, long phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.active = true;
    }
    //endregion

    //region GETTERS AND SETTERS
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
    //endregion

    //nuevos metodos
    public void addMoney(){

    }
    public void removeMoney(){

    }

    @Override
    public String toString() {
        return  //"\n ID..................:   " + this.idUser +
                "\n NOMBRE DE USUARIO...:   " + this.username +
                "\n CORREO ELECTRONICO..:   " + this.email +
                "\n CONTRASEÑA..........:   " + this.password +
                "\n NOMBRE..............:   " + this.firstName +
                "\n APELLIDO............:   " + this.surname +
                "\n DNI.................:   " + this.dni +
                "\n FECHA DE NAC........:   " + this.birthDate +
                "\n NRO. DE CELULAR.....:   " + this.phoneNumber +
                "\n USUARIO ELIMINADO...:   " + this.active;
    }

}



