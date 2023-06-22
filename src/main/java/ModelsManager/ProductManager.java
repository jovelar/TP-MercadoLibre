package ModelsManager;

import Enums.Category;
import Models.Product;
import ModelsRepo.ProductRepo;
import Tools.Console;
import Tools.Menu;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private ProductRepo productRepo = new ProductRepo();

    //TODO: crear un showProducts simplificado, con menos datos, 3-4 atributos
    public void showSaleProducts(){
        List<Product> productList = productRepo.toList();
        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               OFERTAS");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        for(Product product : productList){
            if(product.getPrice() < 13_000){
                System.out.println("ID:" + product.getIdProduct() + " ." + product);
                System.out.println("---------------------------------------------------------");

            }
        }
    }

    public void showProductByCategory(Category category){

        List<Product> productList = productRepo.toList();
        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               "+ category.getNombre());
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        for(Product product : productList){
            if(product.getCategory() == category){
                System.out.println("ID:" + product.getIdProduct() + " ." + product);
                System.out.println("---------------------------------------------------------");

            }
        }

    }
    
    public void showOneProductById(int idProduct){
        Product product = returnProductById(idProduct);
        product.viewProduct();
        
    }

    public void showProductList(){
        List<Product> productList = productRepo.toList();

        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                              TODOS LOS PRODUCTOS");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        for(int i = 0; i< productList.size(); i++){
            System.out.println( "ID:" + productList.get(i).getIdProduct() + " ." + productList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }
    //TODO: faltaria crear el metodo showProductList() pero segun el ID de la empresa

    public void showProductListbyIDEnterprise(int idEnterprise){
        List<Product> productList = productRepo.toList();
        for(Product product : productList){
            if(product.getiDEnterprise() == idEnterprise){
                System.out.println("ID:" + product.getIdProduct() + " ." + product);
                System.out.println("---------------------------------------------------------");

            }
        }
    }


    public void addProduct(){
        Product product = null;

        String resp = "si";
        while(resp.equals("si")){

            int idProduct = productRepo.toList().size()+1;
            int idEnterprise = Console.readInt("Ingrese el id de la empresa");
            String brand = Console.readString("Ingrese la marca del producto: ");
            String productName = Console.readString("Ingrese el nombre del producto:");
            String vendorName = Console.readString("Ingrese el nombre del vendedor:");
            float price = Console.readFloat("Ingrese el precio del producto:");
            int quantity = Console.readInt("Ingrese el numero de stock:");
            String description = Console.readString("Ingrese una descripción:");


            product = new Product(idProduct, idEnterprise, brand, productName, vendorName, price,
                    quantity, null, description);

             Menu.categoriesMenu(product);

            productRepo.add(product);
            System.out.println("Producto agregado exitosamente!");

            resp = Console.readString("Desea seguir agregando productos? si/no");

        }
    }

    public void removeProduct(){
        int id = Console.readInt("Ingrese el id del producto a eliminar:");
        if(searchProductById(id)){
            Console.showMessage("Producto encontrado!");
            String resp = Console.readString("Esta seguro de continuar? si/no");
            if(resp.equals("si")){
                productRepo.delete(id);
                Console.showMessage("El producto se ha eliminado exitosamente!");
            }

        }else{
            Console.showMessage("El producto no se encuentra registrado en el sistema!");
        }


    }
    
    public boolean searchProductById(int id){
        boolean resp = false;
        List<Product> productList = productRepo.toList();

        for(Product product : productList){
            if(id == product.getIdProduct()){
                resp = true;
                break;
            }
        }
        return resp;

    }

    public void modifyProduct(){

        int idProducto = Console.readInt("Ingrese el id del producto que desea modificar:");
        //que puede modificar una empresa de sus propios productos?
        //la Marca, nombre del producto, precio, stock y descripcion
        String brand = Console.readString("Ingrese la nueva marca del producto: ");
        String productName = Console.readString("Ingrese el nuevo nombre del producto:");
        float price = Console.readFloat("Ingrese el nuevo precio del producto:");
        int quantity = Console.readInt("Ingrese el numero actual de stock:");
        String description = Console.readString("Ingrese una nueva descripción:");


        Product product = new Product(idProducto, brand, productName, price, quantity, description);

        productRepo.modify(product);

        Console.showMessage("Producto modificado con exito!");

    }

    public Product returnProductById(int id){
        Product productFound = null;
        List<Product> productList = productRepo.toList();

        for(Product product : productList){
            if(id == product.getIdProduct()){
                productFound = product;
                break;
            }
        }
        return productFound;

    }


    public void listaProductosHardcodeado(){
        List<Product> productList = productRepo.toList();

        //Enums.Category.java: Technology
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


        productRepo.save();

    }
    public ArrayList<Product> returnListOfProductsByID(List<Integer> productIdList){

        ArrayList<Product> solicitedProducts = new ArrayList<Product>();
        List<Product> productList=productRepo.toList();

        for( Integer id : productIdList){
            for(Product product : productList){
                if(id == product.getIdProduct()){
                    solicitedProducts.add(product);
                    break;
                }
            }
        }
        return solicitedProducts;
    }
    public List<Product>searchProductList(String productName){
        List<Product>searchResult=new ArrayList<Product>();
        List<Product>productList=productRepo.toList();
        for(int x=0;x<productList.size();x++){
            if (productList.get(x).getProductName().contains(productName)) {
                searchResult.add(productList.get(x));
            }
        }
        return searchResult;
    }
}
