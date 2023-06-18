package ModelsRepo;

import Models.Administrator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRepo implements IRepository<Administrator> {

    //region ATTRIBUTES
    private final File file = new File("src/main/java/org/example/Files/administrators.json");
    private ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Administrator> admsList;
    //endregion

    //region IMPLEMENTATION OF REPOSITORY INTERFACE METHODS
    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Administrator.class);
            this.admsList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.admsList = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        //serializar, escribir en el archivo .json
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.admsList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Administrator> toList() {
        load();
        return this.admsList;
    }

    @Override
    public void add(Administrator... objeto) {
        load();
        this.admsList.addAll(List.of(objeto));
        save();
    }

    @Override
    public void delete(int id) {
        load();
        for(Administrator adm : this.admsList){
            if(adm.getIdUser() == id){
                this.admsList.remove(adm);
                break;
            }
        }
        save();
    }

    @Override
    public void modify(Administrator nuevoObjeto) {
        load();
        for(Administrator adm : this.admsList){
            if(adm.getIdUser() == nuevoObjeto.getIdUser()){

                adm.setUsername(nuevoObjeto.getUsername());
                adm.setEmail(nuevoObjeto.getEmail());
                adm.setPassword(nuevoObjeto.getPassword());
                adm.setFirstName(nuevoObjeto.getFirstName());
                adm.setSurname(nuevoObjeto.getSurname());
                adm.setBirthDate(nuevoObjeto.getBirthDate());
                adm.setPhoneNumber(nuevoObjeto.getPhoneNumber());
                break;
            }
        }
        save();
    }
    //endregion
}
