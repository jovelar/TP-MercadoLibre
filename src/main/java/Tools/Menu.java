package Tools;

import java.util.Scanner;

public class Menu {


    //region CategoriesMenu
    public static void categoriesMenu(){
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            showCategoriesMenu();
            opcion = scan.nextInt();
            scan.reset();
            optionsCategoryMenu(opcion);


        }while(opcion != 5);


    }

    public static void showCategoriesMenu(){
        System.out.println("Elija una categoria");
        System.out.println("1. Tecnologia");
        System.out.println("2. Ropa");
        System.out.println("3. Vehiculos");
        System.out.println("4. Supermercado");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void optionsCategoryMenu(int opcion){

        switch (opcion) {
            case 1:
                System.out.println("");


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
}
