import Enums.TypeUser;
import Models.Buyer;
import Models.Product;
import Models.SubModels.Card;
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

    }

    public static void mainMenu() {

        StringBuilder username = new StringBuilder();
        Buyer buyer = new Buyer();
        boolean userConected = false;
        TypeUser typeUser;
        String optionEntered;


        //menu principal
        do {
            SalesSystem.getProductManager().showSaleProducts();
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
                    break;//endregion
                case "FAVORITOS"://region

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
                    break;//endregion
                case "CARRITO"://region
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
                    break;//endregion
                case "VER UN PRODUCTO": //region
                    int idProduct = Validations.doUntilValidNumber(Console.readInt("Ingrese el id del producto"));
                    SalesSystem.getProductManager().showOneProductById(idProduct);

                    break;//endregion
                case "VER MAS PRODUCTOS"://region
                    SalesSystem.getProductManager().showProductList();
                    break;//endregion
                case "BUSCAR"://region
                    String productToSearch=Console.readString("Ingrese el nombre del producto a buscar: ");
                    List<Product> searchResult=SalesSystem.getProductManager().searchProductList(productToSearch);
                    Console.cleanConsole();

                    if (searchResult != null && searchResult.size() != 0) {
                        System.out.println("\033[33m-------------------------------------------------------------------------");
                        System.out.println("                              PRODUCTOS ENCONTRADOS");
                        System.out.println("-------------------------------------------------------------------------\u001B[0m");
                        SalesSystem.getProductManager().showSearchProductList((ArrayList<Product>) searchResult);
                        Console.cleanConsole();

                        int option = Console.systemOptionsbuyProduct();
                        if (option == 0) { //COMPRAR

//                            List<Product>cartLisToBuy=SalesSystem.getProductManager().returnListOfProductsByID(buyer.getCart());
//                            float cartPrice= buyer.cartValue(cartLisToBuy);
                            int idProductC = Validations.doUntilValidNumber(Console.readInt("Ingrese el ID del producto a comprar:"));
                            Product compraProducto = SalesSystem.getProductManager().returnProductById(idProductC);

                            int opcMetododePago = Console.systemOptionsBuyPayMethod();
                            if (opcMetododePago == 0) { //PAGO CON DINERO
                                if (buyer.checkAvailableCredit(compraProducto.getPrice())) {
                                    buyer.removeCredit(compraProducto.getPrice());
                                    Console.showMessage("COMPRA EXITOSA!");
                                    SalesSystem.getBuyerManager().changeSaldoBuyer(buyer);
                                    compraProducto.setQuantity(compraProducto.getQuantity()-1);
                                    SalesSystem.getProductManager().descontarStock(compraProducto);
/*                                    int orderNumber=SalesSystem.getOrderManager().addOrderCredit(buyer,cartLisToBuy);
                                    buyer.addToShoppingHistory(orderNumber);
                                    buyer.clearCart();
                                    SalesSystem.getBuyerManager().replaceBuyer(buyer);
                                    Console.showMessage("Gracias por su compra");*/
                                } else {
                                    Console.showMessageError("Saldo insuficiente");
                                }


                            } else if (opcMetododePago == 1) { //PAGO CON TARJETA
/*                                List<Card>availableCards=SalesSystem.getCardManager().getCards(buyer.getCards());
                                int selectedCard=Console.readInt("Ingrese el ID de la tarjeta que desea usar");

                                if(buyer.checkAvailableCredit(cartPrice)){
                                    buyer.removeCredit(cartPrice);
                                   // int orderNumber=SalesSystem.getOrderManager().addOrder(buyer,cartLisToBuy,pickedCard;);
                                   // buyer.addToShoppingHistory(orderNumber);
                                    buyer.clearCart();
                                    SalesSystem.getBuyerManager().replaceBuyer(buyer);
                                    Console.showMessage("Gracias por su compra");
                                }else{
                                    Console.showMessageError("Saldo insuficiente");
                                }*/
                            }

/*                            int producToBuy=Console.readInt("Ingrese el ID del producto a comprar: ");
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
                        }*/
                        }
                    }else{
                        Console.showMessage("No se encontraron productos!");
                    }
                    break;//endregion
                case "VER CATEGORIAS"://region
                    Menu.menuCategoriesMain();
                    break;//endregion
                case "VER MI SALDO"://region
                    Console.showMessage("SALDO DISPONIBLE: $" +buyer.getAvailableMoney() );
                    break;//endregion

                case "SALIR"://region
                    Console.showMessage("Saliendo del programa...");
                    break;//endregion
                default:
                    Console.showMessageError("OPCION INVALIDA! VUELVA A INTENTARLO!");
                    break;
            }

        } while(!optionEntered.equals("SALIR"));
    }

}