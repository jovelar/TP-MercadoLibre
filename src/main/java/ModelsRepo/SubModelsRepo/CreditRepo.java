package ModelsRepo.SubModelsRepo;

import Models.SubModels.Card;
import Models.SubModels.Credit;
import ModelsRepo.IRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreditRepo implements IRepository<Credit> {


    private final File file = new File("src/main/java/org/example/Archivos/productos.json");
    private ObjectMapper mapper = new ObjectMapper();

    private ArrayList<Credit> creditList;

    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Credit.class);
            this.creditList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.creditList = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try{
            //mapper.writeValue(archivo, this.listaClientes);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.creditList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Credit> toList() {
        load();
        return this.creditList;
    }

    @Override
    public void add(Credit... objeto) {
        load();
        this.creditList.addAll(List.of(objeto));
        save();
    }

    @Override
    public void delete(int id) {

        load();
        for(Credit credit: this.creditList){
            if(credit.getIdPayMethod() == id){
                this.creditList.remove(credit);
                break;
            }
        }
        save();
    }

    @Override
    public void modify(Credit nuevoObjeto) {

        load();
        for(Credit credit: this.creditList){
            if(credit.getIdPayMethod() == nuevoObjeto.getIdPayMethod()){
                //creo que no se deberia poder modificar las tarjetas
                break;
            }
        }
        save();
    }
}
