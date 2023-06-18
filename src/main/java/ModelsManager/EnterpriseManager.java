package ModelsManager;

import Models.Enterprise;
import Models.Product;
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
        String username = Console.readString("Ingresar nombre de usuario:");
        String email = Console.readString("Ingresar correo electronico: ");
        String password = Console.readString("Ingresar contraseña:");
        String firstName = Console.readString("Ingresar nombre:");
        String surname = Console.readString("Ingresar apellido:");
        int dni = Console.readInt("Ingresar DNI:");

        //TODO: Repasar lo siguiente e implementarlo correctamente
        LocalDateTime birthDate = null; //Console.readString("Ingrese su fecha de nacimiento:");
        long phoneNumber = Console.readLong("Ingresar numero de celular (sin espacios):");
        String fantasyName = Console.readString("Ingresar el nombre de la empresa:");

        enterprise = new Enterprise(username, email, password, firstName, surname, dni, birthDate, phoneNumber, fantasyName);

        Menu.provinceMenu(enterprise);

        enterprise.setCity(Console.readString("Ingresar ciudad:"));
        enterprise.setAddress(Console.readString("Ingresar direccion:"));
        enterprise.setPostalCode(Console.readInt("Ingresar codigo postal:"));

        enterpriseRepo.add(enterprise);
        System.out.println("¡Cuenta usuario-empresa creada con exito!");
    }


    //baja logica a alguno de los enterprise de la lista -> metodo para Administrator
    public void deleteLogically(){
        int id = Console.readInt("Ingrese el id del usuario-empresa a dar de baja:");

        this.showEnterprisesList();

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

    //baja fisica, para ELIMINAR a alguno de los enterprise de la lista -> metodo para Administrator
    public void deleteEnterprise(){

        int id = Console.readInt("Ingrese el id del usuario-empresa a eliminar");
        this.showEnterprisesList();

        if(searchEnterpriseById(id)){

            Console.showMessage("Usuario-empresa encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            String resp = Console.readString("¿Esta seguro de continuar? [si/no]");

            if(resp.equalsIgnoreCase("si")){

                this.enterpriseRepo.delete(id);
                Console.showMessage("¡El usuario-empresa ha sido eliminado exitosamente!");
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

}
