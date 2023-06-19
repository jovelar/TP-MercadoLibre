package Models;

import java.io.Serializable;

public final class Administrator extends User implements Serializable {

    //region CONSTRUCTORS
    public Administrator(){}

    public Administrator(int idUser, String username, String email, String password, String firstName, String surname,
                         int dni, String birthDate, long phoneNumber, boolean active) {

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
