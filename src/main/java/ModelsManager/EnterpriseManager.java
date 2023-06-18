package ModelsManager;

import Models.Enterprise;
import ModelsRepo.EnterpriseRepo;
import Tools.Console;
import Tools.Menu;

import java.time.LocalDateTime;
import java.util.List;

public final class EnterpriseManager {

    EnterpriseRepo enterpriseRepo = new EnterpriseRepo();

    public void showEnterprisesList(){

        List<Enterprise> enterprisesList = enterpriseRepo.toList();

        for(int i = 0; i < enterprisesList.size(); i++){
            System.out.println( "ID:" + enterprisesList.get(i).getIdUser() + ". " + enterprisesList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public void addEnterprise(){

        Enterprise enterprise = null;

        //int idEnterprise = Console.readInt("Ingrese el id del usuario empresa:"); //se supone que tiene q ser asignado automaticamente
        String username = Console.readString("Ingrese su nombre de usuario:");
        String email = Console.readString("Ingrese su correo electronico: ");
        String password = Console.readString("Ingrese su contraseña:");
        String firstName = Console.readString("Ingrese su nombre:");
        String surname = Console.readString("Ingrese su apellido:");
        int dni = Console.readInt("Ingrese su DNI:");

        //TODO: Repasar lo siguiente e implementarlo correctamente
        LocalDateTime birthDate = null; //Console.readString("Ingrese su fecha de nacimiento:");
        long phoneNumber = Console.readLong("Ingrese su numero de celular (sin espacios):");
        String fantasyName = Console.readString("Ingrese el nombre de su empresa:");

        enterprise = new Enterprise(username, email, password, firstName, surname, dni, birthDate, phoneNumber, fantasyName);

        Menu.provinceCategoriesMenu(enterprise);

        enterprise.setCity(Console.readString("Ingrese su ciudad:"));
        enterprise.setAddress(Console.readString("Ingrese su direccion:"));
        enterprise.setPostalCode(Console.readInt("Ingrese su codigo postal:"));


        enterpriseRepo.add(enterprise);
        System.out.println("¡Su cuenta usuario-empresa ha sido creada con exito!");


    }



    public void terminateCompany(){
        //baja logica
    }

    public void deleteEnterprise(){

    }

}
