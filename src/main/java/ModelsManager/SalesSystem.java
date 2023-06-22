package ModelsManager;

import Enums.TypeUser;
import Models.Administrator;
import Models.Enterprise;
import Models.User;
import Tools.Console;

import java.lang.reflect.Type;


public class SalesSystem {

    //region ATTRIBUTES
    private static final AdministratorManager administratorManager = new AdministratorManager();
    private static final BuyerManager buyerManager = new BuyerManager();
    private static final CardManager cardManager = new CardManager();
    private static final EnterpriseManager enterpriseManager = new EnterpriseManager();
    private static final OrderManager orderManager = new OrderManager();
    private static final ProductManager productManager = new ProductManager();



    //endregion

    //region GETTERS AND SETTERS
    public static AdministratorManager getAdministratorManager() {
        return administratorManager;
    }

    public static BuyerManager getBuyerManager() {
        return buyerManager;
    }

    public static CardManager getCardManager() {
        return cardManager;
    }

    public static EnterpriseManager getEnterpriseManager() {
        return enterpriseManager;
    }

    public static OrderManager getOrderManager() {
        return orderManager;
    }

    public static ProductManager getProductManager() {
        return productManager;
    }
    //endregion

    public static void createAccount(){
        int resp = Console.systemOptionsCreateAccount()+1;
        boolean answer = false;
        if(resp == 1){
            answer = buyerManager.addBuyer();

        }else if(resp == 2){
            answer = enterpriseManager.addEnterprise();

        }

        if(answer){
            Console.showMessage("¡CUENTA CREADA EXITOSAMENTE!");
        }else{
            Console.showMessage("Volviendo al menu principal...");
        }


    }

    //region LOGIN
    public static boolean logIn(StringBuilder username) {

        StringBuilder password = new StringBuilder();
        boolean loginSuccessful = false;
        String optionEntered = "NO_SALIR";
        int failedAttempts = 0;

        while(!loginSuccessful && failedAttempts<3 && !optionEntered.equals("SALIR")) {

            optionEntered = readloginData(username, password);
            if(!optionEntered.equals("SALIR")) {

                //Tengo que buscar en los 3 archivos que tipo de usuario esta ingresando
                loginSuccessful = validateLogin(username.toString(), password.toString());

                if(!loginSuccessful) {
                    failedAttempts++;
                    Console.showMessageError("¡ALGUNO DE LOS DATOS INGRESADOS ES INCORRECTO! (" + failedAttempts+")");
                }
            }
        }

        if(optionEntered.equals("SALIR") || failedAttempts==3) {

            if(failedAttempts == 3)
                Console.showMessageError("Volviendo al menu principal...");

        }

        return loginSuccessful;
    }

    private static String readloginData(StringBuilder username, StringBuilder password) {

        String optionOrDateEntered = Console.readString("Ingrese su nombre de usuario");

        if(!optionOrDateEntered.equals("SALIR")) {
            username.setLength(0);
            username.append(optionOrDateEntered);

            optionOrDateEntered = Console.readString("Ingrese su contraseña");

            if(!optionOrDateEntered.equals("SALIR")) {
                password.setLength(0);
                password.append(optionOrDateEntered);

                optionOrDateEntered = "NO_SALIR"; //Para no retornar la password
            }
        }

        return optionOrDateEntered;
    }

    private static boolean validateLogin(String username, String password) {

        boolean loginSuccessful = false;
        boolean correctPassword = false;

        boolean userFound = searchUsername(username);

        if(userFound)
            correctPassword = validatePassword(username, password);

        if(userFound && correctPassword)
            loginSuccessful = true;

        return loginSuccessful;
    }

    public static boolean searchUsername(String username) {

        boolean userFound = false;

        userFound = administratorManager.searchAdministratorByUsername(username);

        if(!userFound){

            userFound = enterpriseManager.searchEnterpriseByUsername(username);

            if(!userFound) {
                userFound = buyerManager.searchBuyerByUsername(username);
            }
        }

        return userFound;
    }

    private static boolean validatePassword(String username, String password) {

        String passwordUserFound = "";
        boolean validKey = false;

        boolean userFound = administratorManager.searchAdministratorByUsername(username);

        if(!userFound){

            userFound = enterpriseManager.searchEnterpriseByUsername(username);

            if(!userFound) {
                userFound = buyerManager.searchBuyerByUsername(username);

                if(userFound) {
                    passwordUserFound = buyerManager.returnBuyerByUsername(username).getPassword();
                }

            } else {
                 passwordUserFound = enterpriseManager.returnEnterpriseByUsername(username).getPassword();
            }

        } else {
             passwordUserFound = administratorManager.returnAdministratorByUsername(username).getPassword();
        }

        if(userFound) {
            validKey = passwordUserFound.equals(password);
        }

        return validKey;
    }
    //endregion

    public static boolean searchEmail(String email) {

        boolean emailFound = false;

        emailFound = administratorManager.searchAdministratorByEmail(email);

        if(!emailFound){

            emailFound = enterpriseManager.searchEnterpriseByEmail(email);

            if(!emailFound) {
                emailFound = buyerManager.searchBuyerByEmail(email);
            }
        }

        return emailFound;
    }

    public static boolean searchDni(int dni) {

        boolean dniFound = false;

        dniFound = administratorManager.searchAdministratorByDni(dni);

        if(!dniFound){

            dniFound = enterpriseManager.searchEnterpriseByDni(dni);

            if(!dniFound) {
                dniFound = buyerManager.searchBuyerByDni(dni);
            }
        }

        return dniFound;
    }

    public static TypeUser userConnectProgram(User user) {

        TypeUser typeUser = returnTypeUserByUsername(user.getUsername());

        if(typeUser != TypeUser.NONE) {
            if(typeUser == TypeUser.ADMINISTRATOR) {
                user = administratorManager.returnAdministratorByUsername(user.getUsername());
            } else if(typeUser == TypeUser.ENTERPRISE) {
                user = enterpriseManager.returnEnterpriseByUsername(user.getUsername());
            } else {
                user = buyerManager.returnBuyerByUsername(user.getUsername());
            }
        }

        return typeUser;
    }

    public static TypeUser returnTypeUserByUsername(String username) {

        TypeUser typeUser = TypeUser.NONE;
        boolean userFound = administratorManager.searchAdministratorByUsername(username);

        if(!userFound){

            userFound = enterpriseManager.searchEnterpriseByUsername(username);

            if(!userFound) {
                userFound = buyerManager.searchBuyerByUsername(username);

                if(userFound) {
                    typeUser = TypeUser.BUYER;
                }

            } else {
                typeUser = TypeUser.ENTERPRISE;
            }

        } else {
            typeUser = TypeUser.ADMINISTRATOR;
        }

        return typeUser;
    }



}
