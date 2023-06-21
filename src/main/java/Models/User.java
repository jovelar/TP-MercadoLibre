package Models;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    //region ATTRIBUTES
    protected int idUser;
    protected String username;
    protected String email;
    protected String password;

    //personal information
    protected String firstName;
    protected String surname;
    protected int dni;
    protected String birthDate;
    protected long phoneNumber;
    protected boolean active;
    //endregion

    //region CONSTRUCTORS
    public User(){}



    //Creado para metodo addEnterprise() en clase EnterpriseManager y addAdministrator en AdministratorManager
    public User(int idUser, String username, String email, String password, String firstName, String surname,
                int dni, String birthDate, long phoneNumber) {

        this.idUser = idUser;
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

    public boolean getActive() {
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

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    //endregion

    //nuevos metodos
    public void addMoney(){

    }
    public void removeMoney(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return dni == user.dni && Objects.equals(username, user.username) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + Integer.hashCode(dni);
        return result;
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
                "\n USUARIO ACTIVO...:   " + this.active;
    }

}



