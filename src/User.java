public abstract class User {
    private int iDPerson;
    private int dni;
    private String surname;
    private String firstName;
    private String username;
    private String email;
    private String password;
    private boolean active;
    private long phoneNumber;

    public User(){

    }

    public User(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber) {
        this.iDPerson = iDPerson;
        this.dni = dni;
        this.surname = surname;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.phoneNumber = phoneNumber;
    }

    public int getiDPerson() {
        return iDPerson;
    }

    public void setiDPerson(int iDPerson) {
        this.iDPerson = iDPerson;
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
}



