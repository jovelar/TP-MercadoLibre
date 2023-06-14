package ModelsRepo.SubModelsRepo;

import Models.Product;
import ModelsRepo.IRepository;
import Models.SubModels.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardRepo implements IRepository<Card> {

    private final File file = new File("src/main/java/org/example/Archivos/productos.json");
    private ObjectMapper mapper = new ObjectMapper();

    private ArrayList<Card> cardList;


    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Card.class);
            this.cardList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.cardList = new ArrayList<>();
        }

    }

    @Override
    public void save() {
        try{
            //mapper.writeValue(archivo, this.listaClientes);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.cardList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Card> toList() {
        load();
        return this.cardList;
    }

    @Override
    public void add(Card... objeto) {
        load();
        this.cardList.addAll(List.of(objeto));
        save();
    }

    @Override
    public void delete(int id) {
        load();
        for(Card card: this.cardList){
            if(card.getIdPayMethod() == id){
                this.cardList.remove(card);
                break;
            }
        }
        save();

    }

    @Override
    public void modify(Card nuevoObjeto) {
        load();
        for(Card card: this.cardList){
            if(card.getIdPayMethod() == nuevoObjeto.getIdPayMethod()){
                //creo que no se deberia poder modificar las tarjetas
                break;
            }
        }
        save();

    }
}
