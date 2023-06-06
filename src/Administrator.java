import java.time.LocalDateTime;

public class Administrator extends Client{
    public Administrator(){}

    public Administrator(int iDPerson, int dni, String surname, String firstName, String username, String email, String password, boolean active, long phoneNumber, LocalDateTime birthDate, Province province, String city, String adress, int postalCode, String type) {
        super(iDPerson, dni, surname, firstName, username, email, password, active, phoneNumber, birthDate, province, city, adress, postalCode, type);
    }

    public void logicUserDelete(){

    }
    public void userUpdate(){

    }
    public void userEdit(){

    }
}
