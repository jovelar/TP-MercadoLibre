import Models.Administrator;
import ModelsManager.AdministratorManager;
import ModelsManager.EnterpriseManager;

public class Main {
    public static void main(String[] args) {

//        productManager.listaProductosHardcodeado(); //cargue el archivo productos.json con los productos hardcodeados
        //Menu.menuAdmProductos();

        mainEzequiel();
    }

    public static void mainEzequiel() {

        /*EnterpriseManager enterpriseManager = new EnterpriseManager();
        enterpriseManager.totalModifyEnterprise();*/

        AdministratorManager administratorManager = new AdministratorManager();
        //administratorManager.addAministrator();
        //administratorManager.deleteLogicallyAdminsitrator();
        //administratorManager.deleteAdministrator();
        administratorManager.totalModifyAdministrator();
    }



}