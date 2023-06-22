package ModelsManager;
import javax.swing.JOptionPane;

import Enums.Province;
import Models.Administrator;
import Models.Buyer;
import Models.Enterprise;
import Models.Product;
import ModelsRepo.AdministratorRepo;
import ModelsRepo.BuyerRepo;
import Tools.Console;
import Tools.Menu;
import Tools.Validations;

import java.text.DateFormat;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class BuyerManager {

    class Validation {
        public boolean validateDate(String date) {
            boolean status = false;

            return status;
        }
    }

    BuyerRepo buyerRepo = new BuyerRepo();


    public void showBuyersList() {
        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               LISTA DE CUENTAS PERSONALES");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");
        List<Buyer> buyersList = buyerRepo.toList();

        for (int i = 0; i < buyersList.size(); i++) {
            System.out.println("ID:" + buyersList.get(i).getIdUser() + ". " + buyersList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public boolean addBuyer() {
        Buyer newBuyer = null;

        boolean answer = false;
        int idUser = buyerRepo.toList().size() + 1;

        String userName = Validations.doUntilUsernameIsNotInUse(Console.readString("Ingrese el nombre de usuario: "));

        if (!userName.equals("SALIR")) {

            String email = Validations.doUntilEmailIsNotInUse(Validations.doUntilValidEmail(Console.readString("Ingrese la direccion de email : ")));

            if (!email.equals("SALIR")) {

                String password = Validations.doUntilPasswordValid(Console.enterPassword());

                if (!password.equals("SALIR")) {

                    String firstName = Validations.doUntilValidName(Console.readString("Ingrese su nombre:"));
                    if (!firstName.equals("SALIR")) {

                        String surname = Validations.doUntilValidName(Console.readString("Ingrese el apellido"));

                        if (!surname.equals("SALIR")) {

                            int dni = Validations.doUntilPersonIsNotRegistred(Validations.doUntilValidDNI(Console.readInt("Ingrese su dni")));

                            if (dni != 0) {

                                String birthDate = Validations.doUntilValidBirthDate(Console.readString("Ingrese su fecha de nacimiento \n\nFormato: dd/MM/yyy\n"));
                                if (!birthDate.equals("SALIR")) {

                                    long phoneNumber = Validations.doUntilValidPhoneNumber(Console.readLong("Ingresar numero de celular (sin espacios):"));

                                    if (phoneNumber != 0) {
                                        newBuyer = new Buyer(idUser, userName, email, password, firstName, surname, dni, birthDate, phoneNumber);

                                        int resp = Menu.provinceMenu(newBuyer);
                                        if (resp != 0) {

                                            newBuyer.setCity(Console.readString("ingrese su ciudad"));
                                            if (!newBuyer.getCity().equals("SALIR")) {

                                                newBuyer.setAddress(Console.readString("ingrese su domicilio"));

                                                if (!newBuyer.getAddress().equals("SALIR")) {
                                                    newBuyer.setPostalCode(Validations.doUntilValidPostalCode(Console.readInt("ingrese su codigo postal")));
                                                    if (newBuyer.getPostalCode() != 0) {
                                                        buyerRepo.add(newBuyer);
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

    public boolean deleteLogicallyBuyer() {

        boolean delete = false;

        this.showBuyersList();
        int id = Validations.doUntilValidNumber(Console.readInt("Ingrese el id de la cuenta personal a dar de baja:"));

        if (searchUserById(id)) {

            Console.showMessage("Cuenta personal encontrada!");

            int answer = Console.buttonsYesNo();

            if (answer == 0) {
                Buyer buyer = returnBuyerById(id);
                buyer.setActive(false);
                this.buyerRepo.modify(buyer);
                delete = true;
            }

        } else {
            Console.showMessage("¡La cuenta personal no se encuentra registrada en el sistema!");
        }
        return delete;

    }

    public void removeBuyer() {
        int id = Console.readInt("Ingrese el id del compador a eliminar:");
        if (searchUserById(id)) {
            System.out.println("Comprador encontrado!");
            String resp = Console.readString("Esta seguro de continuar? si/no");
            if (resp.equals("si")) {
                buyerRepo.delete(id);
                System.out.println("El comprador se ha eliminado exitosamente!");
            }

        } else {
            System.out.println("El comprador no se encuentra registrado en el sistema!");
        }


    }

    public String modifyBuyerForAdm() {

        String optionEntered = "SALIR";

        this.showBuyersList();
        int id = Validations.doUntilValidNumber(Console.readInt("Ingrese el id de la cuenta a modificar:"));
        Buyer buyer = returnBuyerById(id);

        if (buyer != null) {

            Console.showMessage("Cuenta personal encontrada!");
            int answer = Console.buttonsModifyGeneralAndReturn();

            if (answer == 0) {
                optionEntered = Menu.menuModifyBuyer(buyer.getIdUser());  //se le asigna modificado si se modifico o salir
            }

        } else {
            Console.showMessage("¡La cuenta no se encuentra registrada en el sistema!");
        }

        return optionEntered;
    }

    public Boolean searchUserById(int id) {
        boolean resp = false;
        List<Buyer> buyers = buyerRepo.toList(); //trae stream desde el JSON

        for (Buyer buyer : buyers) {
            if (id == buyer.getIdUser()) {
                resp = true;
                break;
            }
        }
        return resp;

    }

    //Metodo nuevo -> By Ezequiel
    public boolean searchBuyerByUsername(String username) {
        for (Buyer buyer : this.buyerRepo.toList()) {
            if (buyer.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchBuyerByEmail(String email) {
        for (Buyer buyer : this.buyerRepo.toList()) {
            if (buyer.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchBuyerByDni(int dni) {
        for (Buyer buyer : this.buyerRepo.toList()) {
            if (buyer.getDni() == dni) {
                return true;
            }
        }
        return false;
    }

    //Metodo nuevo -> By Ezequiel
    public Buyer returnBuyerById(int id) {
        Buyer buyerWanted = null;

        for (Buyer buyer : this.buyerRepo.toList()) {
            if (buyer.getIdUser() == id) {
                buyerWanted = buyer;
                break;
            }
        }
        return buyerWanted;
    }

    //Metodo nuevo -> By Ezequiel
    public Buyer returnBuyerByUsername(String username) {
        Buyer buyerWanted = null;

        for (Buyer buyer : this.buyerRepo.toList()) {
            if (buyer.getUsername().equals(username)) {
                buyerWanted = buyer;
                break;
            }
        }
        return buyerWanted;
    }

    public void modifyUser() {

        int idBuyer = Console.readInt("Ingrese el id del usuario que desea modificar:");

        if (searchUserById(idBuyer)) {
            String userName = Console.readString("Ingrese el nuevo nombre de usuario");
            String email = Console.readString("Ingrese el nuevo email");
            String password = Console.readString("Ingrese la nueva contrasena");
            String firstName = Console.readString("Ingrese el nuevo nombre");
            String surname = Console.readString("Ingrese el nuevo apellido");
            String birthDate = Console.readString("Ingrese la nueva fecha de nacimiento");
            int phoneNumber = Console.readInt("Ingrese el nuevo numero de telefono");
            boolean active = true;
            String province = Console.readString("Ingrese la nueva provincia");
            String city = Console.readString("Ingrese la nueva ciudad");
            String adress = Console.readString("Ingrese la nueva direccion");

            Buyer modifierUser = buyerRepo.toList().get(idBuyer);

            modifierUser.setUsername(userName);
            modifierUser.setEmail(email);
            modifierUser.setPassword(password);
            modifierUser.setFirstName(firstName);
            modifierUser.setSurname(surname);
            //modifierUser.setBirthDate(birthDate);
            modifierUser.setPhoneNumber(phoneNumber);
            //modifierUser.setProvince(province);
            modifierUser.setCity(city);
            modifierUser.setAddress(adress);

            buyerRepo.modify(modifierUser);

            System.out.println("Usuario modificado con exito!");

        }

    }
    public void replaceBuyer(Buyer buyerToReplace){
        buyerRepo.modify(buyerToReplace);
    }

    public boolean totalModifyOneBuyer(int idBuyer) {
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

                                    Buyer buyer = new Buyer(idBuyer, username, email, password,
                                            firstName, surname, birthDate, phoneNumber);

                                    int resp = Menu.provinceMenu(buyer);
                                    if (resp != 0) {
                                        buyer.setCity(Console.readString("Ingresar ciudad:"));

                                        if (!buyer.getCity().equals("SALIR")) {
                                            buyer.setAddress(Console.readString("Ingresar direccion:"));

                                            if (!buyer.getAddress().equals("SALIR")) {
                                                buyer.setPostalCode(Validations.doUntilValidPostalCode(Console.readInt("Ingresar codigo postal:")));

                                                if (buyer.getPostalCode() != 0) {
                                                    buyerRepo.modify(buyer);
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

        return answer;
    }

    public boolean changeBuyerUsername(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String username = Validations.doUntilUsernameIsNotInUse(Console.readString("Ingresar nuevo nombre de usuario:"));
        if (!username.equals("SALIR")) {
            buyer.setUsername(username);
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;
    }

    public boolean changeBuyerEmail(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String email = Validations.doUntilEmailIsNotInUse(Validations.doUntilValidEmail(Console.readString("Ingresar nuevo correo electronico: ")));
        if (!email.equals("SALIR")) {
            buyer.setEmail(email);
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;
    }

    public boolean changeBuyerPassword(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String password = Validations.doUntilPasswordValid(Console.enterPassword());
        if (!password.equals("SALIR")) {

            buyer.setPassword(password);
            buyerRepo.modify(buyer);
            answer = true;
        }


        return answer;
    }

    public boolean changeBuyerFirstName(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String firstName = Validations.doUntilValidName(Console.readString("Ingresar nuevo nombre:"));
        if (!firstName.equals("SALIR")) {

            buyer.setFirstName(firstName);
            buyerRepo.modify(buyer);
            answer = true;
        }


        return answer;
    }

    public boolean changeBuyerSurname(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String surname = Validations.doUntilValidName(Console.readString("Ingresar nuevo apellido:"));
        if (!surname.equals("SALIR")) {

            buyer.setSurname(surname);
            buyerRepo.modify(buyer);
            answer = true;
        }


        return answer;
    }

    public boolean changeBuyerBirthDate(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String birthDate = Validations.doUntilValidBirthDate(Console.readString("Ingrese nueva fecha de nacimiento \n\nFormato: dd/MM/yyy\n"));
        if (!birthDate.equals("SALIR")) {

            buyer.setBirthDate(birthDate);
            buyerRepo.modify(buyer);
            answer = true;
        }


        return answer;
    }

    public boolean changeBuyerPhoneNumber(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        long phoneNumber = Validations.doUntilValidPhoneNumber(Console.readLong("Ingresar nuevo numero de celular (sin espacios):"));
        if (phoneNumber != 0) {
            buyer.setPhoneNumber(phoneNumber);
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;
    }


    public boolean changeBuyerProvince(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        int resp = Menu.provinceMenu(buyer);
        if (resp != 0) {
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;
    }

    public boolean changeBuyerCity(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String city = Console.readString("Ingresar ciudad:");

        if (!city.equals("SALIR")) {
            buyer.setCity(city);
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;
    }

    public boolean changeBuyerAddress(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        String newAddres = Console.readString("Ingresar nueva direccion:");
        if (!newAddres.equals("SALIR")) {
            buyer.setAddress(newAddres);
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;
    }

    public boolean changeBuyerPostalCode(int idBuyer) {
        Buyer buyer = returnBuyerById(idBuyer);
        boolean answer = false;

        int postalCode = Validations.doUntilValidPostalCode(Console.readInt("Ingresar nuevo codigo postal:"));

        if (postalCode != 0) {
            buyer.setPostalCode(postalCode);
            buyerRepo.modify(buyer);
            answer = true;
        }

        return answer;


    }
    public void changeSaldoBuyer(Buyer buyer) {
            buyerRepo.modify(buyer);


    }

}
