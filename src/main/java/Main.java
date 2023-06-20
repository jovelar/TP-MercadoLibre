import ModelsManager.AdministratorManager;
import Tools.Console;

public class Main {
    public static void main(String[] args) {

        SalesSystem salesSystem = new SalesSystem();

        salesSystem.getProductManager().showSaleProducts();

        //menu principal
        String opcion;

        do {
            opcion = Console.systemOptions();

            switch (opcion) {
                case "CREAR CUENTA":
                    // Acciones para la opción 1
                    System.out.println("Ha seleccionado la opción 1.");
                    break;
                case "INGRESAR":
                    // Acciones para la opción 2
                    System.out.println("Ha seleccionado la opción 2.");
                    break;
                case "MIS COMPRAS":
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case "CARRITO":
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 4.");
                    break;
                case "VER PRODUCTO":
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 5.");
                    break;
                case "VER TODOS LOS PRODUCTOS":
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 6.");
                    break;
                case "VER CATEGORIAS":
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 7.");
                    break;
                case "SALIR":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while(!opcion.equals("SALIR"));

    }

//        productManager.listaProductosHardcodeado(); //cargue el archivo productos.json con los productos hardcodeados
//        Menu.menuAdmProductos();

//        mainEzequiel();


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