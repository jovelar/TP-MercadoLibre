package ModelsManager;

import Enums.TypeUser;
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
        if(resp == 1){ //elige cuenta personal
            //verificar si ya tiene cuenta
            //cuando agrega su mail
            //
        }else if(resp == 2){//elige cuenta empresa
            //TODO validar que el correo no exista en la base de datos, ni el dni, ni el nombreusuario,ni el telefono

        }
    }

    //region LOGIN
    public static boolean logIn(String username) {

        String password = "";
        boolean loginSuccessful = false;
        String optionEntered = "NO_SALIR";
        int failedAttempts = 0;

        while(!loginSuccessful && failedAttempts<3 && !optionEntered.equals("SALIR")) {

            //Se leen los datos username y password, se carga en el usuario vacio
            //Detecta si se ingreso "SALIR" oprimiendo el boton "cancelar" o la "X"
            optionEntered = readloginData(username, password);

            if(!optionEntered.equals("SALIR")) {

                //Tengo que buscar en los 3 archivos que tipo de usuario esta ingresando
                loginSuccessful = validateLogin(username, password);

                if(!loginSuccessful) {
                    failedAttempts++;
                    Console.showMessageError("¡ALGUNO DE LOS DATOS INGRESADOS ES INCORRECTO!" + failedAttempts);
                }
            }
        }

        return loginSuccessful;
    }

    private static String readloginData(String username, String password) {

        String optionOrDateEntered = Console.readString("Ingrese su nombre de usuario");

        if(!optionOrDateEntered.equals("SALIR")) {
            username = optionOrDateEntered;

            optionOrDateEntered = Console.readString("Ingrese su contraseña");

            if(!optionOrDateEntered.equals("SALIR")) {
                password = optionOrDateEntered;
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
