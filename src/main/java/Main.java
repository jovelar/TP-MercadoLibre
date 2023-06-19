import ModelsManager.ProductManager;
import Tools.Menu;
import Tools.Validations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        productManager.listaProductosHardcodeado(); //cargue el archivo productos.json con los productos hardcodeados
        //Menu.menuAdmProductos();

        //mainEzequiel();
        mainJOvelar();
    }

    public static void mainEzequiel() {




    }
    public static void mainJOvelar(){
        Validations validation=new Validations();
        /*String manzana="25/02/2014";
        System.out.println(validation.validateBirthDate(manzana));
         */

        String mail="isjo@hotmail.com";
        String mail2="limon@limon";

        System.out.println(validation.validateEmail(mail));
        System.out.println(validation.validateEmail(mail2));
    }
}