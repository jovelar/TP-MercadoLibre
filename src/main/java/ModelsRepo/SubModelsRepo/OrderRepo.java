package ModelsRepo.SubModelsRepo;

import Models.SubModels.Card;
import ModelsRepo.IRepository;
import Models.SubModels.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo implements IRepository<Order> {

    private final File file = new File("src/main/java/org/example/Archivos/orders.json");
    private ObjectMapper mapper = new ObjectMapper();

    private ArrayList<Order> orderList;


    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Order.class);
            this.orderList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.orderList = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.orderList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Order> toList() {
        load();
        return this.orderList;
    }

    @Override
    public void add(Order... objeto) {
        load();
        this.orderList.addAll(List.of(objeto));
        save();

    }

    @Override
    public void delete(int id) {
        load();
        for(Order order: this.orderList){
            if(order.getIdOrder() == id){
                this.orderList.remove(order);
                break;
            }
        }
        save();


    }

    @Override
    public void modify(Order nuevoObjeto) {
        load();
        for(Order order : this.orderList){
            if(order.getIdOrder() == nuevoObjeto.getIdOrder()){
                order.setState(nuevoObjeto.getState());
                break;
            }
        }
        save();

    }
}
