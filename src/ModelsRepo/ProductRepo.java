package ModelsRepo;

import Enums.Category;
import Models.Product;

import java.util.ArrayList;

public class ProductRepo implements IRepository {
    private ArrayList<Product>productList;



    //region constructors
    public ProductRepo(){

    }
    public ProductRepo(ArrayList<Product> productList) {
        this.productList = productList;
    }
    //endregion

    //no estoy segura si estan bien estos metodos, dejo el coment para revisarlo despues
    public void listaProductosHardcodeado(){
        ArrayList<Product> productList = new ArrayList<>();

        //Enums.Category: Technology
        //celulares
        productList.add(new Product(1, "Motorola", "Celular Moto G52", "Tienda Motorola", 134000, 110, Category.TECHNOLOGY, "Celular Moto G52, 6GB RAM, liberado, memoria interna de 128GB"));
        productList.add(new Product(1, "Motorola", "Celular Motorola G32", "Tienda Motorola", 77999, 50, Category.TECHNOLOGY, "Celular Moto G32, 4GB RAM, liberado, memoria interna de 128GB"));

        productList.add(new Product(2, "Xiaomi","Celular Xiaomi Redmi Note 11", "TECH STORE", 108999, 50, Category.TECHNOLOGY, "Celular Xiaomi Redmi Note 11, Dual SIM, 128GB de memoria interna, 4GB RAM"));
        productList.add(new Product(2, "Samsung","Celular Galaxy Z Flip4 5G", "TECH STORE", 379999, 25, Category.TECHNOLOGY, "Celular Galaxy Z Flip4 , liberado, 128GB de memoria interna, 8GB RAM"));
        productList.add(new Product(2, "Samsung","Celular Galaxy A04", "TECH STORE", 69999, 200, Category.TECHNOLOGY, "Celular Samsung Galaxy A04, liberado, 128GB de memoria interna, 4GB RAM"));
        productList.add(new Product(2, "TCL","Celular TCL 408", "TECH STORE", 52999, 50, Category.TECHNOLOGY, "Celular Tcl 408, liberado, 64GB de memoria interna, 4GB RAM"));
        productList.add(new Product(2, "Quantum","Celular Quantum Q20", "TECH STORE", 47999, 150, Category.TECHNOLOGY, "Celular Quantum Q20 Dual SIM, 128GB interna, 4GB RAM"));
        //tablets
        productList.add(new Product(2, "Samsung","Tablet Galaxy Tab A7 lite", "TECH STORE", 79999, 90, Category.TECHNOLOGY, "Tablet Samsung Galaxy Tab A7 Lite SM-T220, 8,7 pulgadas, capacidad de 32GB, 3GB RAM"));
        productList.add(new Product(2, "Samsung","Tablet Samsung Galaxy Tab S S6 Lite", "TECH STORE", 193999, 50, Category.TECHNOLOGY, "Tablet Samsung Galaxy Tab S S6 Lite SM-P610, 10,4 pulgadas, capacidad de 64GB, 4GB RAM"));

        //perifericos
        productList.add(new Product(2, "Redragon","Teclado gamer Redragon K552 QWERTY", "TECH STORE", 24916, 100, Category.TECHNOLOGY, "Teclado gamer Redragon Kumara K552 Outemu Red español latinoamérica color negro con luz RGB"));
        productList.add(new Product(2, "Satechi","Teclado bluetooth Satechi Slim X3", "TECH STORE", 34189, 100, Category.TECHNOLOGY, "Teclado bluetooth Satechi Slim X3 Bluetooth Backlit Keyboard QWERTY español España color space gray"));
        productList.add(new Product(2, "Aiwa","Teclado Gamer Mecanizado Constrictor", "TECH STORE", 10124, 100, Category.TECHNOLOGY, "Teclado Aiwa TEC-3001KG, gamer, tipo de switch Blue"));

        productList.add(new Product(2, "Redragon","Cámara web Redragon Fobos GW600", "TECH STORE", 14999, 80, Category.TECHNOLOGY, "Cámara web Redragon Fobos GW600 HD 30FPS color negro"));
        productList.add(new Product(2, "Gadnic","Cámara web Gadnic Full HD", "TECH STORE", 15699, 80, Category.TECHNOLOGY, "Cámara web Gadnic Camweb01 Full HD 30FPS color negro"));
        productList.add(new Product(2, "Logitech","Cámara web Logitech C505e", "TECH STORE", 14200, 80, Category.TECHNOLOGY, "Cámara web Logitech C505e HD 30FPS color negro"));

        productList.add(new Product(2, "Samsung","Auriculares Samsung 3.5mm Earphones in Ear", "TECH STORE", 9999, 20, Category.TECHNOLOGY, "Auriculares Samsung EO-IA500, In-ear, color negro"));
        productList.add(new Product(2, "Philco","Auriculares inalámbricos P1000nc", "TECH STORE", 22079, 30, Category.TECHNOLOGY, "Auriculares Inalámbricos Philco P1000nc Bluetooth Noise Cancelling"));

        //cámaras
        productList.add(new Product(3, "Nikon","Cámara Nikon Kit D5600 18-55mm ", "Nikon Argentina", 639502, 45, Category.TECHNOLOGY, "Camara Nikon Kit D5600 18-55mm VR DSLR color negro"));
        productList.add(new Product(3, "Nikon","Cámara Nikon Kit D3500 + lente 18-55mm VR ", "Nikon Argentina", 609304, 45, Category.TECHNOLOGY, "Camara Nikon Kit D3500 + lente 18-55mm VR + lente 70-300mm + Mochila DSLR color negro"));
        productList.add(new Product(3, "Nikon","Kit Camara Nikon Z50 ", "Nikon Argentina", 998161, 45, Category.TECHNOLOGY, "Camara Nikon Z50 Mirrorless + Lente 16-50mm F/3.5-6.3 Vr"));

        productList.add(new Product(4, "Canon","Cámara Canon EOS Kit M50 Mark II + lente 15-45mm ", "Photo Store", 548900, 45, Category.TECHNOLOGY, "Canon EOS Kit M50 Mark II + lente 15-45mm 3.5-6.3 IS STM + lente 55-200mm sin espejo color negro"));
        productList.add(new Product(4, "Canon","Cámara Canon EOS Rebel SL3", "Photo Store", 369999, 45, Category.TECHNOLOGY, "Cámara Canon EOS Rebel SL3 DSLR color negro"));

        //category: fashion
        productList.add(new Product(5, "Jaguar","Zapatillas Jaguar Trekking", "SOLO DEPORTES", 369999, 45, Category.TECHNOLOGY, "Cámara Canon EOS Rebel SL3 DSLR color negro"));



    }
    public void addProduct(Product product){

    }
    public void editProduct(Product product){

    }
    public void removeProduct(Product product){

    }
    public void showAllProducts(){

    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}