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
}
