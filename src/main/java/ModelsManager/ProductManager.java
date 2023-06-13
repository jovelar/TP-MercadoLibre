package ModelsManager;

import Enums.Category;
import Models.Product;
import ModelsRepo.ProductRepo;
import Tools.Consola;
import java.util.List;

public class ProductManager {

    private ProductRepo productRepo = new ProductRepo();

    public void showProductList(){
        List<Product> productList = productRepo.toList();

        for(int i = 0; i< productList.size(); i++){
            System.out.println( "ID:" + productList.get(i).getIdProduct() + " ." + productList.get(i));
            System.out.println("---------------------------------------------------------");
        }
    }

    public void addProduct(){
        String resp = "si";
        while(resp.equals("si")){

            int idProduct = Consola.readInt("Ingrese el id del producto:");
            int idEnterprise = Consola.readInt("Ingrese el id de la empresa");
            String brand = Consola.readString("Ingrese la marca del producto: ");
            String vendorName = Consola.readString("Ingrese el nombre del vendedor:");
            float price = Consola.readFloat("Ingrese el precio del producto:");
            int quantity = Consola.readInt("Ingrese el numero de stock:");

//            private String brand;
//            private String productName;
//            private String vendorName;
//            private float price;
//            private int quantity;
//
//
//            private Category category;
//            private String description;
        }
    }


}
