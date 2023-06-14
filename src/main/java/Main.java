import ModelsManager.ProductManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        productManager.listaProductosHardcodeado(); //cargue el archivo productos.json con los productos hardcodeados
        ProductManager productManager = new ProductManager();
        productManager.addProduct();

    }





}