package Models;

import Tools.Console;

import java.io.Serializable;

public final class Administrator extends User implements Serializable {

    //region CONSTRUCTORS
    public Administrator(){}

    public Administrator(int idUser, String username, String email, String password, String firstName, String surname,
                         int dni, String birthDate, long phoneNumber) {

        super(idUser, username, email, password, firstName, surname, dni, birthDate, phoneNumber);
    }

    //Constructor para la modificacion total del administrador sin DNI
    public Administrator(int idUser, String username, String email, String password, String firstName, String surname,
                         String birthDate, long phoneNumber) {

        super(idUser, username, email, password, firstName, surname, birthDate, phoneNumber);
    }
    //endregion

    public void logicUserDelete(){

    }
    public void userUpdate(){

    }
    public void userEdit(){

    }

    public void viewProfile(){
        Console.cleanConsole();


        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               MI PERFIL");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        System.out.println(this);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

    }


    @Override
    public String toString() {
        return  super.toString();
    }
}
