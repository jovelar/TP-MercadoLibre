import Enums.TypeUser;
import Models.Buyer;
import Models.Product;
import Models.SubModels.Order;
import ModelsManager.BuyerManager;
import ModelsManager.SalesSystem;
import Tools.Console;
import Tools.Menu;
import Tools.Validations;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        mainMenu();

        //mainEzequiel();
        //mainJOvelar();

    }

    public static void mainMenu() {

        StringBuilder username = new StringBuilder();
        Buyer buyer = new Buyer();
        boolean userConected = false;
        TypeUser typeUser;
        String optionEntered;

        SalesSystem.getProductManager().showSaleProducts();

        //menu principal
        do {
            optionEntered = Console.systemOptions(userConected);

            switch (optionEntered) {
                //region
                case "VER MI PERFIL":

                        buyer.viewProfile();

                        int answer = Console.buttonsModifyAndReturn();

                        if (answer == 0) {
                            String returnedOption = Menu.menuModifyBuyer(buyer.getIdUser());
                            if (returnedOption.equals("MODIFICADO")) {
                                buyer = SalesSystem.getBuyerManager().returnBuyerById(buyer.getIdUser());
                                buyer.viewProfile();
                            }
                        }

                        Console.showMessage("Volviendo al menu principal...");


//                    System.out.println(buyer);
                    //TODO: agregar metodo con switch y opciones de modificacion de perfil
                    break;//endregion
                case "CREAR CUENTA"://region
                    SalesSystem.createAccount();
                    break;//endregion

                case "INGRESAR"://region
                    userConected = SalesSystem.logIn(username);

                    if(userConected){
                        typeUser = SalesSystem.returnTypeUserByUsername(username.toString());

                        if(typeUser == TypeUser.BUYER) {
                            buyer = SalesSystem.getBuyerManager().returnBuyerByUsername(username.toString());

                        }else if(typeUser == TypeUser.ADMINISTRATOR) {
                            optionEntered = Menu.administratorMainMenu(username.toString());// TODO retorna

                        }else if(typeUser == TypeUser.ENTERPRISE) {
                            optionEntered = Menu.enterpriseMainMenu(username.toString());
                        }
                    }

                    break;//endregion
                case "MIS COMPRAS":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "FAVORITOS":

                    List<Integer> favorites=buyer.getFavorites();
                    if(favorites!=null && !favorites.isEmpty()){
                        ArrayList<Product>favoriteProductlist=SalesSystem.getProductManager().returnListOfProductsByID(favorites);


                        buyer.showFavoriteList(favoriteProductlist);
                        int opc=Console.systemOptionsDeleteFavorites();
                        if(opc==0){
                            int idAeliminar=Validations.doUntilValidNumber(Console.readInt("Ingrese el ID del producto a eliminar"));
                            if(idAeliminar!=0){
                                if(buyer.validateValidFavorite(idAeliminar)){
                                    buyer.deleteFavorite(idAeliminar);
                                    SalesSystem.getBuyerManager().replaceBuyer(buyer);
                                    Console.showMessage("Producto favorito eliminado");
                               }
                            }
                        }
                    }
                    else{
                        Console.showMessageError("La lista esta vacia!");
                    }
                    //AGREGAR ELIMINAR FAVORITOS Y VOLVER

                    //SalesSystem.

                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "CARRITO":
                    List<Integer>  cart=buyer.getCart();
                    if(cart!=null && !cart.isEmpty()){
                        ArrayList<Product>cartList=SalesSystem.getProductManager().returnListOfProductsByID(cart);
                        buyer.showFavoriteList(cartList);
                        int opc=Console.systemOptionsProductFromCart();
                        if(opc==0){


                        }
                        if(opc==1){
                            int idAeliminar=Validations.doUntilValidNumber(Console.readInt("Ingrese el ID del producto a eliminar"));
                            if(idAeliminar!=0){
                                if(buyer.validateValidFavorite(idAeliminar)){
                                    buyer.deleteProductFromCart(idAeliminar);
                                    SalesSystem.getBuyerManager().replaceBuyer(buyer);
                                    Console.showMessage("Producto eliminado");
                                }
                            }
                        }
                    }else{
                        Console.showMessageError("El carrito esta vacio!");
                    }
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "VER UN PRODUCTO":
                    int idProduct = Validations.doUntilValidNumber(Console.readInt("Ingrese el id del producto"));
                    SalesSystem.getProductManager().showOneProductById(idProduct);

                    break;
                case "VER MAS PRODUCTOS":
                    SalesSystem.getProductManager().showProductList();
                    break;
                case "BUSCAR":
                    String productToSearch=Console.readString("Ingrese el nombre del producto a buscar: ");
                    List<Product> searchResult=SalesSystem.getProductManager().searchProductList(productToSearch);
                    Console.cleanConsole();

                    if (searchResult != null && searchResult.size() != 0) {
                        System.out.println("\033[33m-------------------------------------------------------------------------");
                        System.out.println("                              PRODUCTOS ENCONTRADOS");
                        System.out.println("-------------------------------------------------------------------------\u001B[0m");
                        buyer.showFavoriteList((ArrayList<Product>) searchResult);
                        Console.cleanConsole();

                        int option=Console.systemOptionsbuyProduct();
                        if(option==0){
                            int opcMetododePago=Console.systemOptionsBuyPayMethod();
                            if(opcMetododePago==0){ //PAGO CON DINERO

                            }else if (opcMetododePago==1){ //PAGO CON TARJETA

                            }

                            int producToBuy=Console.readInt("Ingrese el ID del producto a comprar: ");
                        }else if(option==1){
                            int productToCart=Console.readInt("Ingrese el ID del producto a incorporar al carrito");
                            if(Validations.validateProductFromList(productToCart,searchResult)){
                                buyer.addToCart(productToCart);
                                SalesSystem.getBuyerManager().replaceBuyer(buyer);
                            }else{
                                Console.showMessage("Error ID de producto invalido!");
                            }

                        }else if (option==2){
                            int productToFavorites=Console.readInt("ingrese el ID del producto a incorporar a favoritos");
                            buyer.addFavorite(productToFavorites);
                        }
                    }else{
                        Console.showMessage("No se encontraron productos con ese nombre");
                    }
                    System.out.println("Ha seleccionado la opcion "+ optionEntered);
                    break;
                case "VER CATEGORIAS":
                    Menu.menuCategoriesMain();
                    break;
                case "SALIR":
                    Console.showMessage("Saliendo del programa...");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while(!optionEntered.equals("SALIR"));
    }

    public static void mainEzequiel(StringBuilder hola) {

        hola.setLength(0);
        hola.append("hola mundo!");
        System.out.println("DENTRO DE LA FUNCION ->" + hola);

        /*EnterpriseManager enterpriseManager = new EnterpriseManager();
        enterpriseManager.totalModifyEnterprise();*/

        //AdministratorManager administratorManager = new AdministratorManager();
        //administratorManager.addAministrator();
        //administratorManager.deleteLogicallyAdminsitrator();
        //administratorManager.deleteAdministrator();
        //administratorManager.totalModifyAdministrator();

    }

    public static void mainJOvelar(){
        Validations validation=new Validations();
        String manzana="25/02/2014";
        System.out.println(validation.validateBirthDate(manzana));

        String nombre1="jose maria listorti";
        String nombre2="Abaco 123 ";
        String nombre3=".*.------=";

        //System.out.println(validation.validateName(nombre1));
        //System.out.println(validation.validateName(nombre2));
        //System.out.println(validation.validateName(nombre3));
        //String kopona=validation.doUntilValidName(Console.readString("Ingrese su nombre"));
        long telefono=Console.readLong("Ingrese su numero de telefono, sin espacios ni giones");
    }
}