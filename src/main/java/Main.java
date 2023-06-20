
import ModelsManager.ProductManager;
import Tools.Console;
import Tools.Menu;
import Tools.Validations;

import java.util.Scanner;
import ModelsManager.AdministratorManager;
import Tools.Console;


public class Main {
    public static void main(String[] args) {
/*
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
*/
        //mainEzequiel();
        mainJOvelar();
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
    public static void mainJOvelar(){
        Validations validation=new Validations();
        /*String manzana="25/02/2014";
        System.out.println(validation.validateBirthDate(manzana));
         */
        String nombre1="jose maria listorti";
        String nombre2="Abaco 123 ";
        String nombre3=".*.------=";

        //System.out.println(validation.validateName(nombre1));
        //System.out.println(validation.validateName(nombre2));
        //System.out.println(validation.validateName(nombre3));
        String kopona=validation.doUntilValidName(Console.readString("Ingrese su nombre"));
    }
}