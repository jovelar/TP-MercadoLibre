package ModelsRepo;

import Models.Enterprise;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class EnterpriseRepo implements IRepository<Enterprise> {

    //region ATTRIBUTES
    private final File file = new File("src/main/java/Files/usersEnterprise.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Enterprise> enterprisesList;
    //endregion

    //region IMPLEMENTATION OF REPOSITORY INTERFACE METHODS
    @Override
    public void load() {
        try {
            //desearializar, levantar un archivo .json y cargarlo a mi programa
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Enterprise.class);
            this.enterprisesList = mapper.readValue(this.file, collectionType);

        } catch (IOException e) {
            this.enterprisesList = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.enterprisesList); //para guardarlo "lindo" en el archivo json
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Enterprise> toList() {
        load();
        System.out.println("hola");
        return this.enterprisesList;
    }

    @Override
    public void add(Enterprise... objeto) {
        load();
        this.enterprisesList.addAll(List.of(objeto));
        save();
    }

    @Override
    public void delete(int id) {
        load();
        for(Enterprise enterprise : this.enterprisesList){
            if(enterprise.getIdUser() == id){
                this.enterprisesList.remove(enterprise);
                break;
            }
        }
        save();
    }

    @Override
    public void modify(Enterprise nuevoObjeto) {
        load();
        for(Enterprise enterprise : this.enterprisesList){
            if(enterprise.getIdUser() == nuevoObjeto.getIdUser()){

                enterprise.setUsername(nuevoObjeto.getUsername());
                enterprise.setEmail(nuevoObjeto.getEmail());
                enterprise.setPassword(nuevoObjeto.getPassword());

                enterprise.setFirstName(nuevoObjeto.getFirstName());
                enterprise.setSurname(nuevoObjeto.getSurname());
                enterprise.setDni(nuevoObjeto.getDni());
                enterprise.setBirthDate(nuevoObjeto.getBirthDate());
                enterprise.setPhoneNumber(nuevoObjeto.getPhoneNumber());
                enterprise.setActive(nuevoObjeto.getActive());

                enterprise.setProvince(nuevoObjeto.getProvince());
                enterprise.setCity(nuevoObjeto.getCity());
                enterprise.setAddress(nuevoObjeto.getAddress());
                enterprise.setPostalCode(nuevoObjeto.getPostalCode());

                enterprise.setFantasyName(nuevoObjeto.getFantasyName());
                break;
            }
        }
        save();
    }
    //endregion

}
