package ModelsRepo;

import Models.Buyer;
import Models.Product;
import Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyerRepo implements IRepository<Buyer>{

    private final File file = new File("src/main/java/Files/usersBuyers.json");
    private ObjectMapper mapper = new ObjectMapper();

    private ArrayList<Buyer>buyerList;


    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Buyer.class);
            this.buyerList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.buyerList = new ArrayList<>();
        }

    }


    @Override
    public void save() {
        try{
            //mapper.writeValue(archivo, this.listaClientes);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.buyerList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Buyer> toList() {
        load();
        return this.buyerList;

    }

    @Override
    public void add(Buyer... objeto) {
        load();
        this.buyerList.addAll(List.of(objeto));
        save();

    }

    @Override
    public void delete(int id) {
        load();
        for(Buyer buyer: this.buyerList){
            if(buyer.getIdUser() == id){
                this.buyerList.remove(buyer);
                break;
            }
        }
        save();
    }

    @Override
    public void modify(Buyer nuevoObjeto) {
        load();
        for(Buyer buyer: this.buyerList){
            if(buyer.getIdUser() == nuevoObjeto.getIdUser()){
                buyer.setUsername(nuevoObjeto.getUsername());
                buyer.setEmail(nuevoObjeto.getEmail());
                buyer.setPassword(nuevoObjeto.getPassword());
                buyer.setFirstName(nuevoObjeto.getFirstName());
                buyer.setSurname(nuevoObjeto.getSurname());
                buyer.setBirthDate(nuevoObjeto.getBirthDate());
                buyer.setPhoneNumber(nuevoObjeto.getPhoneNumber());
                buyer.setActive(nuevoObjeto.getActive());
                buyer.setProvince(nuevoObjeto.getProvince());
                buyer.setCity(nuevoObjeto.getCity());
                buyer.setAddress(nuevoObjeto.getAddress());
                buyer.setFavorites(nuevoObjeto.getFavorites());
                buyer.setCart(nuevoObjeto.getCart());
                //buyer.setPayMethod(nuevoObjeto.getPayMethod());
                buyer.setShoppingHistory(nuevoObjeto.getShoppingHistory());
                buyer.setAvailableMoney(buyer.getAvailableMoney());
                break;
            }
        }
        save();
    }
}
