import java.util.ArrayList;

public class ProductRepo implements IRepository{
    private ArrayList<Product>productList;

    //no estoy segura si estan bien estos metodos, dejo el coment para revisarlo despues
    public ProductRepo(){

    }
    public ProductRepo(ArrayList<Product> productList) {
        this.productList = productList;
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
