package ModelsRepo;

import Models.Administrator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class AdministratorRepo implements IRepository<Administrator> {

    //region ATTRIBUTES
    private final File file = new File("src/main/java/Files/usersAdministrators.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Administrator> administratorsList;
    //endregion

    //region IMPLEMENTATION OF REPOSITORY INTERFACE METHODS
    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Administrator.class);
            this.administratorsList = mapper.readValue(file, collectionType);

        } catch (IOException e) {
            this.administratorsList = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        //serializar, escribir en el archivo .json
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.administratorsList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Administrator> toList() {
        load();
        return this.administratorsList;
    }

    @Override
    public void add(Administrator... objeto) {
        load();
        this.administratorsList.addAll(List.of(objeto));
        save();
    }

    @Override
    public void delete(int id) {
        load();
        for(Administrator adm : this.administratorsList){
            if(adm.getIdUser() == id){
                this.administratorsList.remove(adm);
                break;
            }
        }
        save();
    }

    @Override
    public void modify(Administrator nuevoObjeto) {

        load();

        for(Administrator adm : this.administratorsList){

            if(adm.getIdUser() == nuevoObjeto.getIdUser()){

                adm.setUsername(nuevoObjeto.getUsername());
                adm.setEmail(nuevoObjeto.getEmail());
                adm.setPassword(nuevoObjeto.getPassword());

                adm.setFirstName(nuevoObjeto.getFirstName());
                adm.setSurname(nuevoObjeto.getSurname());
                adm.setDni(nuevoObjeto.getDni());
                adm.setBirthDate(nuevoObjeto.getBirthDate());
                adm.setPhoneNumber(nuevoObjeto.getPhoneNumber());
                adm.setActive(nuevoObjeto.getActive());
                break;
            }
        }
        save();
    }
    //endregion
}
