import ModelsManager.AdmManager;
import ModelsManager.EnterpriseManager;
import ModelsManager.ProductManager;
import Tools.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        productManager.listaProductosHardcodeado(); //cargue el archivo productos.json con los productos hardcodeados
        //Menu.menuAdmProductos();

        mainEzequiel();
    }

    public static void mainEzequiel() {

        EnterpriseManager enterpriseManager = new EnterpriseManager();

        enterpriseManager.totalModifyEnterprise();
        
    }



}