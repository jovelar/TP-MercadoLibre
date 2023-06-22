import Enums.TypeUser;
import Models.Buyer;
import Models.Product;
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
                    System.out.println(buyer);
                    //TODO: agregar metodo con switch y opciones de modificacion de perfil
                    break;
                case "CREAR CUENTA":
                    SalesSystem.createAccount();
                    break;

                //endregion
//-----------------------------------------------------------------
                case "INGRESAR":
                    userConected = SalesSystem.logIn(username);

                    if(userConected){
                        typeUser = SalesSystem.returnTypeUserByUsername(username.toString());

                        if(typeUser == TypeUser.BUYER) {
                            buyer = SalesSystem.getBuyerManager().returnBuyerByUsername(username.toString());

                        }else if(typeUser == TypeUser.ADMINISTRATOR) {
                            Menu.administratorMainMenu(username.toString());

                        }else if(typeUser == TypeUser.ENTERPRISE) {
                            Menu.enterpriseMainMenu(username.toString());
                        }
                    }

                    break;
//-----------------------------------------------------------------

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
                        int opc=Console.systemOptionsDeleteProductFromCart();
                        if(opc==0){
                            int idAeliminar=Validations.doUntilValidNumber(Console.readInt("Ingrese el ID del producto a eliminar"));
                            if(idAeliminar!=0){
                                if(buyer.validateValidFavorite(idAeliminar)){
                                    buyer.deleteFavorite(idAeliminar);
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
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "VER MAS PRODUCTOS":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "BUSCAR":
                    String productToSearch=Console.readString("Ingrese el nombre del producto a buscar: ");
                    List<Product>searchResult=SalesSystem.getProductManager().searchProductList(productToSearch);
                    if (searchResult != null && searchResult.size() != 0) {
                        buyer.showFavoriteList((ArrayList<Product>) searchResult);
                        int option=Console.systemOptionsbuyProduct();
                        if(option==1){
                            int producToBuy=Console.readInt("Ingrese el ID del producto a comprar: ");
                        }else if(option==2){
                            int productToFavorites=Console.readInt("Ingrese el ID del producto a incorporar a favoritos");

                        }
                    }
                    System.out.println("Ha seleccionado la opcion "+ optionEntered);
                    break;
                case "VER CATEGORIAS":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "SALIR":
                    Console.showMessage("Saliendo del programa...");
                    break;
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while(!optionEntered.equals("SALIR"));

        //mainEzequiel();

        //mainJOvelar();
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