package ModelsRepo;

import Models.Product;
import Models.SubModels.Order;
import Models.SubModels.PayMethod;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IRepository<Product> {

    private final File file = new File("src/main/java/org/example/Archivos/productos.json");
    private ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Product> productList;

    //region constructors
    public ProductRepo(){

    }
    //endregion

    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Product.class);
            this.productList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.productList = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        //serializar, escribir en el archivo .json
        try{
            //mapper.writeValue(archivo, this.listaClientes);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.productList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> toList() {
        load();
        return this.productList;

    }

    @Override
    public void add(Product... objeto) {
        load();
        this.productList.addAll(List.of(objeto));
        save();
    }

    @Override
    public void delete(int id) {
        load();
        for(Product product: this.productList){
            if(product.getIdProduct() == id){
                this.productList.remove(product);
                break;
            }
        }
        save();
    }

    @Override
    public void modify(Product nuevoObjeto) {
        load();
        for(Product product: this.productList){
            if(product.getIdProduct() == nuevoObjeto.getIdProduct()){
                product.setBrand(nuevoObjeto.getBrand());
                product.setProductName(nuevoObjeto.getProductName());
                product.setVendorName(nuevoObjeto.getVendorName());
                product.setPrice(nuevoObjeto.getPrice());
                product.setQuantity(nuevoObjeto.getQuantity());
                break;
            }
        }
        save();

    }
    //endregion

    private int idPayMethod;
    private int idUser;

    private String type; //para que necesitamos este atributo "tipo"?
    private float amount;//cuanta plata paga el cliente o cuanto saldo tiene?
    private long dni;
    private float amount; //no iria para mi porq ya tenemos un atributo amount en la clase padre
    private long creditCardNumber;
    private String expDate;
    private int cvcCode;


}
