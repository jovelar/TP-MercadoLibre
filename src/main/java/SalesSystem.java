import ModelsManager.*;
import Tools.Console;

public final class SalesSystem {

    //region ATTRIBUTES
    private AdministratorManager administratorManager = new AdministratorManager();
    private BuyerManager buyerManager = new BuyerManager();
    private CardManager cardManager = new CardManager();
    private EnterpriseManager enterpriseManager = new EnterpriseManager();
    private OrderManager orderManager = new OrderManager();
    private ProductManager productManager = new ProductManager();
    //endregion

    //region GETTERS AND SETTERS
    public AdministratorManager getAdministratorManager() {
        return administratorManager;
    }

    public void setAdministratorManager(AdministratorManager administratorManager) {
        this.administratorManager = administratorManager;
    }

    public BuyerManager getBuyerManager() {
        return buyerManager;
    }

    public void setBuyerManager(BuyerManager buyerManager) {
        this.buyerManager = buyerManager;
    }

    public CardManager getCardManager() {
        return cardManager;
    }

    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }

    public EnterpriseManager getEnterpriseManager() {
        return enterpriseManager;
    }

    public void setEnterpriseManager(EnterpriseManager enterpriseManager) {
        this.enterpriseManager = enterpriseManager;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }

    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
    //endregion

    public void createAccount(){
        int resp = Console.systemOptionsCreateAccount()+1;
        if(resp == 1){
            //verificar si ya tiene cuenta
            //cuando agrega su mail
            //
        }else if(resp == 2){

        }
    }

    public void logIn() {

        boolean loginSuccessful = false;

        String username = Console.readString("Ingrese su nombre de usuario");
        String password = Console.readString("Ingrese su contraseña");

        //Tengo que buscar en todas las bases de datos que tipo de usuario es

    }

   /* public boolean validateLogin(String username, String password) {

        boolean loginSuccessful = false;
        boolean correctPassword = false;

        boolean userFound = searchUsername(username);

        if(userFound) {
            correctPassword = validatePassword(username, password);
        }

        return
    }*/
    public boolean searchUsername(String username) {

        boolean userFound = false;

        userFound = this.administratorManager.searchAdministratorByUsername(username);

        if(!userFound){

            userFound = this.enterpriseManager.searchEnterpriseByUsername(username);

            if(!userFound) {
                userFound = this.buyerManager.searchBuyerByUsername(username);
            }
        }

        return userFound;
    }

    public boolean validatePassword(String username, String password) {

        String passwordUserFound = "";
        boolean validKey = false;

        boolean userFound = this.administratorManager.searchAdministratorByUsername(username);

        if(!userFound){

            userFound = this.enterpriseManager.searchEnterpriseByUsername(username);

            if(!userFound) {
                userFound = this.buyerManager.searchBuyerByUsername(username);

                if(userFound) {
                    passwordUserFound = this.buyerManager.returnBuyerByUsername(username).getPassword();
                }

            } else {
                 passwordUserFound = this.enterpriseManager.returnEnterpriseByUsername(username).getPassword();
            }

        } else {
             passwordUserFound = this.administratorManager.returnAdministratorByUsername(username).getPassword();
        }

        if(userFound) {
            validKey = passwordUserFound.equals(password);
        }

        return validKey;
    }

}
