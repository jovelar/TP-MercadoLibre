package Models;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class Administrator extends User implements Serializable {

    //region CONSTRUCTORS
    public Administrator(){}

    public Administrator(int idUser, String username, String email, String password, String firstName, String surname, int dni, LocalDateTime birthDate, long phoneNumber, boolean active) {
        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber, active);
    }
    //endregion

    public void logicUserDelete(){

    }
    public void userUpdate(){

    }
    public void userEdit(){

    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
