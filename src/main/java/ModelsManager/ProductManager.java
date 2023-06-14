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
            String productName = Consola.readString("Ingrese el nombre del producto:");
            String vendorName = Consola.readString("Ingrese el nombre del vendedor:");
            float price = Consola.readFloat("Ingrese el precio del producto:");
            int quantity = Consola.readInt("Ingrese el numero de stock:");
            Category category = Category.TECHNOLOGY;
            String description = Consola.readString("Ingrese una descripción:");

            Product product = new Product(idProduct, idEnterprise, brand, productName, vendorName, price,
                    quantity, category, description);

            resp = Consola.readString("Desea seguir agregando productos? si/no");
            productRepo.add(product);

        }
    }

    public void removeProduct(){
        int id = Consola.readInt("Ingrese el id del producto a eliminar:");
        if(searchProductById(id)){
            System.out.println("Producto encontrado!");
            String resp = Consola.readString("Esta seguro de continuar?");
            if(resp.equals("si")){
                productRepo.delete(id);
                System.out.println("El producto se ha eliminado exitosamente!");
            }

        }else{
            System.out.println("El producto no se encuentra registrado en el sistema!");
        }


    }



    public Boolean searchProductById(int id){
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






}
