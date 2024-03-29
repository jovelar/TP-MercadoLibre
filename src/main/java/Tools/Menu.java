package Tools;

import Enums.Category;
import Enums.Province;

import Enums.TypeUser;
import Models.Administrator;
import Models.Client;
import Models.Enterprise;
import Models.Product;
import ModelsManager.ProductManager;
import ModelsManager.SalesSystem;

import java.util.ArrayList;
import java.util.Scanner;

public final class Menu {

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
        int opcion;

        do {
            mostrarMenuAdmProductos();
            opcion = Console.readInt("Selecciona una opción: ");
            menuAdmProductosOpciones(opcion);


        }while(opcion != 7);


    }

    public static void mostrarMenuAdmProductos(){
        System.out.println("Administrar Productos");
        System.out.println("1. Agregar Productos");
        System.out.println("2. Eliminar Productos");
        System.out.println("3. Modificar Productos");
        System.out.println("4. Mostrar Productos");
        System.out.println("5. Mostrar Productos por empresa");
        System.out.println("6. Mostrar Productos en oferta");
        System.out.println("7. Salir");
    }

    public static void menuAdmProductosOpciones(int opcion){
        ProductManager productManager = new ProductManager();
        switch (opcion) {
            case 1:
                System.out.println("Agregar Productos");
                //productManager.addProduct();
                break;
            case 2:
                System.out.println("Eliminar Productos");
                productManager.removeProduct();
                break;
            case 3:
                System.out.println("Modificar Productos");
                productManager.modifyProduct();

                break;
            case 4:
                System.out.println("Ver Productos");
                System.out.println("---------------------------------------------------------");
                productManager.showProductList();

                break;

            case 5:
                System.out.println("Ver Productos por id Empresa");
                System.out.println("---------------------------------------------------------");
                int id = Console.readInt("Ingrese el id de la empresa que desea ver los productos:");
                productManager.showProductListbyIDEnterprise(id);

                break;
            case 6:
                System.out.println("Ver Productos en oferta!");
                System.out.println("---------------------------------------------------------");
                productManager.showSaleProducts();

                break;
            case 7:
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
        int opcion;

        do {
            showCategoriesMenu();
            opcion = Console.readInt("Seleccione una opcion:");
            optionsCategoryMenu(product, opcion);
        }while(opcion < 1 || opcion > 5);
    }

    public static void showCategoriesMenu(){
        System.out.println("Elija una categoria");

        System.out.println("1. Tecnologia");
        System.out.println("2. Ropa");
        System.out.println("3. Vehiculos");
        System.out.println("4. Supermercado");

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

    //region PROVINCES MENU -> Aqui hay 2 metodos genericos, para las clases BUYER y ENTERPRISE
    public static <T extends Client> int provinceMenu(T cliente){
        int opcion = 0;

        do {
            showProvinceOptionsMenu();
            opcion = Console.readInt("Seleccione una opción [1 - 24]");
            assignProvince(cliente, opcion);

        }while(opcion < 0 || opcion > 24);
        return opcion;
    }

    public static void showProvinceOptionsMenu(){
        System.out.println("Elija una provincia\n");

        System.out.println("[1]  Buenos Aires");
        System.out.println("[2]  Ciudad Autonoma de Bs As");
        System.out.println("[3]  Catamarca");
        System.out.println("[4]  Chaco");
        System.out.println("[5]  Chubut");
        System.out.println("[6]  Córdoba");
        System.out.println("[7]  Corrientes");
        System.out.println("[8]  Entre Ríos");
        System.out.println("[9]  Formosa");
        System.out.println("[10] Jujuy");
        System.out.println("[11] La Pampa");
        System.out.println("[12] La Rioja");
        System.out.println("[13] Mendoza");
        System.out.println("[14] Misiones");
        System.out.println("[15] Neuquén");
        System.out.println("[16] Río Negro");
        System.out.println("[17] Salta");
        System.out.println("[18] San Juan");
        System.out.println("[19] San Luis");
        System.out.println("[20] Santa Cruz");
        System.out.println("[21] Santa Fe");
        System.out.println("[22] Santiago del Estero");
        System.out.println("[23] Tierra del Fuego");
        System.out.println("[24] Tucumán");
    }

    public static <T extends Client> void assignProvince(T cliente, int opcion){

        switch (opcion) {
            case 1 -> cliente.setProvince(Province.BSAS);
            case 2 -> cliente.setProvince(Province.CABA);
            case 3 -> cliente.setProvince(Province.CATAMARCA);
            case 4 -> cliente.setProvince(Province.CHACO);
            case 5 -> cliente.setProvince(Province.CHUBUT);
            case 6 -> cliente.setProvince(Province.CORDOBA);
            case 7 -> cliente.setProvince(Province.CORRIENTES);
            case 8 -> cliente.setProvince(Province.ENTRERIOS);
            case 9 -> cliente.setProvince(Province.FORMOSA);
            case 10 -> cliente.setProvince(Province.JUJUY);
            case 11 -> cliente.setProvince(Province.LAPAMPA);
            case 12 -> cliente.setProvince(Province.LARIOJA);
            case 13 -> cliente.setProvince(Province.MENDOZA);
            case 14 -> cliente.setProvince(Province.MISIONES);
            case 15 -> cliente.setProvince(Province.NEUQUEN);
            case 16 -> cliente.setProvince(Province.RIONEGRO);
            case 17 -> cliente.setProvince(Province.SALTA);
            case 18 -> cliente.setProvince(Province.SANJUAN);
            case 19 -> cliente.setProvince(Province.SANLUIS);
            case 20 -> cliente.setProvince(Province.SANTACRUZ);
            case 21 -> cliente.setProvince(Province.SANTAFE);
            case 22 -> cliente.setProvince(Province.SANTIAGODELESTERO);
            case 23 -> cliente.setProvince(Province.TIERRADELFUEGO);
            case 24 -> cliente.setProvince(Province.TUCUMAN);
            case -1 -> System.out.println(" ");//cuando ingresa un valor no entero o una letra
            case 0 -> System.out.println(" ");////cuando se oprime cancelar o la cruz(X), se retorno 0 en el metodo anterior
            default->Console.showMessage("\t\t¡OPCION INVALIDA! \n\nPor favor, selecciona una opción disponible...\n");
        }
    }
    //endregion

    public static String enterpriseMainMenu(String username) {

        Enterprise enterprise = SalesSystem.getEnterpriseManager().returnEnterpriseByUsername(username);
        String optionEntered;
        String returnedOption;
        ArrayList<Product> myProductsList;

        //menu principal
        do {

            //TODO: mostras productos del enterprise
            myProductsList = SalesSystem.getProductManager().returnListOfProductsByID(enterprise.getMyProducts());
            enterprise.showMyProducts(myProductsList);

            optionEntered = Console.systemOptionsEnterprise();

            switch (optionEntered) {

                case "VER MI PERFIL"://region
                    enterprise.viewProfile();

                    int answer = Console.buttonsModifyAndReturn();

                    if(answer == 0){
                        returnedOption = Menu.menuModifyEnterprise(enterprise.getIdUser());
                        if(returnedOption.equals("MODIFICADO")){
                            enterprise = SalesSystem.getEnterpriseManager().returnEnterpriseById(enterprise.getIdUser());
                            enterprise.viewProfile();
                            username = enterprise.getUsername();
                        }
                    }

                    Console.showMessage("Volviendo al menu principal...");
                    break;//endregion

                case "AGREGAR PRODUCTO"://region
                    enterprise.addProduct();
                    break;//endregion
                case "MODIFICAR PRODUCTO"://region
                    enterprise.editProduct();
                    break;
                /*case "DAR DE BAJA UN PRODUCTO"://region
                    enterprise.deleteProduct();
                    break;*/
                /*case "DAR DE BAJA MI CUENTA"://region
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;*/
                case "SALIR":
                    Console.showMessage("Saliendo del programa...");//region
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while(!optionEntered.equals("SALIR"));

        return optionEntered;
    }

    public static String administratorMainMenu(String username) { //TODO falta probar este menu

            Administrator administrator;
            String optionEntered;
            String returnedOption;
            boolean success;
            do {
                optionEntered = Console.systemOptionsAdministrator();

                administrator = SalesSystem.getAdministratorManager().returnAdministratorByUsername(username);
                switch (optionEntered) {

                    //region
                    case "VER MI PERFIL":
                        administrator.viewProfile();

                        int answer = Console.buttonsModifyAndReturn();

                        if (answer == 0) {
                            returnedOption = Menu.menuModifyAdministrator(administrator.getIdUser());
                            if (returnedOption.equals("MODIFICADO")) {
                                administrator = SalesSystem.getAdministratorManager().returnAdministratorById(administrator.getIdUser());
                                administrator.viewProfile();
                                username = administrator.getUsername();
                            }
                        }

                        Console.showMessage("Volviendo al menu principal...");
                        break;
                    case "ADMINISTRAR EMPRESAS":

                        enterpriseABMLmenu(); //TODO probar

                        break;
                    case "ADMINISTRAR CLIENTES":
                        buyerABMLmenu(); //TODO probar

                        break;

                    case "AGREGAR ADMINISTRADORES":
                        success = SalesSystem.getAdministratorManager().addAministrator();
                        if (success) {
                            Console.showMessage("¡Cuenta ADMINISTRADOR creada con exito!");
                        }
                        break;

                    case "MOSTRAR ADMINISTRADORES":
                        SalesSystem.getAdministratorManager().showAdministratorsList();
                        break;
                    case "DAR DE BAJA MI CUENTA":
                        success = SalesSystem.getAdministratorManager().cancelAnAccountAdm(administrator.getIdUser());
                        if (success) {
                            Console.showMessage("¡Su cuenta ADMINISTRADOR se dio de baja exitosamente!");
                            optionEntered = "SALIR";
                        }
                        break;

                    case "SALIR":
                        Console.showMessage("GRACIAS POR UTILIZAR ESTE PROGRAMA!");
                        break;
                    default:
                        Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                        break;
                }

            } while (!optionEntered.equals("SALIR"));
            return optionEntered;
        }

    public static void enterpriseABMLmenu () {
        boolean answer;
        String optionEntered;
        do {
            optionEntered = Console.systemOptionsABMLenterprise();

            switch (optionEntered) {

                //region
                case "AGREGAR NUEVA EMPRESA":
                    answer = SalesSystem.getEnterpriseManager().addEnterprise();
                    if (answer) {
                        Console.showMessage("SE AGREGO LA EMPRESA CON EXITO!");
                    }else{
                        Console.showMessage("Volviendo al menu principal...");
                    }
                    break;
                case "BAJA DE EMPRESA":

                    answer = SalesSystem.getEnterpriseManager().deleteLogicallyEnterprisForAdm();
                    if(answer){

                        Console.showMessage("SE DIO DE BAJA LA EMPRESA CON EXITO!");
                    }

                    break;
                case "MODIFICAR EMPRESA":

                    String returnedOption = SalesSystem.getEnterpriseManager().modifyEnterpriseForAdm(); //TODO PROBAR
                    if(returnedOption.equals("MODIFICADO")){
                        Console.showMessage("LA EMPRESA SE MODIFICO CON EXITO!");

                    } //option entered queda con vaor "modificado"

                    break;

                case "VER EMPRESAS":
                    SalesSystem.getEnterpriseManager().showEnterprisesList();

                    break;


                case "VOLVER AL MENU PRINCIPAL":
                    Console.showMessage("Volviendo al menu principal...");
                    break;
//                case "MODIFICADO":
//
//                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while (!optionEntered.equals("VOLVER AL MENU PRINCIPAL"));

    }
    public static void buyerABMLmenu () {
        boolean answer;
        String optionEntered;
        do {
            optionEntered = Console.systemOptionsABMLbuyer();

            switch (optionEntered) {

                //region
                case "AGREGAR NUEVA CUENTA PERSONAL":
                    answer = SalesSystem.getBuyerManager().addBuyer();
                    if (answer) {
                        Console.showMessage("SE AGREGO LA CUENTA PERSONAL CON EXITO!");
                    }
                    break;
                case "BAJA DE CUENTA PERSONAL":
                    answer = SalesSystem.getBuyerManager().deleteLogicallyBuyer();
                    if (answer) {
                        Console.showMessage("¡LA CUENTA PERSONAL SE DIO DE BAJA EXITOSAMENTE!");
                    }

                    break;
                case "MODIFICAR CUENTA PERSONAL":
                    SalesSystem.getBuyerManager().modifyBuyerForAdm(); //TODO eliminar retorno, ya q no lo utilizo

                    break;

                case "VER CUENTAS PERSONALES":
                    SalesSystem.getBuyerManager().showBuyersList();

                    break;

                case "VOLVER AL MENU PRINCIPAL":
                    Console.showMessage("Volviendo al menu principal...");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while (!optionEntered.equals("VOLVER AL MENU PRINCIPAL"));
    }

    public static String menuModifyAdministrator ( int idAdministrator){
        boolean answer;
        String optionEntered;

        do {
            optionEntered = Console.systemOptionsModifyAdministrator();

            switch (optionEntered) {

                //region
                case "MODIFICAR NOMBRE DE USUARIO":
                    answer = SalesSystem.getAdministratorManager().changeAdminUsername(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡NOMBRE DE USUARIO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;
                case "MODIFICAR EMAIL":
                    answer = SalesSystem.getAdministratorManager().changeAdminEmail(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡EMAIL MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }

                    break;
                case "MODIFICAR CONTRASEÑA":
                    answer = SalesSystem.getAdministratorManager().changeAdminPassword(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡CONTRASEÑA MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }

                    break;

                case "MODIFICAR NOMBRE":
                    answer = SalesSystem.getAdministratorManager().changeAdminFirstName(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡NOMBRE MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR APELLIDO":
                    answer = SalesSystem.getAdministratorManager().changeAdminSurname(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡APELLIDO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR FECHA DE NACIMIENTO":
                    answer = SalesSystem.getAdministratorManager().changeAdminBirthDate(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡FECHA DE NACIMIENTO MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR NUMERO DE TELEFONO":
                    answer = SalesSystem.getAdministratorManager().changeAdminPhoneNumber(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡NUMERO DE TELEFONO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR TODO":
                    answer = SalesSystem.getAdministratorManager().totalModifyOneAdministrator(idAdministrator);
                    if (answer) {
                        Console.showMessage("¡CUENTA ADMINISTRADOR MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "SALIR":
                    System.out.println(" ");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while ((!optionEntered.equals("SALIR")) && (!optionEntered.equals("MODIFICADO")));
        return optionEntered;
    }

    public static String menuModifyEnterprise ( int idEnterprise){
        boolean answer;
        String optionEntered;

        do {
            optionEntered = Console.systemOptionsModifyEnterprise();

            switch (optionEntered) {

                //region
                case "MODIFICAR NOMBRE DE USUARIO":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseUsername(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡NOMBRE DE USUARIO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;
                case "MODIFICAR EMAIL":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseEmail(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡EMAIL MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;
                case "MODIFICAR CONTRASEÑA":
                    answer = SalesSystem.getEnterpriseManager().changeEnterprisePassword(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡CONTRASEÑA MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }

                    break;

                case "MODIFICAR NOMBRE":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseFirstName(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡NOMBRE MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR APELLIDO":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseSurname(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡APELLIDO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR FECHA DE NACIMIENTO":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseBirthDate(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡FECHA DE NACIMIENTO MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR NUMERO DE TELEFONO":
                    answer = SalesSystem.getEnterpriseManager().changeEnterprisePhoneNumber(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡NUMERO DE TELEFONO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR NOMBRE DE LA EMPRESA":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseNameEnterprise(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡NOMBRE DE LA EMPRESA MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR PROVINCIA":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseProvince(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡PROVINCIA MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR CIUDAD":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseCity(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡CIUDAD MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR DIRECCION":
                    answer = SalesSystem.getEnterpriseManager().changeEnterpriseAddress(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡DIRECCION MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR CODIGO POSTAL":
                    answer = SalesSystem.getEnterpriseManager().changeEnterprisePostalCode(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡CODIGO POSTAL MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR TODO":
                    answer = SalesSystem.getEnterpriseManager().totalModifyOneEnterprise(idEnterprise);
                    if (answer) {
                        Console.showMessage("¡CUENTA ADMINISTRADOR MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "SALIR":
                    System.out.println(" ");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while ((!optionEntered.equals("SALIR")) && (!optionEntered.equals("MODIFICADO")));
        return optionEntered;
    }

    public static String menuModifyBuyer ( int idBuyer){
        boolean answer;
        String optionEntered;

        do {
            optionEntered = Console.systemOptionsModifyBuyer();

            switch (optionEntered) {

                //region
                case "MODIFICAR NOMBRE DE USUARIO":
                    answer = SalesSystem.getBuyerManager().changeBuyerUsername(idBuyer);
                    if (answer) {
                        Console.showMessage("¡NOMBRE DE USUARIO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;
                case "MODIFICAR EMAIL":
                    answer = SalesSystem.getBuyerManager().changeBuyerEmail(idBuyer);
                    if (answer) {
                        Console.showMessage("¡EMAIL MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;
                case "MODIFICAR CONTRASEÑA":
                    answer = SalesSystem.getBuyerManager().changeBuyerPassword(idBuyer);
                    if (answer) {
                        Console.showMessage("¡CONTRASEÑA MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }

                    break;

                case "MODIFICAR NOMBRE":
                    answer = SalesSystem.getBuyerManager().changeBuyerFirstName(idBuyer);
                    if (answer) {
                        Console.showMessage("¡NOMBRE MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR APELLIDO":
                    answer = SalesSystem.getBuyerManager().changeBuyerSurname(idBuyer);
                    if (answer) {
                        Console.showMessage("¡APELLIDO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR FECHA DE NACIMIENTO":
                    answer = SalesSystem.getBuyerManager().changeBuyerBirthDate(idBuyer);
                    if (answer) {
                        Console.showMessage("¡FECHA DE NACIMIENTO MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR NUMERO DE TELEFONO":
                    answer = SalesSystem.getBuyerManager().changeBuyerPhoneNumber(idBuyer);
                    if (answer) {
                        Console.showMessage("¡NUMERO DE TELEFONO MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR PROVINCIA":
                    answer = SalesSystem.getBuyerManager().changeBuyerProvince(idBuyer);
                    if (answer) {
                        Console.showMessage("¡PROVINCIA MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR CIUDAD":
                    answer = SalesSystem.getBuyerManager().changeBuyerCity(idBuyer);
                    if (answer) {
                        Console.showMessage("¡CIUDAD MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR DIRECCION":
                    answer = SalesSystem.getBuyerManager().changeBuyerAddress(idBuyer);
                    if (answer) {
                        Console.showMessage("¡DIRECCION MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR CODIGO POSTAL":
                    answer = SalesSystem.getBuyerManager().changeBuyerPostalCode(idBuyer);
                    if (answer) {
                        Console.showMessage("¡CODIGO POSTAL MODIFICADO CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "MODIFICAR TODO":
                    answer = SalesSystem.getBuyerManager().totalModifyOneBuyer(idBuyer);
                    if (answer) {
                        Console.showMessage("¡CUENTA PERSONAL MODIFICADA CON EXITO!");
                        optionEntered = "MODIFICADO";
                    } else {
                        optionEntered = "SALIR";
                    }
                    break;

                case "SALIR":
                    System.out.println(" ");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while ((!optionEntered.equals("SALIR")) && (!optionEntered.equals("MODIFICADO")));
        return optionEntered;
    }

    public static void menuCategoriesMain () {
        boolean answer;
        String optionEntered;
        do {
            optionEntered = Console.systemOptionsCategories();

            switch (optionEntered) {

                //region
                case "TECNOLOGIA":
                    SalesSystem.getProductManager().showProductByCategory(Category.TECHNOLOGY);
                    break;
                case "MODA":
                    SalesSystem.getProductManager().showProductByCategory(Category.FASHION);

                    break;
                case "VEHICULOS":
                    SalesSystem.getProductManager().showProductByCategory(Category.VEHICLES);

                    break;

                case "SUPERMERCADO":
                    SalesSystem.getProductManager().showProductByCategory(Category.SUPERMARKET);

                    break;

                case "VOLVER AL MENU PRINCIPAL":
                    Console.showMessage("Volviendo al menu principal...");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while (!optionEntered.equals("VOLVER AL MENU PRINCIPAL"));
    }

}
