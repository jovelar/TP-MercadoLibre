import ModelsManager.ProductManager;
import Tools.Console;
import Tools.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //menu principal
        int opcion;

        do {
            System.out.println("Inicio");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Ingresar");
            System.out.println("3. Mis compras");
            System.out.println("4. Carrito");
            System.out.println("5. Ver producto");
            System.out.println("6. Ver todos los productos");
            System.out.println("7. Ver por categoría");
            System.out.println("0. Salir");
            opcion = Console.readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    // Acciones para la opción 1
                    System.out.println("Ha seleccionado la opción 1.");
                    break;
                case 2:
                    // Acciones para la opción 2
                    System.out.println("Ha seleccionado la opción 2.");
                    break;
                case 3:
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case 4:
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case 5:
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case 6:
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case 7:
                    // Acciones para la opción 3
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while (opcion != 0);

    }

//        productManager.listaProductosHardcodeado(); //cargue el archivo productos.json con los productos hardcodeados
//        Menu.menuAdmProductos();

//        mainEzequiel();


    public static void mainEzequiel() {




    }



}