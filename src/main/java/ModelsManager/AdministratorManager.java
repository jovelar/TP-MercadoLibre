package ModelsManager;

import Models.Administrator;
import Models.Enterprise;
import ModelsRepo.AdministratorRepo;
import Tools.Console;
import Tools.Menu;

import java.util.List;

public final class AdministratorManager {

    AdministratorRepo administratorRepo = new AdministratorRepo();

    public void showAdministratorsList(){
        List<Administrator> admsList = administratorRepo.toList();

        for(int i = 0; i < admsList.size(); i++){
            System.out.println( "ID:" + admsList.get(i).getIdUser() + " ." + admsList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public void addAministrator(){

        int idAdministrator = administratorRepo.toList().size() + 1;

        String username = Console.readString("Ingresar nombre de usuario:");
        String email = Console.readString("Ingresar correo electronico: ");
        String password = Console.readString("Ingresar contraseña:");
        String firstName = Console.readString("Ingresar nombre:");
        //String surname = Console.readString("Ingresar apellido:");
        //int dni = Console.readInt("Ingresar DNI:");

        //String birthDate = Console.readString("Ingrese su fecha de nacimiento:");
        //long phoneNumber = Console.readLong("Ingresar numero de celular (sin espacios):");

        Administrator administrator = new Administrator(idAdministrator, username, email, password, firstName,
                                "null", 0, "null", 0);

        administratorRepo.add(administrator);
        Console.showMessage("¡Cuenta ADMINISTRADOR creada con exito!");
    }

    //baja logica a alguno de los administrator de la lista
    public void deleteLogicallyAdminsitrator(){

        this.showAdministratorsList();
        int id = Console.readInt("Ingrese el ID del ADMINSITRADOR a dar de baja:");

        if(searchAdministratorById(id)){

            Console.showMessage("ADMINSITRADOR ENCONTRADO!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                Administrator adm = returnEnterpriseById(id);
                adm.setActive(false);
                this.administratorRepo.modify(adm);
                Console.showMessage("¡El ADMINISTRADOR se dio de baja exitosamente!");
            }
        }else{
            Console.showMessage("¡NO EXISTE NINGUN ADMINISTRADOR CON ESE ID!");
        }
    }

    //baja fisica, para ELIMINAR a alguno de los ADMINISTRATOR de la lista
    public void deleteAdministrator(){

        this.showAdministratorsList();
        int id = Console.readInt("Ingrese el id del administrador a eliminar");

        if(searchAdministratorById(id)){

            Console.showMessage("¡Administrador encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                this.administratorRepo.delete(id);
                Console.showMessage("¡El administrador ha sido eliminado exitosamente!");

                //TODO: al borrar un usuario del medio de la lista, queda un hueco en el nro de ID's
                // -> crear metodo que asigne los id's, seria una reasignacion de ID's
            }

        }else{
            Console.showMessage("¡NO EXISTE NINGUN ADMINISTRADOR CON ESE ID!");
        }
    }

    public boolean searchAdministratorById(int id){

        boolean resp = false;

        for(Administrator adm : administratorRepo.toList()){
            if(id == adm.getIdUser()){
                resp = true;
                break;
            }
        }

        return resp;
    }

    public Administrator returnEnterpriseById(int id){

        Administrator admFound = null;

        for(Administrator adm : administratorRepo.toList()){
            if(id == adm.getIdUser()){
                admFound = adm;
            }
        }

        return admFound;
    }

    public void totalModifyAdministrator(){

        //TODO: crear metodos showList en general, segun lo que ese quiera mostrar
        // si mostrar los activos, los inactivos, etc, mostrar en formato reducido, osea, menos datos
        showAdministratorsList();
        int idAdmSearched = Console.readInt("INGRESAR ID DEL ADMINISTRADOR A MODIFICAR:");

        if(searchAdministratorById(idAdmSearched)) {
            //TODO: falta en esta parte, un metodo que le muestre TODOS los datos del usuario a modificar,
            // si es que el usuario fue encontrado
            Console.showMessage("¡ADMINISTRADOR ENCONTRADO!");
            String resp = Console.readString("¿ESTA SEGURO DE CONTINUAR? [SI/NO]");

            if(resp.equalsIgnoreCase("SI")){

                String username = Console.readString("Ingresar nuevo nombre de usuario: ");
                String email = Console.readString("Ingresar nuevo email:");
                String password = Console.readString("Ingresar nueva contraseña:");

                String firstName = Console.readString("Ingresar nuevo nombre:");
                String surname = Console.readString("Ingresar nuevo apellido:");
                int dni = Console.readInt("Ingresar nuevo DNI:");
                String birthDate = Console.readString("Ingrese nueva fecha de nacimiento:");
                long phoneNumber = Console.readLong("Ingresar nuevo numero de celular (sin espacios):");

                Administrator adm = new Administrator(idAdmSearched, username, email, password, firstName, surname,
                        dni, birthDate, phoneNumber);

                administratorRepo.modify(adm);
                Console.showMessage("¡CUENTA ADMINISTRADOR MODIFICADA CON EXITO!");

            }else
                Console.showMessage("¡MODIFICACION CANCELADA!");

        }else{
            Console.showMessage("¡NO EXISTE NINGUN ADMINISTRADOR CON ESE ID!");
        }
    }


}

