
import Enums.TypeUser;
import Models.Buyer;
import Models.User;
import ModelsManager.SalesSystem;
import Tools.Console;
import Tools.Validations;

import ModelsManager.AdministratorManager;



import static ModelsManager.SalesSystem.returnTypeUserByUsername;



public class Main {
    public static void main(String[] args) {

        mainMenu();

//        mainEzequiel();
        //mainJOvelar();

    }

    public static void mainMenu() {

        String username = "";
        Buyer buyer = new Buyer();
        boolean userConected = false;
        TypeUser typeUser = TypeUser.NONE;

        SalesSystem.getProductManager().showSaleProducts();

        //menu principal
        String optionEntered;

        do {
            /*if(userConected && typeUser==TypeUser.BUYER){
                buyer = (Buyer) user;
            }*/
            optionEntered = Console.systemOptions(userConected);

            switch (optionEntered) {
                case "VER MI PERFIL":
                    System.out.println(buyer);
                    //TODO: agregar metodo con switch y opciones de modificacion de perfil
                    break;
                case "CREAR CUENTA":
                    SalesSystem.createAccount();
                    break;

//-----------------------------------------------------------------
                case "INGRESAR":
                    userConected = SalesSystem.logIn(username);

                    if(userConected){
                        typeUser = SalesSystem.returnTypeUserByUsername(username);

                        if(typeUser == TypeUser.BUYER)
                            buyer = SalesSystem.getBuyerManager().returnBuyerByUsername(username);

                        else if(typeUser == TypeUser.ADMINISTRATOR) {
                            //TODO: metodo con switch para opciones del ADMINISTRATOR
                            // dentro se instancia un ADMINISTRATOR a partir del username

                        }else if(typeUser == TypeUser.ENTERPRISE) {
                            //TODO: metodo con switch para ENTERPRISE
                            // dentro se instancia un ENTERPRISE a partir del username
                        }
                    }

                    break;
//-----------------------------------------------------------------

                case "MIS COMPRAS":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "FAVORITOS":
                    //SalesSystem.
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "CARRITO":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "VER UN PRODUCTO":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
                    break;
                case "VER MAS PRODUCTOS":
                    System.out.println("Ha seleccionado la opción " + optionEntered);
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

    public static void mainEzequiel() {

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