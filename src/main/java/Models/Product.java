package Models;

import Enums.Category;

public class Product {

    //region ATTRIBUTES
    private int idProduct;
    private int iDEnterprise;
    private String brand;
    private String productName;
    private String vendorName;
    private float price;
    private int quantity;


    private Category category;
    private String description;
    //endregion

    //region CONTRUCTORS
    public Product(){}

    //este constructor lo utilizo para hardcodear los productos, sin colocar
    //un id del producto, porque el id deber ser autoincremental y asignado
    //automaticamente

    public Product(int iDEnterprise, String brand, String productName, String vendorName, float price, int quantity, Category category, String description) {
        this.iDEnterprise = iDEnterprise;
        this.brand = brand;
        this.productName = productName;
        this.vendorName = vendorName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
    }

    ///el constructor siguiente lo utilizo para crear un producto sin asignar los valores que no voy a modificar en el
    //metodo modifyProduct de productManager


    public Product(int idProduct, String brand, String productName, float price, int quantity, String description) {
        this.idProduct = idProduct;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(int idProduct, int iDEnterprise, String brand, String productName, String vendorName,
                   float price, int quantity, Category category, String description) {
        this.idProduct = idProduct;
        this.iDEnterprise = iDEnterprise;
        this.brand = brand;
        this.productName = productName;
        this.vendorName = vendorName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
    }


    //endregion

    //region GETTERS AND SETTERS
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getiDEnterprise() {
        return iDEnterprise;
    }

    public void setiDEnterprise(int iDEnterprise) {
        this.iDEnterprise = iDEnterprise;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion


    @Override
    public String toString() {
        return "\n ID del vendedor(empresa): " + iDEnterprise +
                "\n Marca: " + brand +
                "\n Nombre del producto: " + productName +
                "\n Nombre del vendedor:" + vendorName +
                "\n Precio:" + price +
                "\n Stock: " + quantity +
                "\n Categoria: " + category +
                "\n Descripción: " + description;
    }
}
