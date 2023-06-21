package ModelsManager;

import ModelsManager.*;
import Tools.Console;

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
            enterpriseManager.addEnterprise();

        }

        if(answer){
            Console.showMessage("¡CUENTA CREADA EXITOSAMENTE!");
        }else{
            Console.showMessageError("ERROR AL CREAR CUENTA, INTENTE NUEVAMENTE");
        }
        //retorne si se creo la cuenta exitosamente

    }

    public static boolean logIn() {

        boolean loginSuccessful = false;

        String username = Console.readString("Ingrese su nombre de usuario");
        String password = Console.readString("Ingrese su contraseña");

        //Tengo que buscar en todas las bases de datos que tipo de usuario es

        return loginSuccessful;
    }

    public static boolean validateLogin(String username, String password) {

        boolean loginSuccessful = false;
        boolean correctPassword = false;

        boolean userFound = searchUsername(username);

        if(userFound) {
            correctPassword = validatePassword(username, password);
        }

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


    public static boolean validatePassword(String username, String password) {

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

}
