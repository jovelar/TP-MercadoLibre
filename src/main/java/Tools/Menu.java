package Tools;

import Enums.Category;
import Models.Product;
import ModelsManager.ProductManager;

import java.util.Scanner;

public class Menu {

    //region MENU PRINCIPAL
    public static void menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = scan.nextInt();
            scan.reset();
            menuPrincipalOpciones(opcion);


        }while(opcion != 4);


    }

    public static void mostrarMenuPrincipal(){
        System.out.println("Menú Principal");
        System.out.println("1. Administrar Clientes");
        System.out.println("2. Administrar Productos");
        System.out.println("3. Sistema de Venta");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void menuPrincipalOpciones(int opcion){

        System.out.println("");
        switch (opcion) {
            case 1:
                menuAdmClientes();
                break;
            case 2:
                menuAdmProductos();
                break;
            case 3:
                menuVentas();

                break;
            case 4:
                System.out.println("¡Gracias por utilizar este programa!");

                break;
            default:
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                break;
        }

    }

    //endregion

    //region MENU BUYERS
    public static void menuAdmClientes(){
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuAdmClientes();
            opcion = scan.nextInt();
            scan.reset();
            menuAdmClientesOpciones(opcion);


        }while(opcion != 5);


    }

    public static void mostrarMenuAdmClientes(){
        System.out.println("Administrar Clientes");
        System.out.println("1. Agregar Clientes");
        System.out.println("2. Eliminar Clientes");
        System.out.println("3. Modificar Clientes");
        System.out.println("4. Mostrar Clientes");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void menuAdmClientesOpciones(int opcion){

//        GestionClientes gestionClientes = new GestionClientes();
        switch (opcion) {
            case 1:
                System.out.println("");
                System.out.println("Agregar Clientes");
//                gestionClientes.agregarCliente();
                break;
            case 2:
                System.out.println("");
                System.out.println("Eliminar Clientes");
//                gestionClientes.eliminarCliente();
                break;
            case 3:
                System.out.println("");
                System.out.println("Modificar Clientes");

                break;
            case 4:
                System.out.println("");
                System.out.println("Ver Clientes");
//                gestionClientes.mostrarListaClientes();

                break;

            case 5:
                System.out.println("¡Gracias por utilizar este programa!");

                break;
            default:
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                break;
        }

    }

    //endregion

    //region MENU PRODUCTOS
    public static void menuAdmProductos(){
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuAdmProductos();
            opcion = scan.nextInt();
            scan.reset();
            menuAdmProductosOpciones(opcion);


        }while(opcion != 5);


    }

    public static void mostrarMenuAdmProductos(){
        System.out.println("Administrar Productos");
        System.out.println("1. Agregar Productos");
        System.out.println("2. Eliminar Productos");
        System.out.println("3. Modificar Productos");
        System.out.println("4. Mostrar Productos");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void menuAdmProductosOpciones(int opcion){
        ProductManager productManager = new ProductManager();
        switch (opcion) {
            case 1:
                System.out.println("");
                System.out.println("Agregar Productos");
                productManager.addProduct();
                break;
            case 2:
                System.out.println("");
                System.out.println("Eliminar Productos");
                productManager.removeProduct();
                break;
            case 3:
                System.out.println("");
                System.out.println("Modificar Productos");
                productManager.modifyProduct();

                break;
            case 4:
                System.out.println("");
                System.out.println("Ver Productos");
                productManager.showProductList();

                break;

            case 5:
                System.out.println("Volviendo al menu principal...");

                break;
            default:
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                break;
        }

    }

    //endregion

    //region MENU SISTEMA DE VENTAS
    public static void menuVentas(){
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuVentas();
            opcion = scan.nextInt();
            scan.reset();
            menuVentasOpciones(opcion);


        }while(opcion != 5);


    }

    public static void mostrarMenuVentas(){
        System.out.println("Sistema de ventas");
        System.out.println("1. Comprar producto");
        System.out.println("2. buscar producto");
        System.out.println("3. ver productos");
        System.out.println("4. ..");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void menuVentasOpciones(int opcion){
//        GestionProductos gestionProductos = new GestionProductos();
//        GestionClientes gestionClientes = new GestionClientes();

        /*Como esto es un software de prueba, solo se va a vender un tipo de producto a la
vez. Para poder vender un producto se necesita al cliente, el producto y la cantidad
a vender. Cuando se vende el producto se tiene que descontar del stock la cantidad
vendida (se tiene que actualizar el json en cada venta).
*/
        switch (opcion) {
            case 1:
                System.out.println("");
                System.out.println("Comprar producto");
//                Cliente cliente1 = gestionClientes.ObtenerClientePorDni("41386329");
//                gestionProductos.venderFrutas("1", 5, cliente1);

                break;
            case 2:
                System.out.println("");

                break;
            case 3:
                System.out.println("");


                break;
            case 4:
                System.out.println("");

                break;

            case 5:
                System.out.println("¡Gracias por utilizar este programa!");

                break;
            default:
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                break;
        }

    }

    //endregion

    //region CategoriesMenu
    public static void categoriesMenu(Product product){
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            showCategoriesMenu();
            opcion = scan.nextInt();
            scan.reset();
            optionsCategoryMenu(product, opcion);


        }while(opcion < 1 && opcion > 5);


    }

    public static void showCategoriesMenu(){
        System.out.println("Elija una categoria");
        System.out.println("1. Tecnologia");
        System.out.println("2. Ropa");
        System.out.println("3. Vehiculos");
        System.out.println("4. Supermercado");
        System.out.print("Selecciona una opción: ");
    }

    public static void optionsCategoryMenu(Product product, int opcion){

        switch (opcion) {
            case 1->product.setCategory(Category.TECHNOLOGY);
            case 2->product.setCategory(Category.FASHION);
            case 3->product.setCategory(Category.VEHICLES);
            case 4->product.setCategory(Category.SUPERMARKET);
            default->System.out.println("Opción inválida. Por favor, selecciona una opción válida.");

        }

    }
    //endregion
}
