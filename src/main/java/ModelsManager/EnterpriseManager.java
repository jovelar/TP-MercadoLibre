package ModelsManager;

import Models.Enterprise;
import ModelsRepo.EnterpriseRepo;
import Tools.Console;
import Tools.Menu;

import java.util.List;

public final class EnterpriseManager {

    EnterpriseRepo enterpriseRepo = new EnterpriseRepo();

    public void showEnterprisesList(){

        List<Enterprise> enterprisesList = this.enterpriseRepo.toList();

        for(int i = 0; i < enterprisesList.size(); i++) {
            System.out.println("\nID:    " + enterprisesList.get(i).getIdUser() + ". " + enterprisesList.get(i));
            System.out.println("\n ---------------------------------------------------------");
        }
    }

    public void addEnterprise(){

        int idEnterprise = enterpriseRepo.toList().size() + 1;

        String username = Console.readString("Ingresar nombre de usuario:");
        String email = Console.readString("Ingresar correo electronico: ");
        String password = Console.readString("Ingresar contraseña:");
        String firstName = Console.readString("Ingresar nombre:");
        String surname = Console.readString("Ingresar apellido:");
        int dni = Console.readInt("Ingresar DNI:");

        String birthDate = Console.readString("Ingrese su fecha de nacimiento:");
        long phoneNumber = Console.readLong("Ingresar numero de celular (sin espacios):");
        String fantasyName = Console.readString("Ingresar el nombre de la empresa:");

        Enterprise enterprise = new Enterprise(idEnterprise, username, email, password, firstName, surname, dni, birthDate, phoneNumber, fantasyName);

        Menu.provinceMenu(enterprise);

        enterprise.setCity(Console.readString("Ingresar ciudad:"));
        enterprise.setAddress(Console.readString("Ingresar direccion:"));
        enterprise.setPostalCode(Console.readInt("Ingresar codigo postal:"));

        enterpriseRepo.add(enterprise);
        Console.showMessage("¡Cuenta usuario-empresa creada con exito!");
    }

    //baja logica a alguno de los enterprise de la lista -> method for Administrator
    public void deleteLogicallyEnterprise(){

        this.showEnterprisesList();
        int id = Console.readInt("Ingrese el id del usuario-empresa a dar de baja:");

        if(searchEnterpriseById(id)){

            Console.showMessage("Usuario-empresa encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                Enterprise enterprise = returnEnterpriseById(id);
                enterprise.setActive(false);
                this.enterpriseRepo.modify(enterprise);
                Console.showMessage("¡El usuario-empresa se dio de baja exitosamente!");
            }

        }else{
            Console.showMessage("¡El usuario-empresa no se encuentra registrado en el sistema!");
        }
    }

    //baja fisica, para ELIMINAR a alguno de los enterprise de la lista -> method for Administrator
    public void deleteEnterprise(){

        this.showEnterprisesList();
        int id = Console.readInt("Ingrese el id del usuario-empresa a eliminar");

        if(searchEnterpriseById(id)){

            Console.showMessage("Usuario-empresa encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                this.enterpriseRepo.delete(id);
                Console.showMessage("¡El usuario-empresa ha sido eliminado exitosamente!");

                //TODO: al borrar un usuario del medio de la lista, queda un hueco en el nro de ID's
                // -> crear metodo que asigne los id's, seria una reasignacion de ID's
            }

        }else{
            Console.showMessage("¡El usuario-empresa no se encuentra registrado en el sistema!");
        }
    }

    public boolean searchEnterpriseById(int id){
        boolean resp = false;

        for(Enterprise enterprise : enterpriseRepo.toList()){
            if(id == enterprise.getIdUser()){
                resp = true;
                break;
            }
        }
        return resp;

    }

    public Enterprise returnEnterpriseById(int id){

        Enterprise enterpriseFound = null;

        for(Enterprise enterprise : enterpriseRepo.toList()){
            if(id == enterprise.getIdUser()){
                enterpriseFound = enterprise;
            }
        }
        return enterpriseFound;

    }

    public void totalModifyEnterprise(){

        //TODO: crear metodos showList en general, segun lo que ese quiera mostrar
        // si mostrar los activos, los inactivos, etc, mostrar en formato reducido, osea, menos datos
        showEnterprisesList();
        int idEnterpriseSearched = Console.readInt("INGRESAR ID DEL USUARIO-EMPRESA A MODIFICAR:");

        if(searchEnterpriseById(idEnterpriseSearched)) {
            //TODO: falta en esta parte, un metodo que le muestre TODOS los datos del usuario a modificar,
            // si es que el usuario fue encontrado
            Console.showMessage("¡USUARIO-EMPRESA ENCONTRADO!");
            String resp = Console.readString("¿ESTA SEGURO DE CONTINUAR? [SI/NO]");

            if(resp.equalsIgnoreCase("SI")) {

                String username = Console.readString("Ingresar nuevo nombre de usuario: ");
                String email = Console.readString("Ingresar nuevo email:");
                String password = Console.readString("Ingresar nueva contraseña:");

                String firstName = Console.readString("Ingresar nuevo nombre:");
                String surname = Console.readString("Ingresar nuevo apellido:");
                int dni = Console.readInt("Ingresar nuevo DNI:");
                String birthDate = Console.readString("Ingrese nueva fecha de nacimiento:");
                long phoneNumber = Console.readLong("Ingresar nuevo numero de celular (sin espacios):");

                String fantasyName = Console.readString("Ingresar el nuevo nombre de la empresa:");

                Enterprise enterprise = new Enterprise(idEnterpriseSearched, username, email, password, firstName, surname,
                        dni, birthDate, phoneNumber, fantasyName);

                Menu.provinceMenu(enterprise);

                enterprise.setCity(Console.readString("Ingresar nueva ciudad:"));
                enterprise.setAddress(Console.readString("Ingresar nueva direccion:"));
                enterprise.setPostalCode(Console.readInt("Ingresar nuevo codigo postal:"));

                enterpriseRepo.modify(enterprise);
                Console.showMessage("¡CUENTA USUARIO-EMPRESA MODIFICADA CON EXITO!");

            } else
                Console.showMessage("¡MODIFICACION CANCELADA!");
        }else{
            Console.showMessage("¡NO EXISTE NINGUN USUARIO-EMPRESA CON ESE ID!");
        }
    }


}
