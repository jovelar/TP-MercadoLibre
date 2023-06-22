package ModelsManager;

import Models.Administrator;
import Models.Buyer;
import Models.Enterprise;
import ModelsRepo.EnterpriseRepo;
import Tools.Console;
import Tools.Menu;
import Tools.Validations;

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

    public boolean addEnterprise(){

        boolean answer = false;
        int idEnterprise = enterpriseRepo.toList().size() + 1;

        String username = Validations.doUntilUsernameIsNotInUse(Console.readString("Ingresar nombre de usuario:"));

        if (!username.equals("SALIR")) {

            String email = Validations.doUntilEmailIsNotInUse(Validations.doUntilValidEmail(Console.readString("Ingresar correo electronico: ")));

            if (!email.equals("SALIR")) {

                String password = Validations.doUntilPasswordValid(Console.enterPassword());

                if (!password.equals("SALIR")) {

                    String firstName = Validations.doUntilValidName(Console.readString("Ingresar nombre:"));
                    if (!firstName.equals("SALIR")) {

                        String surname = Validations.doUntilValidName(Console.readString("Ingresar apellido:"));

                        if (!surname.equals("SALIR")) {

                            int dni = Validations.doUntilPersonIsNotRegistred(Validations.doUntilValidDNI(Console.readInt("Ingresar DNI:")));

                            if (dni != 0) {

                                String birthDate = Validations.doUntilValidBirthDate(Console.readString("Ingrese su fecha de nacimiento \n\nFormato: dd/MM/yyy\n"));
                                if (!birthDate.equals("SALIR")) {

                                    long phoneNumber = Validations.doUntilValidPhoneNumber(Console.readLong("Ingresar numero de celular (sin espacios):"));

                                    if (phoneNumber != 0) {

                                        String fantasyName = Console.readString("Ingresar el nombre de la empresa:");
                                        if (!fantasyName.equals("SALIR")) {
                                            Enterprise enterprise = new Enterprise(idEnterprise, username, email, password, firstName, surname, dni, birthDate, phoneNumber, fantasyName);

                                            int resp = Menu.provinceMenu(enterprise);
                                            if (resp != 0) {
                                                enterprise.setCity(Console.readString("Ingresar ciudad:"));

                                                if (!enterprise.getCity().equals("SALIR")) {
                                                    enterprise.setAddress(Console.readString("Ingresar direccion:"));

                                                    if (!enterprise.getAddress().equals("SALIR")) {
                                                        enterprise.setPostalCode(Validations.doUntilValidPostalCode(Console.readInt("Ingresar codigo postal:")));

                                                        if (enterprise.getPostalCode() != 0) {
                                                            enterpriseRepo.add(enterprise);
                                                            answer = true;

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return answer;
    }



    //baja logica a alguno de los enterprise de la lista -> method for Administrator
    public boolean deleteLogicallyEnterprisForAdm(){
        boolean delete = false;

        this.showEnterprisesList();
        int id = Validations.doUntilValidNumber(Console.readInt("Ingrese el id del usuario-empresa a dar de baja:"));

        if(searchEnterpriseById(id)){

            Console.showMessage("Usuario-empresa encontrado!");

            //TODO mejorar la sig linea por un JOptionPane que tenga los botones SI/NO
            int answer = Console.buttonsYesNo();

            if(answer == 0){
                Enterprise enterprise = returnEnterpriseById(id);
                enterprise.setActive(false);
                this.enterpriseRepo.modify(enterprise);
                Console.showMessage("¡El usuario-empresa se dio de baja exitosamente!");
                delete = true;
            }

        }else{
            Console.showMessage("¡El usuario-empresa no se encuentra registrado en el sistema!");
        }
        return delete;
    }
    public String modifyEnterpriseForAdm(){
        String optionEntered = "SALIR";

        this.showEnterprisesList();
        int id = Validations.doUntilValidNumber(Console.readInt("Ingrese el id del usuario-empresa a modificar:"));
        Enterprise enterprise = returnEnterpriseById(id);

        if(enterprise != null){

            Console.showMessage("Usuario-empresa encontrado!");
            int answer = Console.buttonsModifyGeneralAndReturn();

            if(answer == 0) {
                optionEntered = Menu.menuModifyEnterprise(enterprise.getIdUser());  //se le asigna modificado si se modifico o salir
            }

        }else{
            Console.showMessage("¡El usuario-empresa no se encuentra registrado en el sistema!");
            }

        return optionEntered;
    }

    //baja fisica, para ELIMINAR a alguno de los enterprise de la lista -> method for Administrator
    public void deleteEnterprise(){

        this.showEnterprisesList();
        int id = Validations.doUntilValidNumber(Console.readInt("Ingrese el id del usuario-empresa a eliminar"));

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
        for(Enterprise enterprise :  this.enterpriseRepo.toList()){
            if(id == enterprise.getIdUser()){
                return true;
            }
        }
        return false;
    }

    public boolean searchEnterpriseByUsername(String username){
        for(Enterprise enterprise : this.enterpriseRepo.toList()){
            if(enterprise.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean searchEnterpriseByEmail(String email){
        for(Enterprise enterprise : this.enterpriseRepo.toList()){
            if(enterprise.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public boolean searchEnterpriseByDni(int dni){
        for(Enterprise enterprise : this.enterpriseRepo.toList()){
            if(enterprise.getDni() == dni){
                return true;
            }
        }
        return false;
    }

    public Enterprise returnEnterpriseById(int id){
        Enterprise enterpriseWanted = null;

        for(Enterprise enterprise : this.enterpriseRepo.toList()){
            if(id == enterprise.getIdUser()){
                enterpriseWanted = enterprise;
                break;
            }
        }
        return enterpriseWanted;
    }

    public Enterprise returnEnterpriseByUsername(String username){
        Enterprise enterpriseWanted = null;

        for(Enterprise enterprise : this.enterpriseRepo.toList()){
            if(enterprise.getUsername().equals(username)){
                enterpriseWanted = enterprise;
                break;
            }
        }
        return enterpriseWanted;
    }

    public boolean totalModifyEnterpriseForAdm(){ // TODO falta modificarlo
        boolean answer = false;

        //TODO: crear metodos showList en general, segun lo que ese quiera mostrar
        // si mostrar los activos, los inactivos, etc, mostrar en formato reducido, osea, menos datos
        showEnterprisesList();
        int idEnterpriseSearched = Validations.doUntilValidNumber(Console.readInt("INGRESAR ID DEL USUARIO-EMPRESA A MODIFICAR:"));

        if(searchEnterpriseById(idEnterpriseSearched)) {
            //TODO: falta en esta parte, un metodo que le muestre TODOS los datos del usuario a modificar,
            // si es que el usuario fue encontrado
            Console.showMessage("¡USUARIO-EMPRESA ENCONTRADO!");
            String resp = Console.readString("¿ESTA SEGURO DE CONTINUAR? [SI/NO]");

            if(resp.equalsIgnoreCase("SI")) {

                String username = Console.readString("Ingresar nuevo nombre de usuario: ");
                String email = Validations.doUntilValidEmail(Console.readString("Ingresar nuevo email:"));
                String password = Console.readString("Ingresar nueva contraseña:");

                String firstName = Validations.doUntilValidName(Console.readString("Ingresar nuevo nombre:"));
                String surname = Validations.doUntilValidName(Console.readString("Ingresar nuevo apellido:"));
                int dni = Validations.doUntilValidNumber(Console.readInt("Ingresar nuevo DNI:"));
                String birthDate = Validations.doUntilValidBirthDate(Console.readString("Ingrese nueva fecha de nacimiento:"));
                long phoneNumber = Validations.doUntilValidPhoneNumber(Console.readLong("Ingresar nuevo numero de celular (sin espacios):"));

                String fantasyName = Console.readString("Ingresar el nuevo nombre de la empresa:");

                Enterprise enterprise = new Enterprise(idEnterpriseSearched, username, email, password, firstName, surname,
                        dni, birthDate, phoneNumber, fantasyName);

                Menu.provinceMenu(enterprise);

                enterprise.setCity(Console.readString("Ingresar nueva ciudad:"));
                enterprise.setAddress(Console.readString("Ingresar nueva direccion:"));
                enterprise.setPostalCode(Validations.doUntilValidPostalCode(Console.readInt("Ingresar nuevo codigo postal:")));

                enterpriseRepo.modify(enterprise);
                Console.showMessage("¡CUENTA USUARIO-EMPRESA MODIFICADA CON EXITO!");
                answer = true;
            } else
                Console.showMessage("¡MODIFICACION CANCELADA!");
        }else{
            Console.showMessage("¡NO EXISTE NINGUN USUARIO-EMPRESA CON ESE ID!");
        }
        return answer;
    }

    public boolean totalModifyOneEnterprise(int idEnterprise) {
        boolean answer = false;

        String username = Validations.doUntilUsernameIsNotInUse(Console.readString("Ingresar nuevo nombre de usuario:"));
        if (!username.equals("SALIR")) {

            String email = Validations.doUntilEmailIsNotInUse(Validations.doUntilValidEmail(Console.readString("Ingresar nuevo correo electronico: ")));
            if (!email.equals("SALIR")) {

                String password = Validations.doUntilPasswordValid(Console.enterPassword());
                if (!password.equals("SALIR")) {

                    String firstName = Validations.doUntilValidName(Console.readString("Ingresar nuevo nombre:"));
                    if (!firstName.equals("SALIR")) {

                        String surname = Validations.doUntilValidName(Console.readString("Ingresar nuevo apellido:"));
                        if (!surname.equals("SALIR")) {

                            String birthDate = Validations.doUntilValidBirthDate(Console.readString("Ingrese nueva fecha de nacimiento \n\nFormato: dd/MM/yyy\n"));
                            if (!birthDate.equals("SALIR")) {

                                long phoneNumber = Validations.doUntilValidPhoneNumber(Console.readLong("Ingresar nuevo numero de celular (sin espacios):"));
                                if (phoneNumber != 0) {

                                    String fantasyName = Console.readString("Ingresar el nombre de la empresa:");
                                    if (!fantasyName.equals("SALIR")) {
                                        Enterprise enterprise = new Enterprise(idEnterprise, username, email, password,
                                                firstName, surname, birthDate, phoneNumber, fantasyName);

                                        int resp = Menu.provinceMenu(enterprise);
                                        if (resp != 0) {
                                            enterprise.setCity(Console.readString("Ingresar ciudad:"));

                                            if (!enterprise.getCity().equals("SALIR")) {
                                                enterprise.setAddress(Console.readString("Ingresar direccion:"));

                                                if (!enterprise.getAddress().equals("SALIR")) {
                                                    enterprise.setPostalCode(Validations.doUntilValidPostalCode(Console.readInt("Ingresar codigo postal:")));

                                                    if (enterprise.getPostalCode() != 0) {
                                                        enterpriseRepo.add(enterprise);
                                                        answer = true;

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
    public boolean changeEnterpriseUsername(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String username = Validations.doUntilUsernameIsNotInUse(Console.readString("Ingresar nuevo nombre de usuario:"));
        if (!username.equals("SALIR")){
            enterprise.setUsername(username);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterpriseEmail(int idEnterprise) {
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String email = Validations.doUntilEmailIsNotInUse(Validations.doUntilValidEmail(Console.readString("Ingresar nuevo correo electronico: ")));
        if (!email.equals("SALIR")) {
            enterprise.setEmail(email);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterprisePassword(int idEnterprise) {
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String password = Validations.doUntilPasswordValid(Console.enterPassword());
        if (!password.equals("SALIR")) {

            enterprise.setPassword(password);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }


        return answer;
    }

    public boolean changeEnterpriseFirstName(int idEnterprise) {
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String firstName = Validations.doUntilValidName(Console.readString("Ingresar nuevo nombre:"));
        if (!firstName.equals("SALIR")) {

            enterprise.setFirstName(firstName);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }


        return answer;
    }

    public boolean changeEnterpriseSurname(int idEnterprise) {
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String surname = Validations.doUntilValidName(Console.readString("Ingresar nuevo apellido:"));
        if (!surname.equals("SALIR")) {

            enterprise.setSurname(surname);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }


        return answer;
    }

    public boolean changeEnterpriseBirthDate(int idEnterprise) {
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String birthDate = Validations.doUntilValidBirthDate(Console.readString("Ingrese nueva fecha de nacimiento \n\nFormato: dd/MM/yyy\n"));
        if (!birthDate.equals("SALIR")) {

            enterprise.setBirthDate(birthDate);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }


        return answer;
    }

    public boolean changeEnterprisePhoneNumber(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        long phoneNumber = Validations.doUntilValidPhoneNumber(Console.readLong("Ingresar nuevo numero de celular (sin espacios):"));
        if (phoneNumber != 0) {
            enterprise.setPhoneNumber(phoneNumber);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterpriseNameEnterprise(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String fantasyName = Console.readString("Ingresar el nuevo nombre de la empresa:");
        if (!fantasyName.equals("SALIR")) {
            enterprise.setFantasyName(fantasyName);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterpriseProvince(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        int resp = Menu.provinceMenu(enterprise);
        if (resp != 0) {
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterpriseCity(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String city = Console.readString("Ingresar ciudad:");

        if (!city.equals("SALIR")) {
            enterprise.setCity(city);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterpriseAddress(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        String newAddres = Console.readString("Ingresar nueva direccion:");
        if (!newAddres.equals("SALIR")) {
            enterprise.setAddress(newAddres);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }

    public boolean changeEnterprisePostalCode(int idEnterprise){
        Enterprise enterprise = returnEnterpriseById(idEnterprise);
        boolean answer = false;

        int postalCode = Validations.doUntilValidPostalCode(Console.readInt("Ingresar nuevo codigo postal:"));

        if (postalCode != 0) {
            enterprise.setPostalCode(postalCode);
            enterpriseRepo.modify(enterprise);
            answer = true;
        }

        return answer;
    }
}
