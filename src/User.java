import java.time.LocalDateTime;

public abstract class User {
    private int idUser;
    private String username;
    private String email;
    private String password;

    //personal information
    private String firstName;
    private String surname;
    private int dni;
    private LocalDateTime birthDate; //agregado
    private long phoneNumber;
    private boolean active;

    //region constructors
    public User(){

    }

    public User(int idUser, int dni, String surname, String firstName, String username, String email, String password, boolean active, LocalDateTime birthDate, long phoneNumber) {
        this.idUser = idUser;
        this.dni = dni;
        this.surname = surname;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
    //endregion

    //region getters and setters

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
}



